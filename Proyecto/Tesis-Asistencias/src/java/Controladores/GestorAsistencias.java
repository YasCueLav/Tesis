/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Model.Asistencias;
import Model.VMAlumnosCursos;
import Model.VMAsistenciaAlumnoCurso;
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

    public ArrayList<Asistencias> obtenerAsistenciasTodas() {
        ArrayList<Asistencias> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("Select * from Asistencias where visible = 1");
            while (query.next()) {
                Asistencias a = new Asistencias();
                a.setIdAsistencias(query.getInt("id_asistencia"));
                a.setIdAlumno(query.getInt("id_alumno"));
                a.setFechaReguistro(query.getDate("fecha_registro"));
                a.setEstaPresente(query.getInt("esta_Precente"));
                a.setFechaObligatoria(query.getInt("obligatoria"));
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
                a.setEstaPresente(query.getInt("esta_Precente"));
                a.setFechaObligatoria(query.getInt("obligatoria"));
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return a;
    }

    public boolean modificarAsistencias(Asistencias a) {
        boolean modifico = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE Asistencias SET esta_Precente = ? WHERE id_asistencia = ?");
            stmt.setBoolean(1, a.isEstaPresente());
            stmt.setInt(2, a.getIdAsistencias());
            stmt.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            modifico = false;
        }
        return modifico;
    }
    /*/TERMINAR
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
    */
    public boolean agregarAsistencias(ArrayList<Asistencias> asistencias) {
        boolean inserto = true;
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Asistencias (id_alumno,fecha_registro,esta_Precente,obligatoria,visible) VALUES (?,GETDATE(),?,?,1)");
            for (Asistencias a : asistencias) {
                stmt.setInt(1, a.getIdAlumno());
                //stmt.setDate(2, a.getFechaReguistro());
                stmt.setBoolean(2, a.isEstaPresente());
                stmt.setBoolean(3, a.isFechaObligatoria());
                stmt.executeUpdate();
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            inserto = false;
        }
        return inserto;
    }
    
    public ArrayList<VMAsistenciaAlumnoCurso> obtenerAsistenciasAlumnoCursoTodos() {
        ArrayList<VMAsistenciaAlumnoCurso> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("SELECT a.id_asistencia,al.id_alumno,al.legajo,al.apellido,al.nombre,c.seccion,a.esta_Precente,a.obligatoria, a.fecha_registro FROM  Asistencias a JOIN Alumnos al ON (a.id_alumno = al.id_alumno) JOIN Cursos c ON (al.id_curso = c.id_curso) WHERE a.visible = 1 AND al.visible = 1 AND c.visible = 1");
            while (query.next()) {
                VMAsistenciaAlumnoCurso vm = new VMAsistenciaAlumnoCurso();
                vm.setIdAsistencias(query.getInt("id_asistencia"));
                vm.setIdAlumno(query.getInt("id_alumno"));
                vm.setLegajo(query.getInt("legajo"));
                vm.setApellido(query.getString("apellido"));
                vm.setNombre(query.getString("nombre"));
                vm.setDivicionCurso(query.getString("seccion"));
                vm.setEstaPresente(query.getBoolean("esta_Precente"));
                vm.setFechaObligatoria(query.getBoolean("obligatoria"));
                vm.setFechaReguistro(query.getDate("fecha_registro"));
                lista.add(vm);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public VMAsistenciaAlumnoCurso obtenerAsistenciasAlumnoCursoID( int id) {
        VMAsistenciaAlumnoCurso vm = new VMAsistenciaAlumnoCurso();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT a.id_asistencia, al.id_alumno,al.legajo,al.apellido,al.nombre,c.seccion,a.esta_Precente,a.obligatoria, a.fecha_registro FROM  Asistencias a JOIN Alumnos al ON (a.id_alumno = al.id_alumno) JOIN Cursos c ON (al.id_curso = c.id_curso) WHERE a.id_asistencia = ? AND a.visible = 1 AND al.visible = 1 AND c.visible = 1");
            stmt.setInt(1, id);
            ResultSet query = stmt.executeQuery();
                if(query.next()){
                    vm.setIdAsistencias(query.getInt("id_asistencia"));
                    vm.setIdAlumno(query.getInt("id_alumno"));
                    vm.setLegajo(query.getInt("legajo"));
                    vm.setApellido(query.getString("apellido"));
                    vm.setNombre(query.getString("nombre"));
                    vm.setDivicionCurso(query.getString("seccion"));
                    vm.setEstaPresente(query.getBoolean("esta_Precente"));
                    vm.setFechaObligatoria(query.getBoolean("obligatoria"));
                    vm.setFechaReguistro(query.getDate("fecha_registro"));
                }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return vm;
    }
  
    public ArrayList<VMAsistenciaAlumnoCurso> obtenerAsistenciasAlumnoCursoFiltroLegajo(int leg) {
        ArrayList<VMAsistenciaAlumnoCurso> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("SELECT a.id_asistencia,al.id_alumno,al.legajo,al.apellido,al.nombre,c.seccion,a.esta_Precente,a.obligatoria, a.fecha_registro FROM  Asistencias a JOIN Alumnos al ON (a.id_alumno = al.id_alumno) JOIN Cursos c ON (al.id_curso = c.id_curso) WHERE a.visible = 1 AND al.visible = 1 AND c.visible = 1 AND al.legajo = "+ leg);
            while (query.next()) {
                VMAsistenciaAlumnoCurso vm = new VMAsistenciaAlumnoCurso();
                vm.setIdAsistencias(query.getInt("id_asistencia"));
                vm.setIdAlumno(query.getInt("id_alumno"));
                vm.setLegajo(query.getInt("legajo"));
                vm.setApellido(query.getString("apellido"));
                vm.setNombre(query.getString("nombre"));
                vm.setDivicionCurso(query.getString("seccion"));
                vm.setEstaPresente(query.getBoolean("esta_Precente"));
                vm.setFechaObligatoria(query.getBoolean("obligatoria"));
                vm.setFechaReguistro(query.getDate("fecha_registro"));
                lista.add(vm);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    public ArrayList<VMAsistenciaAlumnoCurso> obtenerAsistenciasAlumnoCursoFiltroCurso(int idCurso) {
        ArrayList<VMAsistenciaAlumnoCurso> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("SELECT a.id_asistencia,al.id_alumno,al.legajo,al.apellido,al.nombre,c.seccion,a.esta_Precente,a.obligatoria, a.fecha_registro FROM  Asistencias a JOIN Alumnos al ON (a.id_alumno = al.id_alumno) JOIN Cursos c ON (al.id_curso = c.id_curso) WHERE a.visible = 1 AND al.visible = 1 AND c.visible = 1 AND al.id_curso = "+ idCurso);
            while (query.next()) {
                VMAsistenciaAlumnoCurso vm = new VMAsistenciaAlumnoCurso();
                vm.setIdAsistencias(query.getInt("id_asistencia"));
                vm.setIdAlumno(query.getInt("id_alumno"));
                vm.setLegajo(query.getInt("legajo"));
                vm.setApellido(query.getString("apellido"));
                vm.setNombre(query.getString("nombre"));
                vm.setDivicionCurso(query.getString("seccion"));
                vm.setEstaPresente(query.getBoolean("esta_Precente"));
                vm.setFechaObligatoria(query.getBoolean("obligatoria"));
                vm.setFechaReguistro(query.getDate("fecha_registro"));
                lista.add(vm);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }
  
    public ArrayList<VMAsistenciaAlumnoCurso> obtenerAsistenciasAlumnoCursoFiltroLegajoCurso( int leg, int idCurso) {
        ArrayList<VMAsistenciaAlumnoCurso> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("SELECT a.id_asistencia,al.id_alumno,al.legajo,al.apellido,al.nombre,c.seccion,a.esta_Precente,a.obligatoria, a.fecha_registro FROM  Asistencias a JOIN Alumnos al ON (a.id_alumno = al.id_alumno) JOIN Cursos c ON (al.id_curso = c.id_curso) WHERE a.visible = 1 AND al.visible = 1 AND c.visible = 1 AND al.legajo ="+ leg+" AND al.id_curso = "+ idCurso);
            while (query.next()) {
                VMAsistenciaAlumnoCurso vm = new VMAsistenciaAlumnoCurso();
                vm.setIdAsistencias(query.getInt("id_asistencia"));
                vm.setIdAlumno(query.getInt("id_alumno"));
                vm.setLegajo(query.getInt("legajo"));
                vm.setApellido(query.getString("apellido"));
                vm.setNombre(query.getString("nombre"));
                vm.setDivicionCurso(query.getString("seccion"));
                vm.setEstaPresente(query.getBoolean("esta_Precente"));
                vm.setFechaObligatoria(query.getBoolean("obligatoria"));
                vm.setFechaReguistro(query.getDate("fecha_registro"));
                lista.add(vm);
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
