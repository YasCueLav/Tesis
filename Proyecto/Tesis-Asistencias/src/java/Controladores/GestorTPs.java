/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Model.TPs;
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
public class GestorTPs {
    
    private Connection conn;
    
    public GestorTPs (){
        AccesoDatos ad = new AccesoDatos();
        try {
            conn = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<TPs> obtenerTPs (){
        ArrayList<TPs> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("Select * from Trabajos_Practicos where visible = 1");
            while (query.next()){
                TPs t = new TPs();
                t.setIdTp(query.getInt("id_tp"));
                t.setNombreTp(query.getString("nombre"));
                lista.add(t);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public TPs obtenerTPs (int id) {
        TPs t = new TPs();
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from Trabajos_Practicos where id_tp = ? and visible = 1");
            stmt.setInt(1, id);
            ResultSet query = stmt.executeQuery();
            if (query.next()) {
                t.setIdTp(query.getInt("id_tp"));
                t.setNombreTp(query.getString("nombre"));
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return t;
    }
    
    public boolean agregarExamen (TPs t) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Trabajos_Practicos (nombre, visible) VALUES (?,1)");
            stmt.setString(1, t.getNombreTp());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            inserto = false;
        }
        return inserto;
    }
     public boolean elimniarTP(int id) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Trabajos_Practicos SET visible = 0 WHERE id_tp = "+ id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            modifico = false;
        }
        return modifico;
    }
     public boolean ModificarTP(TPs t) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Trabajos_Practicos SET nombre = ? WHERE id_tp = ?");
            stmt.setString(1, t.getNombreTp());
            stmt.setInt(2, t.getIdTp());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            modifico = false;
        }
        return modifico;
    }
}