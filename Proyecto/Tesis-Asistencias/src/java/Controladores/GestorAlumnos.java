package Controladores;

import Model.Alumno;
import Model.VMAlumnosCursos;
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
public class GestorAlumnos {
    
    private Connection conn;
    
    public GestorAlumnos (){
        AccesoDatos ad = new AccesoDatos();
        try {
            System.out.println("estoy en try acceso db");
            conn = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("3 - a");
    }
    
    public ArrayList<Alumno> obtenerAlumnos (){
        ArrayList<Alumno> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("Select * from Alumnos where visible = 0");
            while (query.next()){
                Alumno a = new Alumno();
                a.setIdAlumno(query.getInt("id_alumno"));
                a.setLegajo(query.getInt("legajo"));
                a.setNombre(query.getString("nombre"));
                a.setApellido(query.getString("apellido"));
                a.setIdCurso(query.getInt("id_curso"));
                a.setIdCondicion(query.getInt("id_condicion"));
                a.setGrupo(query.getInt("grupo"));
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
    
    public Alumno obtenerAlumno (int id) {
        Alumno a = new Alumno();
        try {
            PreparedStatement stmt = conn.prepareStatement("select * from Alumnos where id_alumno = ? and visible = 0");
            stmt.setInt(1, id);
            ResultSet query = stmt.executeQuery();
            if (query.next()) {
                a.setIdAlumno(query.getInt("id_alumno"));
                a.setLegajo(query.getInt("legajo"));
                a.setNombre(query.getString("nombre"));
                a.setApellido(query.getString("apellido"));
                a.setIdCurso(query.getInt("id_curso"));
                a.setIdCondicion(query.getInt("id_condicion"));
                a.setGrupo(query.getInt("grupo"));
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
    public boolean modificarAlumno (Alumno a) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("");
            stmt.setInt(1, a.getIdAlumno());
            stmt.setInt(2, a.getLegajo());
            stmt.setString(3, a.getNombre());
            stmt.setString(4, a.getApellido());
            stmt.setInt(5, a.getIdCondicion());
            stmt.setInt(6, a.getGrupo());
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
    public boolean elimniarAlumno (Alumno a, int id) {
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
    public boolean agregarAlumno (Alumno a) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("");
            stmt.setInt(1, a.getIdAlumno());
            stmt.setInt(2, a.getLegajo());
            stmt.setString(3, a.getNombre());
            stmt.setString(4, a.getApellido());
            stmt.setInt(5, a.getIdCondicion());
            stmt.setInt(6, a.getGrupo());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            inserto = false;
        }
        return inserto;
    }

    public ArrayList<VMAlumnosCursos> obtenerAlumnoCurso() {
        ArrayList<VMAlumnosCursos> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.seccion FROM Alumnos al join Cursos c on (al.id_curso = c.id_curso) WHERE al.visible = 0 and c.visible =0");
            System.out.println("3 - b");
            while (query.next()) {
                VMAlumnosCursos vw = new VMAlumnosCursos();
                vw.setIdAlumno(query.getInt("id_alumno"));
                vw.setLegajo(query.getInt("legajo"));
                vw.setApellido(query.getString("apellido"));
                vw.setNombre(query.getString("nombre"));
                vw.setIdCurso(query.getInt("id_curso"));
                vw.setDivicionCurso(query.getString("seccion"));
                lista.add(vw);
            }
            query.close();
            stmt.close();
            conn.close();
            System.out.println("3 - c");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
}

