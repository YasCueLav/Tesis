package Model;

/**
 *
 * @author Yasmin
 */
public class Condiciones {
    int idCondicion;
    String condicion;
    boolean visible;

    public Condiciones() {
    }

    public Condiciones(int idCondicion, String condicion) {
        this.idCondicion = idCondicion;
        this.condicion = condicion;
    }

    public int getIdCondicion() {
        return idCondicion;
    }

    public String getCondicion() {
        return condicion;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setIdCondicion(int idCondicion) {
        this.idCondicion = idCondicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
}
