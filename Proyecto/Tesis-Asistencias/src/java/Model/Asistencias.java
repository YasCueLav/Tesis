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
public class Asistencias {
    int idAsistencias;
    int idAlumno;
    int legajo;
    Date fechaReguistro;
    boolean estaPresente;
    boolean fechaObligatoria;
    boolean visible;

    public Asistencias() {
    }

    public Asistencias(int ideAsistencias, int idAlumno, int legajo,Date fechaReguistro, boolean estaPresente, boolean fechaObligatoria) {
        this.idAsistencias = ideAsistencias;
        this.idAlumno = idAlumno;
        this.legajo = legajo;
        this.fechaReguistro = fechaReguistro;
        this.estaPresente = estaPresente;
        this.fechaObligatoria = fechaObligatoria;
    }

    public Asistencias(int idAlumno, boolean estaPresente, boolean fechaObligatoria) {
        this.idAlumno = idAlumno;
        this.estaPresente = estaPresente;
        this.fechaObligatoria = fechaObligatoria;
    }
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    public int getIdAsistencias() {
        return idAsistencias;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public Date getFechaReguistro() {
        return fechaReguistro;
    }

    public boolean isEstaPresente() {
        return estaPresente;
    }

    public boolean isFechaObligatoria() {
        return fechaObligatoria;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setIdAsistencias(int idAsistencias) {
        this.idAsistencias = idAsistencias;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setFechaReguistro(Date fechaReguistro) {
        this.fechaReguistro = fechaReguistro;
    }

    public void setEstaPresente (int estaPresente) {
        if (estaPresente == 0) {
            this.estaPresente = true;
        } else {
            this.estaPresente = false;
        }
    }

    public void setFechaObligatoria(int fechaObligatoria) {
        if (fechaObligatoria == 0) {
            this.fechaObligatoria = true;
        } else {
            this.fechaObligatoria = false;
        }
    }

    public void setVisible (int visible) {
        if (visible == 0) {
            this.visible = true;
        } else {
            this.visible = false;
        }
    }
    
    
    
}
