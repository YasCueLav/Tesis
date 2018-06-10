package Model;

/**
 *
 * @author Yasmin
 */
public class TPs {
    int idTp;
    String nombreTp;
    boolean visible;

    public TPs() {
    }

    public TPs(int idTp, String nombreTp) {
        this.idTp = idTp;
        this.nombreTp = nombreTp;
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

    public void setVisible(int visible) {
        if (visible == 0) {
            this.visible = false;
        } else {
            this.visible = true;
        }
    }
    
    
}
