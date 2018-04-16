package Controladores;

import Model.Alumno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Yasmin
 */
public class GestorAlumnos {
    
    private Connection conn;
    
    public GestorAlumnos (){
        AccesoDatos ad = new AccesoDatos();
        try {
            conn = DriverManager.getConnection(ad.getConn_string(), ad.getUser(), ad.getPass());
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<Alumno> ObtenerAlumnos (){
        ArrayList<Alumno> lista = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet query = stmt.executeQuery("Select * from Alumnos where visible = 0");
            while (query.next()){
                Alumno a = new Alumno();
                a.setIdAlumno(query.getInt("id_alumno"));
                a.setNombre(query.getString("nombre"));
                a.setApellido(query.getString("apellido"));
                a.setIdCurso(query.getInt("id_curso"));
                a.setIdCondicion(query.getInt("id_condicion"));
                a.setGrupo(query.getInt("grupo"));
                lista.add(a);
            }
            query.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
}
