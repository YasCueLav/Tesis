package Controladores;

import Model.Alumno;
import Model.ParametroCondicion;
import Model.VMALumnoCursoPromedios;
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
            ResultSet query = stmt.executeQuery("Select * from Alumnos where visible = 1");
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
            ResultSet query = stmt.executeQuery("SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.seccion FROM Alumnos al join Cursos c on (al.id_curso = c.id_curso) WHERE c.id_curso = "+ curso +"and al.visible = 1 and c.visible = 1");
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
            PreparedStatement stmt = conn.prepareStatement("select * from Alumnos where id_alumno = ? and visible = 1");
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
    //NUEVO
    public ArrayList<Alumno> obtenerAlumnosxLegajo ( int legajo){
        ArrayList<Alumno> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("Select * from Alumnos where visible = 1 and legajo = " + legajo);
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
    
    //AEREGLAR CONEXION
    public boolean modificarAlumno (Alumno a) {
        boolean modifico = true;
        try {
            AccesoDatos ad = new AccesoDatos();
            conn = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
            PreparedStatement stmt = conn.prepareStatement("UPDATE Alumnos SET legajo = ?, nombre = ?, apellido = ?, id_curso = ?, id_condicion = ?, grupo = ? WHERE id_alumno = ?");
            stmt.setInt(1, a.getLegajo());
            stmt.setString(2, a.getNombre());
            stmt.setString(3, a.getApellido());
            stmt.setInt(4, a.getIdCurso());
            stmt.setInt(5, a.getIdCondicion());
            stmt.setInt(6, a.getGrupo());
            stmt.setInt(7, a.getIdAlumno());
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
            PreparedStatement stmt = conn.prepareStatement("UPDATE Alumnos SET visible = 0 WHERE id_alumno = "+ id);
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            modifico = false;
        }
        return modifico;
    }
    
    public boolean agregarAlumno (Alumno a) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Alumnos (legajo, nombre, apellido, id_curso, id_condicion, grupo, fecha_ingreso, visible) VALUES (?,?,?,?,?,?,?,1)");
            stmt.setInt(1, a.getLegajo());
            stmt.setString(2, a.getNombre());
            stmt.setString(3, a.getApellido());
            stmt.setInt(4, a.getIdCurso());
            stmt.setInt(5, a.getIdCondicion());
            stmt.setInt(6, a.getGrupo());
            stmt.setString(7, a.getFechaS());
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
            ResultSet query = stmt.executeQuery("SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.seccion FROM Alumnos al join Cursos c on (al.id_curso = c.id_curso) WHERE al.visible = 1 and c.visible = 1");
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
            ResultSet query = stmt.executeQuery("SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.nombre 'nombrecurso', c.seccion, co.id_condicion, co.condicion, al.fecha_ingreso  FROM Alumnos al join Cursos c ON (al.id_curso = c.id_curso) join Condiciones co ON (al.id_condicion = co.id_condicion) WHERE al.visible = 1 AND c.visible = 1 AND co.visible = 1");
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
//Nuevo
    public ArrayList<VMAlumnosCursosCondiciones> obtenerAlumnoLibresAusencia() {
        ArrayList<VMAlumnosCursosCondiciones> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.nombre 'nombrecurso', c.seccion, co.id_condicion, co.condicion, al.fecha_ingreso  FROM Alumnos al join Cursos c ON (al.id_curso = c.id_curso) join Condiciones co ON (al.id_condicion = co.id_condicion) WHERE al.visible = 1 AND c.visible = 1 AND co.visible = 1  AND co.id_condicion = 5");
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
//Nuevo
    public ArrayList<VMAlumnosCursosCondiciones> obtenerAlumnoLibreNoCumplimiento() {
        ArrayList<VMAlumnosCursosCondiciones> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.nombre 'nombrecurso', c.seccion, co.id_condicion, co.condicion, al.fecha_ingreso  FROM Alumnos al join Cursos c ON (al.id_curso = c.id_curso) join Condiciones co ON (al.id_condicion = co.id_condicion) WHERE al.visible = 1 AND c.visible = 1 AND co.visible = 1  AND co.id_condicion = 4");
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
//Nuevo
    public ArrayList<VMAlumnosCursosCondiciones> obtenerAlumnoRegular() {
        ArrayList<VMAlumnosCursosCondiciones> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.nombre 'nombrecurso', c.seccion, co.id_condicion, co.condicion, al.fecha_ingreso  FROM Alumnos al join Cursos c ON (al.id_curso = c.id_curso) join Condiciones co ON (al.id_condicion = co.id_condicion) WHERE al.visible = 1 AND c.visible = 1 AND co.visible = 1  AND co.id_condicion = 3");
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
//Nuevo
    public ArrayList<VMAlumnosCursosCondiciones> obtenerAlumnoAprobadoDirecto() {
        ArrayList<VMAlumnosCursosCondiciones> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.nombre 'nombrecurso', c.seccion, co.id_condicion, co.condicion, al.fecha_ingreso  FROM Alumnos al join Cursos c ON (al.id_curso = c.id_curso) join Condiciones co ON (al.id_condicion = co.id_condicion) WHERE al.visible = 1 AND c.visible = 1 AND co.visible = 1  AND co.id_condicion = 1");
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
//Nuevo
    public ArrayList<VMAlumnosCursosCondiciones> obtenerAlumnoPromocionSistemas() {
        ArrayList<VMAlumnosCursosCondiciones> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("SELECT al.id_alumno, al.legajo, al.apellido, al.nombre, c.id_curso, c.nombre 'nombrecurso', c.seccion, co.id_condicion, co.condicion, al.fecha_ingreso  FROM Alumnos al join Cursos c ON (al.id_curso = c.id_curso) join Condiciones co ON (al.id_condicion = co.id_condicion) WHERE al.visible = 1 AND c.visible = 1 AND co.visible = 1  AND co.id_condicion = 2");
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
//Nuevo
    public VMALumnoCursoPromedios obtenerAlumnoDatosVs( int id) {
        VMALumnoCursoPromedios lista = new VMALumnoCursoPromedios();
        double t =0 ;
        double n =0 ;
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("EXEC pa_Alumnos_Datos @idAlumno = "+id);
            while (query.next()) {
                //VMALumnoCursoPromedios vw = new VMALumnoCursoPromedios();
                lista.setIdAlumno(query.getInt("Alumno"));
                lista.setLegajo(query.getInt("legajo"));
                lista.setApellido(query.getString("apellido"));
                lista.setNombre(query.getString("nombre"));
                lista.setIdCurso(query.getInt("Curso"));
                lista.setNombreCurso(query.getString("nombreCurso"));
                lista.setDivicionCurso(query.getString("divicion"));
                lista.setAsistenciaTotal(query.getInt("AsistenciasTomadas"));
                lista.setAistenciaAlumno(query.getInt("CantidadAsistio"));
                lista.setNotaExamen(query.getDouble("NotaParcial"));
                n = query.getDouble("NotaParcial");
                lista.setNotaTFI(query.getDouble("NotaTFI"));
                t = query.getDouble("NotaTFI");
                lista.setPromedioNotas( (n + t)/2);
                //lista.add(vw);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
//Nuevo
    public VMALumnoCursoPromedios obtenerAlumnoDatosVsTP ( int id) {
        VMALumnoCursoPromedios lista = new VMALumnoCursoPromedios();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("EXEC pa_Alumnos_Datos_TP  @idAlumno = "+id);
            while (query.next()) {
                lista.setIdAlumno(query.getInt("id_alumno"));
                lista.setLegajo(query.getInt("legajo"));
                lista.setApellido(query.getString("apellido"));
                lista.setNombre(query.getString("nombre"));
                lista.setIdCurso(query.getInt("Curso"));
                lista.setNombreCurso(query.getString("nombreCurso"));
                lista.setDivicionCurso(query.getString("seccion"));
                lista.setTp(query.getString("tp"));
                lista.setPresentado(query.getBoolean("presentado"));
                lista.setFechaEntrega(query.getDate("fecha_entrega"));
                lista.setFechaEntregado(query.getDate("fecha_entregado"));
                lista.setEsatdo(query.getString("estado"));
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