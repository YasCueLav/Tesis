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
public class VMAlumnosCursos {
    int idAlumno;
    int legajo;
    String nombre;
    String apellido;
    int idCurso;
    String nombreCurso;
    String divicionCurso;

    public VMAlumnosCursos() {
    }

    public VMAlumnosCursos(int idAlumno, int legajo, String nombre, String apellido, int idCurso, String nombreCurso, String divicionCurso) {
        this.idAlumno = idAlumno;
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.divicionCurso = divicionCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
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

    public String getDivicionCurso() {
        return divicionCurso;
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

    public void setDivicionCurso(String divicionCurso) {
        this.divicionCurso = divicionCurso;
    }
    
    
}
