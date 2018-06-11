/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Model.TiposExamenes;
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
public class GestorTiposExamenes {
    private Connection conn;
    
    public GestorTiposExamenes (){
        AccesoDatos ad = new AccesoDatos();
        try {
            conn = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<TiposExamenes> obtenerTiposExamenes (){
        ArrayList<TiposExamenes> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("Select * from Tipos_Examenes where visible = 1");
            while (query.next()){
                TiposExamenes te = new TiposExamenes();
                te.setIdTipoExamne(query.getInt("id_tipo_examen"));
                te.setTipoExamen(query.getString("tipo_examen"));
                lista.add(te);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public TiposExamenes obtenerTipoExamen (int id) {
        TiposExamenes te = new TiposExamenes();
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from Tipos_Examenes where id_tipo_examen = ? and visible = 1");
            stmt.setInt(1, id);
            ResultSet query = stmt.executeQuery();
            if (query.next()) {
                te.setIdTipoExamne(query.getInt("id_tipo_examen"));
                te.setTipoExamen(query.getString("tipo_examen"));
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return te;
    }
}
