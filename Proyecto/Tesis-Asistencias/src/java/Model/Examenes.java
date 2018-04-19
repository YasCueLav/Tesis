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
public class Examenes {
    
    int idExamen;
    int idTipoExamne;
    String examenNombre;
    boolean visible;

    public Examenes() {
    }

    public Examenes(int idExamen, int idTipoExamne, String examenNombre) {
        this.idExamen = idExamen;
        this.idTipoExamne = idTipoExamne;
        this.examenNombre = examenNombre;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public int getIdTipoExamne() {
        return idTipoExamne;
    }

    public String getExamenNombre() {
        return examenNombre;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public void setIdTipoExamne(int idTipoExamne) {
        this.idTipoExamne = idTipoExamne;
    }

    public void setExamenNombre(String examenNombre) {
        this.examenNombre = examenNombre;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    
}
