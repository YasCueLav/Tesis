/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Model.Examenes;
import Model.VMTipoExamenExamen;
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
public class GestorExamenes {
    
    private Connection conn;
    
    public GestorExamenes (){
        AccesoDatos ad = new AccesoDatos();
        try {
            conn = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("1 - a");
    }
    
    public ArrayList<Examenes> obtenerExamenes (){
        ArrayList<Examenes> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("Select * from Examenes where visible = 0");
            while (query.next()){
                Examenes e = new Examenes();
                e.setIdExamen(query.getInt("id_examen"));
                e.setIdTipoExamne(query.getInt("id_tipo_examen"));
                e.setExamenNombre(query.getString("examen"));
                e.setFechaExamen(query.getDate("fecha_examen"));
                lista.add(e);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public Examenes obtenerExamen (int id) {
        Examenes e = new Examenes();
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from Examenes where id_examen = ? and visible = 0");
            stmt.setInt(1, id);
            ResultSet query = stmt.executeQuery();
            if (query.next()) {
                e.setIdExamen(query.getInt("id_examen"));
                e.setIdTipoExamne(query.getInt("id_tipo_examen"));
                e.setExamenNombre(query.getString("examen"));
                e.setFechaExamen(query.getDate("fecha_examen"));
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return e;
    }

    public ArrayList<VMTipoExamenExamen> obtenerTodosExamenes (){
        ArrayList<VMTipoExamenExamen> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("select e.id_examen,t.id_tipo_examen,t.tipo_examen,e.examen,e.fecha_examen from Examenes e join Tipos_Examenes t on (e.id_tipo_examen = t.id_tipo_examen) where e.visible = 0 and t.visible = 0");
            while (query.next()){
                VMTipoExamenExamen vm = new VMTipoExamenExamen();
                vm.setIdExamen(query.getInt("id_examen"));
                vm.setIdTipoExamen(query.getInt("id_tipo_examen"));
                vm.setTipoExamne(query.getString("tipo_examen"));
                vm.setExamenNombre(query.getString("examen"));
                vm.setFecha(query.getDate("fecha_examen"));
                lista.add(vm);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public VMTipoExamenExamen obtenerVMExamenes (int id){
         VMTipoExamenExamen vm = new VMTipoExamenExamen();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("select e.id_examen,t.id_tipo_examen, t.tipo_examen,e.examen,e.fecha_examen from Examenes e join Tipos_Examenes t on (e.id_tipo_examen = t.id_tipo_examen) where e.visible = 0 and t.visible = 0 and e.id_examen = "+ id);
                vm.setIdExamen(query.getInt("id_examen"));
                vm.setIdTipoExamen(query.getInt("id_tipo_examen"));
                vm.setTipoExamne(query.getString("tipo_examen"));
                vm.setExamenNombre(query.getString("examen"));
                vm.setFecha(query.getDate("fecha_examen"));
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vm;
    }
    
    public boolean agregarExamen (Examenes e) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Examenes (id_tipo_examen, examen, fecha_examen, visible) VALUES (?,?,?,0)");
            stmt.setInt(1, e.getIdTipoExamne());
            stmt.setString(2, e.getExamenNombre());
            stmt.setString(3, e.getFecha());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            inserto = false;
        }
        return inserto;
    }
    
    public boolean elimniarExamen(int id) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Examenes SET visible = 1 WHERE id_examen = "+ id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            modifico = false;
        }
        return modifico;
    }
    
    public boolean modificarExamenConFecha (Examenes e) {
        boolean modificar = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Examenes SET id_tipo_examen = ?, examen = ?,fecha_examen = ? WHERE id_examen = ?");
            stmt.setInt(1, e.getIdTipoExamne());
            stmt.setString(2, e.getExamenNombre());
            stmt.setString(3, e.getFecha());
            stmt.setInt(4, e.getIdExamen());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            modificar = false;
        }
        return modificar;
    }
    public boolean modificarExamenSinFecha (Examenes e) {
        boolean modificar = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Examenes SET id_tipo_examen = ?, examen = ? WHERE id_examen = ?");
            stmt.setInt(1, e.getIdTipoExamne());
            stmt.setString(2, e.getExamenNombre());
            stmt.setInt(3, e.getIdExamen());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            modificar = false;
        }
        return modificar;
    }
}