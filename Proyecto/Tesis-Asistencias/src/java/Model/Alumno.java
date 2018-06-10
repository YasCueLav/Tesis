package Model;

import java.sql.Date;

/**
 *
 * @author Yasmin
 */
public class Alumno {
    int idAlumno;
    int legajo;
    String nombre;
    String apellido;
    int idCurso;
    int idCondicion;
    int grupo;
    Date fechaIngreso;
    boolean visible;

    public Alumno() {
    }

    public Alumno(int idAlumno, int legajo, String nombre, String apellido, int idCurso, int idCondicion, int grupo, Date fechaIngreso) {
        this.idAlumno = idAlumno;
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idCurso = idCurso;
        this.idCondicion = idCondicion;
        this.grupo = grupo;
        this.fechaIngreso = fechaIngreso;
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

    public int getIdCondicion() {
        return idCondicion;
    }

    public int getGrupo() {
        return grupo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public boolean isVisible() {
        return visible;
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

    public void setIdCondicion(int idCondicion) {
        this.idCondicion = idCondicion;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public void setVisible(int visible) {
        if (visible == 1) {
            this.visible = true;
        } else {
            this.visible = false;
        }
    }   
}
