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
public class VMAsistenciaAlmunoJustificativo {
    int idAsistencias;
    int legajo;
    String nombre;
    String apellido;
    String texto;
    Date fecha;

    public VMAsistenciaAlmunoJustificativo() {
    }

    public VMAsistenciaAlmunoJustificativo(int idAsistencias, int legajo, String nombre, String apellido, String texto, Date fecha) {
        this.idAsistencias = idAsistencias;
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.texto = texto;
        this.fecha = fecha;
    }

    public int getIdAsistencias() {
        return idAsistencias;
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

    public String getTexto() {
        return texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setIdAsistencias(int idAsistencias) {
        this.idAsistencias = idAsistencias;
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

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
