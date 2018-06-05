/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Yasmin
 */
public class VMAlumnosCursosCondiciones {
    int idAlumno;
    int legajo;
    String nombre;
    String apellido;
    int idCurso;
    String nombreCurso;
    String divicionCurso;
    int idcondicion;
    String condicion;
    int grupo;
    Date fecha;

    public VMAlumnosCursosCondiciones() {
    }

    public VMAlumnosCursosCondiciones(int idAlumno, int legajo, String nombre, String apellido, int idCurso, String nombreCurso, String divicionCurso, int idcondicion, String condicion, int grupo, Date fecha) {
        this.idAlumno = idAlumno;
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.divicionCurso = divicionCurso;
        this.idcondicion = idcondicion;
        this.condicion = condicion;
        this.grupo = grupo;
        this.fecha = fecha;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getDivicionCurso() {
        return divicionCurso;
    }

    public int getIdcondicion() {
        return idcondicion;
    }

    public String getCondicion() {
        return condicion;
    }

    public int getGrupo() {
        return grupo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setDivicionCurso(String divicionCurso) {
        this.divicionCurso = divicionCurso;
    }

    public void setIdcondicion(int idcondicion) {
        this.idcondicion = idcondicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
