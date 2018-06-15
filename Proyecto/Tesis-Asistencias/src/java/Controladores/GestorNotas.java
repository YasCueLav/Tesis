/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Model.Notas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Yasmin
 */
public class GestorNotas {
    private Connection conn;
    
    public GestorNotas (){
        AccesoDatos ad = new AccesoDatos();
        try {
            conn = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Notas> obtenerNotas (){
        ArrayList<Notas> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("Select * from Notas where visible = 1");
            while (query.next()){
                Notas n = new Notas();
                n.setIdNota(query.getInt("id_nota"));
                n.setIdAlumno(query.getInt("id_alumno"));
                n.setIdExamen(query.getInt("id_examen"));
                n.setIdTp(query.getInt("id_tp"));
                n.setNota(query.getDouble("nota"));
                lista.add(n);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public Notas obtenerNota (int id) {
        Notas n = new Notas();
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from Notas where id_nota = ? and visible = 1");
            stmt.setInt(1, id);
            ResultSet query = stmt.executeQuery();
            if (query.next()) {
                n.setIdNota(query.getInt("id_nota"));
                n.setIdAlumno(query.getInt("id_alumno"));
                n.setIdExamen(query.getInt("id_examen"));
                n.setIdTp(query.getInt("id_tp"));
                n.setNota(query.getDouble("nota"));
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return n;
    }
    
    public boolean modificarNotas (Notas n) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Notas SET id_examen = ?, nota = ? WHERE id_nota = ?");
            stmt.setInt(1, n.getIdExamen());
            stmt.setDouble(2, n.getNota());
            stmt.setInt(3, n.getIdNota());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            modifico = false;
        }
        return modifico;
    }
    
    public boolean elimniarNota (int id) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Notas SET visible = 0 WHERE id_nota = "+ id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            modifico = false;
        }
        return modifico;
    }
    
    public boolean agregarNotaParcial (ArrayList<Notas> notas) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("insert into Notas (id_alumno,id_examen,nota,visible) values (?,?,?,1)");
            for (Notas n : notas) {
                stmt.setInt(1, n.getIdAlumno());
                stmt.setInt(2, n.getIdExamen());
                stmt.setDouble(3, n.getNota());
                stmt.executeUpdate();
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            inserto = false;
        }
        return inserto;
    }
    
    public boolean agregarNotaTPs ( ArrayList<Notas> notas) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Notas(nota, id_alumno,id_tp, visible) VALUES (?,?,?,1)");
            for (Notas n : notas) {
                stmt.setDouble(1, n.getNota());
                stmt.setInt(2, n.getIdAlumno());
                stmt.setInt(3, n.getIdTp());
                stmt.executeUpdate();
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            inserto = false;
        }
        return inserto;
    }
}
