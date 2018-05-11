/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Model.Condiciones;
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
public class GestorCondiciones {
    private Connection conn;
    
    public GestorCondiciones (){
        AccesoDatos ad = new AccesoDatos();
        try {
            conn = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<Condiciones> obtenerCondiciones (){
        ArrayList<Condiciones> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("Select id_condicion , condicion from Condiciones where visible = 0");
            while (query.next()){
                Condiciones c = new Condiciones();
                c.setIdCondicion(query.getInt("id_condicion"));
                c.setCondicion(query.getString("condicion"));
                lista.add(c);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public Condiciones obtenerCondicionesConID (int id) {
        Condiciones c = new Condiciones();
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from Condiciones where id_condicion = ? and visible = 0");
            stmt.setInt(1, id);
            ResultSet query = stmt.executeQuery();
            if (query.next()) {
                c.setIdCondicion(query.getInt("id_condicion"));
                c.setCondicion(query.getString("condicion"));
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
//    public boolean agregarCondiciones (Condiciones c) {
//        boolean inserto = true;
//        try {
//            PreparedStatement stmt = conn.prepareStatement("");
//            stmt.setString(1, c.getCondicion());
//            stmt.executeUpdate();
//            stmt.close();
//            conn.close();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//            inserto = false;
//        }
//        return inserto;
//    }
}
