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
public class ParametroCondicion {
    int idAlmno;
    int totalAsistencias;
    int cantiAsistio;
    double notaParcial;
    int cantiTpAEntregar;
    int cantiTpEntregados;
    double notaTFI;

    public ParametroCondicion() {
    }

    public ParametroCondicion(int idAlmno, int totalAsistencias, int cantiAsistio, double notaParcial, int cantiTpAEntregar, int cantiTpEntregados, double notaTFI) {
        this.idAlmno = idAlmno;
        this.totalAsistencias = totalAsistencias;
        this.cantiAsistio = cantiAsistio;
        this.notaParcial = notaParcial;
        this.cantiTpAEntregar = cantiTpAEntregar;
        this.cantiTpEntregados = cantiTpEntregados;
        this.notaTFI = notaTFI;
    }

    public int getIdAlmno() {
        return idAlmno;
    }

    public int getTotalAsistencias() {
        return totalAsistencias;
    }

    public int getCantiAsistio() {
        return cantiAsistio;
    }

    public double getNotaParcial() {
        return notaParcial;
    }

    public int getCantiTpAEntregar() {
        return cantiTpAEntregar;
    }

    public int getCantiTpEntregados() {
        return cantiTpEntregados;
    }

    public double getNotaTFI() {
        return notaTFI;
    }

    public void setIdAlmno(int idAlmno) {
        this.idAlmno = idAlmno;
    }

    public void setTotalAsistencias(int totalAsistencias) {
        this.totalAsistencias = totalAsistencias;
    }

    public void setCantiAsistio(int cantiAsistio) {
        this.cantiAsistio = cantiAsistio;
    }

    public void setNotaParcial(double notaParcial) {
        this.notaParcial = notaParcial;
    }

    public void setCantiTpAEntregar(int cantiTpAEntregar) {
        this.cantiTpAEntregar = cantiTpAEntregar;
    }

    public void setCantiTpEntregados(int cantiTpEntregados) {
        this.cantiTpEntregados = cantiTpEntregados;
    }

    public void setNotaTFI(double notaTFI) {
        this.notaTFI = notaTFI;
    }
    
    
}
