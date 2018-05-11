/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Model.Cursos;
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
public class GestorCursos {
    private Connection conn;
    
    public GestorCursos (){
        AccesoDatos ad = new AccesoDatos();
        try {
            conn = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("2 - a");
    }
    
    public ArrayList<Cursos> obtenerCursos (){
        ArrayList<Cursos> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("Select id_curso , nombre , seccion from Cursos where visible = 0");
            System.out.println("2 - b");
            while (query.next()){
                Cursos c = new Cursos();
                c.setIdCursos(query.getInt("id_curso"));
                c.setNombreCurso(query.getString("nombre"));
                c.setSeccionCurso(query.getString("seccion"));
                lista.add(c);
            }
            System.out.println("2 - c");
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public Cursos obtenerCursoConID (int id) {
        Cursos c = new Cursos();
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from Cursos where id_curso = ? and visible = 0");
            stmt.setInt(1, id);
            ResultSet query = stmt.executeQuery();
            if (query.next()) {
                c.setIdCursos(query.getInt("id_curso"));
                c.setNombreCurso(query.getString("nombre"));
                c.setSeccionCurso(query.getString("seccion"));
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c;
    }
    //TERMINAR
    public boolean elimniarCurso (Cursos c, int id) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("");
            stmt.setBoolean(1, c.isVisible());
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
    public boolean agregarAlumno (Cursos c) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("");
            stmt.setString(1, c.getNombreCurso());
            stmt.setString(2, c.getSeccionCurso());
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
