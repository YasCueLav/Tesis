package Model;

/**
 *
 * @author Yasmin
 */
public class TpsAlumnos {
    int idTpAlumno;
    int idTp;
    int idAlumno;
    boolean presentado;
    boolean visible;

    public TpsAlumnos() {
    }

    public TpsAlumnos(int idTpAlumno, int idTp, int idAlumno, boolean presentado) {
        this.idTpAlumno = idTpAlumno;
        this.idTp = idTp;
        this.idAlumno = idAlumno;
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

    public void setPresentado(int presentado) {
        if (presentado == 0) {
            this.presentado = true;
        } else {
            this.presentado = false;
        }
    }

    public void setVisible(int visible) {
        if (visible == 0) {
            this.visible = true;
        } else {
            this.visible = false;
        }
    }
    
    
}
