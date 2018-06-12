package Model;

import java.sql.Date;

/**
 *
 * @author Yasmin
 */
public class TPs {
    int idTp;
    String nombreTp;
    Date fechaEntrega;
    boolean visible;

    public TPs() {
    }

    public TPs(int idTp, String nombreTp, Date fechaEntrega, boolean visible) {
        this.idTp = idTp;
        this.nombreTp = nombreTp;
        this.fechaEntrega = fechaEntrega;
        this.visible = visible;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    
    public int getIdTp() {
        return idTp;
    }

    public String getNombreTp() {
        return nombreTp;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setIdTp(int idTp) {
        this.idTp = idTp;
    }

    public void setNombreTp(String nombreTp) {
        this.nombreTp = nombreTp;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setVisible(int visible) {
        if (visible == 0) {
            this.visible = false;
        } else {
            this.visible = true;
        }
    }
    
    
}
