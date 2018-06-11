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
public class VMTipoExamenExamen {
    int idExamen;
    int idTipoExamen;
    String TipoExamne;
    String examenNombre;
    Date fecha;
    boolean visible;

    public VMTipoExamenExamen() {
    }

    public VMTipoExamenExamen(int idExamen, int idTipoExamen, String TipoExamne, String examenNombre, Date fecha) {
        this.idExamen = idExamen;
        this.idTipoExamen = idTipoExamen;
        this.TipoExamne = TipoExamne;
        this.examenNombre = examenNombre;
        this.fecha = fecha;
    }

    public int getIdTipoExamen() {
        return idTipoExamen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setIdTipoExamen(int idTipoExamen) {
        this.idTipoExamen = idTipoExamen;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public int getIdExamen() {
        return idExamen;
    }

    public String getTipoExamne() {
        return TipoExamne;
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

    public void setTipoExamne(String TipoExamne) {
        this.TipoExamne = TipoExamne;
    }

    public void setExamenNombre(String examenNombre) {
        this.examenNombre = examenNombre;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    
}
