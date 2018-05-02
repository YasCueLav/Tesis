package Model;

/**
 *
 * @author Yasmin
 */
public class Cursos {
    int idCursos;
    String nombreCurso;
    String seccionCurso;
    boolean visible;

    public Cursos() {
    }

    public Cursos(int idCursos, String nombreCurso, String seccionCurso) {
        this.idCursos = idCursos;
        this.nombreCurso = nombreCurso;
        this.seccionCurso = seccionCurso;
    }

    public int getIdCursos() {
        return idCursos;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public String getSeccionCurso() {
        return seccionCurso;
    }

    public boolean isVisible() {
        return visible;
    }
    
    public void setIdCursos(int idCursos) {
        this.idCursos = idCursos;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public void setSeccionCurso(String seccionCurso) {
        this.seccionCurso = seccionCurso;
    }

    public void setVisible(int visible) {
        if (visible == 0) {
            this.visible = true;
        } else {
            this.visible = false;
        }
    }
    
    
}
