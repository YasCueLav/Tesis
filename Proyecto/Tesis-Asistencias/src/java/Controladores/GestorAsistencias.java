/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Model.Asistencias;
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
public class GestorAsistencias {
    private Connection conn;
    
    public GestorAsistencias (){
        AccesoDatos ad = new AccesoDatos();
        try {
            conn = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<Asistencias> obtenerAsistencias (){
        ArrayList<Asistencias> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("Select * from Asistencias where visible = 0");
            while (query.next()){
                Asistencias a = new Asistencias();
//                a.setIdAlumno(query.getInt("id_alumno"));
//                a.setLegajo(query.getInt("legajo"));
//                a.setNombre(query.getString("nombre"));
//                a.setApellido(query.getString("apellido"));
//                a.setIdCurso(query.getInt("id_curso"));
//                a.setIdCondicion(query.getInt("id_condicion"));
//                a.setGrupo(query.getInt("grupo"));
                lista.add(a);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public Asistencias obtenerAsistencias (int id) {
        Asistencias a = new Asistencias();
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from Asistencias where id_asistencia = ?");
            stmt.setInt(1, id);
            ResultSet query = stmt.executeQuery();
            if (query.next()) {
//                a.setIdAlumno(query.getInt("id_alumno"));
//                a.setLegajo(query.getInt("legajo"));
//                a.setNombre(query.getString("nombre"));
//                a.setApellido(query.getString("apellido"));
//                a.setIdCurso(query.getInt("id_curso"));
//                a.setIdCondicion(query.getInt("id_condicion"));
//                a.setGrupo(query.getInt("grupo"));
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return a;
    }
    //TERMINAR
    public boolean modificarAsistencias (Asistencias a) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("");
//            stmt.setInt(1, a.getIdAlumno());
//            stmt.setInt(2, a.getLegajo());
//            stmt.setString(3, a.getNombre());
//            stmt.setString(4, a.getApellido());
//            stmt.setInt(5, a.getIdCondicion());
//            stmt.setInt(6, a.getGrupo());
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
    public boolean elimniarAsistencias (Asistencias a, int id) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("");
//            stmt.setBoolean(1, a.isVisible());
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
    public boolean agregarAsistencias (Asistencias a) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("");
//            stmt.setInt(1, a.getIdAlumno());
//            stmt.setInt(2, a.getLegajo());
//            stmt.setString(3, a.getNombre());
//            stmt.setString(4, a.getApellido());
//            stmt.setInt(5, a.getIdCondicion());
//            stmt.setInt(6, a.getGrupo());
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
