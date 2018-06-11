package Model;

import java.sql.Date;

/**
 *
 * @author Yasmin
 */
public class TpsAlumnos {
    int idTpAlumno;
    int idTp;
    int idAlumno;
    int idEstado;
    Date fechaPresentado; 
    String fecha;
    boolean presentado;
    boolean visible;

    public TpsAlumnos() {
    }

    public TpsAlumnos(int idTpAlumno, int idTp, int idAlumno,int idEstado,boolean presentado) {
        this.idTpAlumno = idTpAlumno;
        this.idTp = idTp;
        this.idAlumno = idAlumno;
        this.idEstado = idEstado;
        this.presentado = presentado;
    }

    public int getIdTpAlumno() {
        return idTpAlumno;
    }

    public int getIdTp() {
        return idTp;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public Date getFechaPresentado() {
        return fechaPresentado;
    }

    public String getFecha() {
        return fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isPresentado() {
        return presentado;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setIdTpAlumno(int idTpAlumno) {
        this.idTpAlumno = idTpAlumno;
    }

    public void setIdTp(int idTp) {
        this.idTp = idTp;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setFechaPresentado(Date fechaPresentado) {
        this.fechaPresentado = fechaPresentado;
    }

    
    public void setPresentado(int presentado) {
        if (presentado == 0) {
            this.presentado = false;
        } else {
            this.presentado = true;
        }
    }

    public void setVisible(int visible) {
        if (visible == 0) {
            this.visible = false;
        } else {
            this.visible = true;
        }
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
    
    
}
