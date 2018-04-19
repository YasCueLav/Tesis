package Model;

/**
 *
 * @author Yasmin
 */
public class Notas {
    int idNota;
    double nota;
    int idAlumno;
    int idExamen;
    int idTp;
    boolean visible;

    public Notas() {
    }

    public Notas(int idNota, double nota, int idAlumno, int idExamen, int idTp) {
        this.idNota = idNota;
        this.nota = nota;
        this.idAlumno = idAlumno;
        this.idExamen = idExamen;
        this.idTp = idTp;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public int getIdTp() {
        return idTp;
    }

    public int getIdNota() {
        return idNota;
    }

    public double getNota() {
        return nota;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public void setIdTp(int idTp) {
        this.idTp = idTp;
    }
    
    
}
