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
public class Estado {
    int idEstado;
    String estado;
    boolean visible;

    public Estado() {
    }

    public Estado(int idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
}
