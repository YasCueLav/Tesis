/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Model.Condiciones;
import Model.ParametroCondicion;
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
            ResultSet query = stmt.executeQuery("Select id_condicion , condicion from Condiciones where visible = 1");
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
            PreparedStatement stmt = conn.prepareStatement("select * from Condiciones where id_condicion = ? and visible = 1");
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
  
    public boolean agregarCondiciones (Condiciones c) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Condiciones (condicion, visible) VALUES (?,1)");
            stmt.setString(1, c.getCondicion());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            inserto = false;
        }
        return inserto;
    }
    
    public boolean modificarCondiciones (Condiciones c) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Condiciones SET condicion = ? WHERE id_condicion = ?");
            stmt.setString(1, c.getCondicion());
            stmt.setInt(2, c.getIdCondicion());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            inserto = false;
        }
        return inserto;
    }
    
    public boolean eliminarCondiciones (int id) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Condiciones SET visible = 0 WHERE id_condicion = "+ id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            inserto = false;
        }
        return inserto;
    }
    /*-----------------------------------------------------------*/
    public ArrayList<ParametroCondicion> obtenerParametrosCondiciones (int[] id) {
        ArrayList<ParametroCondicion> lista = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement("EXEC pa_Parametros_Para_Condiciones @idAlumno = ?");
            for (int i = 0; i < id.length; i++) {
                stmt.setInt(1, id[i]);
                ResultSet query = stmt.executeQuery();
                ParametroCondicion pc = new ParametroCondicion();
                if (query.next()) {
                    pc.setIdAlmno(query.getInt("Alumno"));
                    pc.setTotalAsistencias(query.getInt("AsistenciasTomadas"));
                    pc.setCantiAsistio(query.getInt("CantidadAsistio"));
                    pc.setNotaParcial(query.getDouble("NotaParcial"));
                    pc.setCantiTpAEntregar(query.getInt("TpAEntregar"));
                    pc.setCantiTpEntregados(query.getInt("TpEntregadoEnFecha"));
                    pc.setNotaTFI(query.getDouble("NotaTFI"));
                    
                }
                query.close();
                lista.add(pc);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        /*SEGUNDA OPCION
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("EXEC pa_Parametros_Para_Condiciones");
            while (query.next()){
                ParametroCondicion pc = new ParametroCondicion();
                pc.setIdAlmno(query.getInt("Alumno"));
                pc.setTotalAsistencias(query.getInt("AsistenciasTomadas"));
                pc.setCantiAsistio(query.getInt("CantidadAsistio"));
                pc.setNotaParcial(query.getDouble("NotaParcial"));
                pc.setCantiTpAEntregar(query.getInt("TpAEntregar"));
                pc.setCantiTpEntregados(query.getInt("TpEntregadoEnFecha"));
                pc.setNotaTFI(query.getDouble("NotaTFI"));
                lista.add(pc);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }*/
        
        return lista;
    }
    //AREGLARO LO DE LA CONEXION
    public boolean modificarCondicionAlumno (int condicion, int id) {
        boolean modifico = true;
        try {
            Connection con;
            AccesoDatos ad = new AccesoDatos();
            con = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
            PreparedStatement stmt = con.prepareStatement("UPDATE Alumnos SET id_condicion = ? WHERE id_alumno = ?");
            stmt.setInt(1, condicion);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            modifico = false;
        }
        return modifico;
    }
}
    
