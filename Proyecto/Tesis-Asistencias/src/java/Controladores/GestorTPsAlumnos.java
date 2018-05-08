/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Model.TpsAlumnos;
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
public class GestorTPsAlumnos {

    private Connection conn;
    
    public GestorTPsAlumnos (){
        AccesoDatos ad = new AccesoDatos();
        try {
            conn = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<TpsAlumnos> obtenerTPsAlumnos (){
        ArrayList<TpsAlumnos> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("Select * from Tp_Alumnos where visible = 0");
            while (query.next()){
                TpsAlumnos ta = new TpsAlumnos();
                ta.setIdTpAlumno(query.getInt("id_tp_alumno"));
                ta.setIdTp(query.getInt("id_tp"));
                ta.setIdAlumno(query.getInt("id_alumno"));
                ta.setPresentado(query.getInt("presentado"));
                lista.add(ta);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public TpsAlumnos obtenerTPsAlumnos (int id) {
        TpsAlumnos ta = new TpsAlumnos();
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from Alumnos where id_tp_alumno = ? and visible = 0");
            stmt.setInt(1, id);
            ResultSet query = stmt.executeQuery();
            if (query.next()) {
                ta.setIdTpAlumno(query.getInt("id_tp_alumno"));
                ta.setIdTp(query.getInt("id_tp"));
                ta.setIdAlumno(query.getInt("id_alumno"));
                ta.setPresentado(query.getInt("presentado"));
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return ta;
    }
    //TERMINAR
    public boolean modificarTPsAlumnos (TpsAlumnos ta) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("");
            stmt.setInt(1, ta.getIdTpAlumno());
            stmt.setInt(2, ta.getIdTp());
            stmt.setInt(3, ta.getIdAlumno());
            stmt.setBoolean(4, ta.isPresentado());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            modifico = false;
        }
        return modifico;
    }
    //TERMINAR
    public boolean agregarTPsAlumnos (TpsAlumnos ta) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Tp_Alumnos(id_tp,id_alumno, presentado, visible) VALUES (?, ?,?,0)");
            stmt.setInt(1, ta.getIdTp());
            stmt.setInt(2, ta.getIdAlumno());
            stmt.setBoolean(3, ta.isPresentado());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            inserto = false;
        }
        return inserto;
    }
}
