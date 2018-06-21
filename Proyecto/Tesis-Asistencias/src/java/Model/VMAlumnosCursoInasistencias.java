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
public class VMAlumnosCursoInasistencias extends VMAlumnosCursosCondiciones {
    int idAsistencias;
    int totalAsistencias;
    int totalAsistenciasObligatoria;
    int cantAusenciasG;
    int cantAusenciasO;
    double promedioAsis;
    double promedioAsisObligatoria;

    public VMAlumnosCursoInasistencias() {
    }

    public VMAlumnosCursoInasistencias(int idAsistencias, int totalAsistencias, int totalAsistenciasObligatoria, int cantAusenciasG, int cantAusenciasO) {
        this.idAsistencias = idAsistencias;
        this.totalAsistencias = totalAsistencias;
        this.totalAsistenciasObligatoria = totalAsistenciasObligatoria;
        this.cantAusenciasG = cantAusenciasG;
        this.cantAusenciasO = cantAusenciasO;
    }

    public double getPromedioAsis() {
        return promedioAsis;
    }

    public double getPromedioAsisObligatoria() {
        return promedioAsisObligatoria;
    }

    public void setPromedioAsis(double promedioAsis) {
        this.promedioAsis = promedioAsis;
    }

    public void setPromedioAsisObligatoria(double promedioAsisObligatoria) {
        this.promedioAsisObligatoria = promedioAsisObligatoria;
    }

    
    public int getIdAsistencias() {
        return idAsistencias;
    }

    public int getTotalAsistencias() {
        return totalAsistencias;
    }

    public int getTotalAsistenciasObligatoria() {
        return totalAsistenciasObligatoria;
    }

    public int getCantAusenciasG() {
        return cantAusenciasG;
    }

    public int getCantAusenciasO() {
        return cantAusenciasO;
    }

    public void setIdAsistencias(int idAsistencias) {
        this.idAsistencias = idAsistencias;
    }

    public void setTotalAsistencias(int totalAsistencias) {
        this.totalAsistencias = totalAsistencias;
    }

    public void setTotalAsistenciasObligatoria(int totalAsistenciasObligatoria) {
        this.totalAsistenciasObligatoria = totalAsistenciasObligatoria;
    }

    public void setCantAusenciasG(int cantAusenciasG) {
        this.cantAusenciasG = cantAusenciasG;
    }

    public void setCantAusenciasO(int cantAusenciasO) {
        this.cantAusenciasO = cantAusenciasO;
    }
    
    
    
}
