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
public class VMAlumnoCursoTpConFecha extends VMAlumnosCursosCondiciones{
    int idTpAlumno;
    int idTp;
    String tp;
    Date fEntrega;
    Date fEntregado;
    String estado;

    public VMAlumnoCursoTpConFecha() {
    }

    public VMAlumnoCursoTpConFecha(int idTpAlumno, int idTp, String tp, Date fEntrega, Date fEntregado, String estado) {
        this.idTpAlumno = idTpAlumno;
        this.idTp = idTp;
        this.tp = tp;
        this.fEntrega = fEntrega;
        this.fEntregado = fEntregado;
        this.estado = estado;
    }

    public int getIdTpAlumno() {
        return idTpAlumno;
    }
    
    public int getIdTp() {
        return idTp;
    }

    public String getTp() {
        return tp;
    }

    public Date getfEntrega() {
        return fEntrega;
    }

    public Date getfEntregado() {
        return fEntregado;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdTpAlumno(int idTpAlumno) {
        this.idTpAlumno = idTpAlumno;
    }

    public void setIdTp(int idTp) {
        this.idTp = idTp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public void setfEntrega(Date fEntrega) {
        this.fEntrega = fEntrega;
    }

    public void setfEntregado(Date fEntregado) {
        this.fEntregado = fEntregado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
