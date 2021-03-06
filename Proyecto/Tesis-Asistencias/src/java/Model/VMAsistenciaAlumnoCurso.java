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
public class VMAsistenciaAlumnoCurso extends VMAlumnosCursos{
    int idAsistencias;
    Date fechaReguistro;
    boolean estaPresente;
    boolean fechaObligatoria;
    boolean visible;

    public VMAsistenciaAlumnoCurso() {
    }

    public VMAsistenciaAlumnoCurso(int idAsistencias, Date fechaReguistro, boolean estaPresente, boolean fechaObligatoria, boolean visible) {
        this.idAsistencias = idAsistencias;
        this.fechaReguistro = fechaReguistro;
        this.estaPresente = estaPresente;
        this.fechaObligatoria = fechaObligatoria;
        this.visible = visible;
    }

    public int getIdAsistencias() {
        return idAsistencias;
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

    public void setFechaReguistro(Date fechaReguistro) {
        this.fechaReguistro = fechaReguistro;
    }

    public void setEstaPresente(boolean estaPresente) {
        this.estaPresente = estaPresente;
    }

    public void setFechaObligatoria(boolean fechaObligatoria) {
        this.fechaObligatoria = fechaObligatoria;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
