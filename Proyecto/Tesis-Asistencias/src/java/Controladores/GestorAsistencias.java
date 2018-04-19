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

    public GestorAsistencias() {
        AccesoDatos ad = new AccesoDatos();
        try {
            conn = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Asistencias> obtenerAsistencias() {
        ArrayList<Asistencias> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("Select * from Asistencias where visible = 0");
            while (query.next()) {
                Asistencias a = new Asistencias();
                a.setIdAsistencias(query.getInt("id_asistencia"));
                a.setIdAlumno(query.getInt("id_alumno"));
                a.setFechaReguistro(query.getDate("fecha_registro"));
                a.setEstaPresente(query.getBoolean("esta_Precente"));
                a.setFechaObligatoria(query.getBoolean("obligatoria"));
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

    public Asistencias obtenerAsistencias(int id) {
        Asistencias a = new Asistencias();
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from Asistencias where id_asistencia = ?");
            stmt.setInt(1, id);
            ResultSet query = stmt.executeQuery();
            if (query.next()) {
                a.setIdAsistencias(query.getInt("id_asistencia"));
                a.setIdAlumno(query.getInt("id_alumno"));
                a.setFechaReguistro(query.getDate("fecha_registro"));
                a.setEstaPresente(query.getBoolean("esta_Precente"));
                a.setFechaObligatoria(query.getBoolean("obligatoria"));
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
    public boolean modificarAsistencias(Asistencias a) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("");
            stmt.setInt(1, a.getIdAsistencias());
            stmt.setInt(2, a.getIdAlumno());
            stmt.setDate(3, a.getFechaReguistro());
            stmt.setBoolean(4, a.isEstaPresente());
            stmt.setBoolean(5, a.isFechaObligatoria());
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
    public boolean elimniarAsistencias(Asistencias a, int id) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("");
            stmt.setBoolean(1, a.isVisible());
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
    public boolean agregarAsistencias(Asistencias a) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("");
            stmt.setInt(1, a.getIdAsistencias());
            stmt.setInt(2, a.getIdAlumno());
            stmt.setDate(3, a.getFechaReguistro());
            stmt.setBoolean(4, a.isEstaPresente());
            stmt.setBoolean(5, a.isFechaObligatoria());
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
