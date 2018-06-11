/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Yasmin
 */
public class VMAlumnoNotaTipoExamenExamen {
    int idNota;
    int idAlumno;
    int legajo;
    String apellido;
    String nombre;
    String examen;
    String tipoExamen;
    String nombreCurso;
    String seccion;
    int nota;

    public VMAlumnoNotaTipoExamenExamen() {
    }

    public VMAlumnoNotaTipoExamenExamen(int idNota, int idAlumno, int legajo, String apellido, String nombre, String examen, String tipoExamen, String nombreCurso, String seccion, int nota) {
        this.idNota = idNota;
        this.idAlumno = idAlumno;
        this.legajo = legajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.examen = examen;
        this.tipoExamen = tipoExamen;
        this.nombreCurso = nombreCurso;
        this.seccion = seccion;
        this.nota = nota;
    }

    public int getIdAlumno() {
        return idAlumno;
    }
    
    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getSeccion() {
        return seccion;
    }
    
    public int getIdNota() {
        return idNota;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getExamen() {
        return examen;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public int getNota() {
        return nota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setExamen(String examen) {
        this.examen = examen;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    
}
