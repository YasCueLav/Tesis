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
            ResultSet query = stmt.executeQuery("Select * from Trabajos_Practicos where visible = 0");
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
            PreparedStatement stmt = conn.prepareStatement("select * from Trabajos_Practicos where id_tp = ? and visible = 0");
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
    
}
