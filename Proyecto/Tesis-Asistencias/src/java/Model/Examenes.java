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
public class Examenes {
    
    int idExamen;
    int idTipoExamne;
    String examenNombre;
    Date fechaExamen;
    boolean visible;

    public Examenes() {
    }

    public Examenes(int idExamen, int idTipoExamne, String examenNombre,Date fechaExamen) {
        this.idExamen = idExamen;
        this.idTipoExamne = idTipoExamne;
        this.examenNombre = examenNombre;
        this.fechaExamen = fechaExamen;
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

    public Date getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
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

    public void setVisible(int visible) {
        if (visible == 0) {
            this.visible = true;
        } else {
            this.visible = false;
        }
    }
    
    
    
}
