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
public class VMALumnoCursoPromedios extends VMAlumnosCursos{
    double notaExamen;
    double notaTFI;
    int asistenciaTotal;
    int aistenciaAlumno;
    double promedioNotas;
    double promedioAsis;
    Date fechaEntrega;
    Date fechaEntregado;
    
    public VMALumnoCursoPromedios() {
    }

    public VMALumnoCursoPromedios(double notaExamen, double notaTFI, int asistenciaTotal, int aistenciaAlumno) {
        this.notaExamen = notaExamen;
        this.notaTFI = notaTFI;
        this.asistenciaTotal = asistenciaTotal;
        this.aistenciaAlumno = aistenciaAlumno;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public Date getFechaEntregado() {
        return fechaEntregado;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setFechaEntregado(Date fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
    }
    
    public double getPromedioNotas() {
        return promedioNotas;
    }

    public double getPromedioAsis() {
        return promedioAsis;
    }

    public void setPromedioNotas(double promedioNotas) {
        this.promedioNotas = promedioNotas;
    }

    public void setPromedioAsis(double promedioAsis) {
        this.promedioAsis = promedioAsis;
    }

    
    public double getNotaExamen() {
        return notaExamen;
    }

    public double getNotaTFI() {
        return notaTFI;
    }

    public int getAsistenciaTotal() {
        return asistenciaTotal;
    }

    public int getAistenciaAlumno() {
        return aistenciaAlumno;
    }

    public void setNotaExamen(double notaExamen) {
        this.notaExamen = notaExamen;
    }

    public void setNotaTFI(double notaTFI) {
        this.notaTFI = notaTFI;
    }

    public void setAsistenciaTotal(int asistenciaTotal) {
        this.asistenciaTotal = asistenciaTotal;
    }

    public void setAistenciaAlumno(int aistenciaAlumno) {
        this.aistenciaAlumno = aistenciaAlumno;
    }
    
    
}
