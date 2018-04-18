package Model;

/**
 *
 * @author Yasmin
 */
public class Notas {
    int idNota;
    double nota;
    int idAlumno;
    boolean visible;

    public Notas() {
    }

    
    public Notas(int idNota, double nota, int idAlumno) {
        this.idNota = idNota;
        this.nota = nota;
        this.idAlumno = idAlumno;
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
    
    
}
