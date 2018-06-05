package Controladores;

import Model.Alumno;
import Model.VMAlumnosCursos;
import Model.VMAlumnosCursosCondiciones;
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
            conn = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
        } catch (SQLException e) {
            System.out.println(e);
        }
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
                a.setFechaIngreso(query.getDate("fecha_ingreso"));
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
    
    public ArrayList<VMAlumnosCursos> obtenerAlumnosXCurso(int curso) {
        ArrayList<VMAlumnosCursos> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.seccion FROM Alumnos al join Cursos c on (al.id_curso = c.id_curso) WHERE c.id_curso = "+ curso +"and al.visible = 0 and c.visible = 0");
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
        } catch (SQLException e) {
            System.out.println(e.toString());
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
            PreparedStatement stmt = conn.prepareStatement("UPDATE Alumnos SET legajo = ?, nombre = ?, apellido = ?, id_curso = ?, id_condicion = ?, grupo = ?, fecha_ingreso = ? WHERE id_alumno = ?");
            stmt.setInt(1, a.getLegajo());
            stmt.setString(2, a.getNombre());
            stmt.setString(3, a.getApellido());
            stmt.setInt(4, a.getIdCurso());
            stmt.setInt(5, a.getIdCondicion());
            stmt.setInt(6, a.getGrupo());
            stmt.setDate(7, a.getFechaIngreso());
            stmt.setInt(8, a.getIdAlumno());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            modifico = false;
        }
        return modifico;
    }
    
    public boolean elimniarAlumno ( int id) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Alumnos SET visible = 1 WHERE id_alumno = "+ id);
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
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Alumnos (legajo, nombre, apellido, id_curso, id_condicion, grupo, fecha_ingreso, visible) VALUES (?,?,?,?,?,?,?,0)");
            stmt.setInt(1, a.getLegajo());
            stmt.setString(2, a.getNombre());
            stmt.setString(3, a.getApellido());
            stmt.setInt(4, a.getIdCurso());
            stmt.setInt(5, a.getIdCondicion());
            stmt.setInt(6, a.getGrupo());
            stmt.setDate(7, a.getFechaIngreso());
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
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public ArrayList<VMAlumnosCursosCondiciones> obtenerAlumnoCursoCondiciones() {
        ArrayList<VMAlumnosCursosCondiciones> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.nombre 'nombrecurso', c.seccion, co.id_condicion, co.condicion, al.fecha_ingreso  FROM Alumnos al join Cursos c ON (al.id_curso = c.id_curso) join Condiciones co ON (al.id_condicion = co.id_condicion) WHERE al.visible = 0 AND c.visible = 0 AND co.visible = 0");
            while (query.next()) {
                VMAlumnosCursosCondiciones vw = new VMAlumnosCursosCondiciones();
                vw.setIdAlumno(query.getInt("id_alumno"));
                vw.setLegajo(query.getInt("legajo"));
                vw.setApellido(query.getString("apellido"));
                vw.setNombre(query.getString("nombre"));
                vw.setIdCurso(query.getInt("id_curso"));
                vw.setNombreCurso(query.getString("nombrecurso"));
                vw.setDivicionCurso(query.getString("seccion"));
                vw.setIdcondicion(query.getInt("id_condicion"));
                vw.setCondicion(query.getString("condicion"));
                vw.setFecha(query.getDate("fecha_ingreso"));
                lista.add(vw);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
}

