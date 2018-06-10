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
public class Justificativo {
    int idAsistencias;
    String texto;
    boolean visible;

    public Justificativo() {
    }

    public Justificativo(int idAsistencias, String texto) {
        this.idAsistencias = idAsistencias;
        this.texto = texto;
    }

    public int getIdAsistencias() {
        return idAsistencias;
    }

    public String getTexto() {
        return texto;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setIdAsistencias(int idAsistencias) {
        this.idAsistencias = idAsistencias;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
}
