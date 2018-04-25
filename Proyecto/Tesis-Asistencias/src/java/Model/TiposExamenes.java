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
public class TiposExamenes {
    
    int idTipoExamne;
    String tipoExamen;
    boolean visible;

    public TiposExamenes() {
    }

    public TiposExamenes(int idTipoExamne, String tipoExamen) {
        this.idTipoExamne = idTipoExamne;
        this.tipoExamen = tipoExamen;
    }

    public int getIdTipoExamne() {
        return idTipoExamne;
    }

    public String getTipoExamen() {
        return tipoExamen;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setIdTipoExamne(int idTipoExamne) {
        this.idTipoExamne = idTipoExamne;
    }

    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }

    public void setVisible(int visible) {
        if (visible == 0) {
            this.visible = true;
        } else {
            this.visible = false;
        }
    }
    
    
}
