/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorAlumnos;
import Controladores.GestorAsistencias;
import Controladores.GestorCursos;
import Model.Alumno;
import Model.Cursos;
import Model.ParametroCondicion;
import Model.VMAlumnosCursoInasistencias;
import Model.VMAsistenciaAlumnoCurso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yasmin
 */
public class ListadoAsistenciasEspecificoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int le =0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        le = Integer.parseInt(request.getParameter("legajo"));
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            le = Integer.parseInt(request.getParameter("legajo"));
            HttpSession mySession = request.getSession();
            boolean isLogged = (boolean) mySession.getAttribute("inicio");
            if (isLogged) {
                GestorAsistencias ga;
                GestorAlumnos g;
                if (le != 0) {
                    ga = new GestorAsistencias();
                    g = new GestorAlumnos();    

                    ArrayList<Alumno> a;
                    if (le != 0) {
                        a = g.obtenerAlumnosxLegajo(le);
                    } else{
                        a = g.obtenerAlumnos();
                    }

                    ArrayList<VMAlumnosCursoInasistencias> alumno = new ArrayList<>();

                    for (Alumno vm : a) {
                        VMAlumnosCursoInasistencias p = ga.obtenerCantidadAusencias(vm.getIdAlumno());
                        alumno.add(p);
                    }

                    request.setAttribute("alumno", alumno);

                    getServletContext().getRequestDispatcher("/ListadoAsistenciasEspecifico.jsp").forward(request, response);
                }else{//Ya
                    ga = new GestorAsistencias();
                    g = new GestorAlumnos();
                    
                    ArrayList<Alumno> a = g.obtenerAlumnos();
                    ArrayList<VMAlumnosCursoInasistencias> alumno = new ArrayList<>();

                    for (Alumno vm : a) {
                        VMAlumnosCursoInasistencias p = ga.obtenerCantidadAusencias(vm.getIdAlumno());
                        alumno.add(p);
                    }
                    request.setAttribute("alumno", alumno);

                    getServletContext().getRequestDispatcher("/ListadoAsistenciasEspecifico.jsp").forward(request, response);
                }
            } else {
                getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
            }
        }
        catch (NumberFormatException e){
            System.out.println(e);
        }
        le = 0;
        HttpSession mySession = request.getSession();
        boolean isLogged = (boolean) mySession.getAttribute("inicio");
        if (isLogged) {
            GestorAsistencias ga;
            GestorAlumnos g;
            if (le != 0) {
                ga = new GestorAsistencias();
                g = new GestorAlumnos();    

                ArrayList<Alumno> a;
                if (le != 0) {
                    a = g.obtenerAlumnosxLegajo(le);
                } else{
                    a = g.obtenerAlumnos();
                }

                ArrayList<VMAlumnosCursoInasistencias> alumno = new ArrayList<>();

                for (Alumno vm : a) {
                    VMAlumnosCursoInasistencias p = ga.obtenerCantidadAusencias(vm.getIdAlumno());
                    alumno.add(p);
                }

                request.setAttribute("alumno", alumno);

                getServletContext().getRequestDispatcher("/ListadoAsistenciasEspecifico.jsp").forward(request, response);
            }else{//ya
                ga = new GestorAsistencias();
                g = new GestorAlumnos();
                
                ArrayList<Alumno> a = g.obtenerAlumnos();
                ArrayList<VMAlumnosCursoInasistencias> alumno = new ArrayList<>();

                for (Alumno vm : a) {
                    VMAlumnosCursoInasistencias p = ga.obtenerCantidadAusencias(vm.getIdAlumno());
                    alumno.add(p);
                }
                request.setAttribute("alumno", alumno);

                getServletContext().getRequestDispatcher("/ListadoAsistenciasEspecifico.jsp").forward(request, response);
                }
        } else {
            getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int legajo = Integer.parseInt(request.getParameter("Legajo"));
        
        GestorAsistencias ga = new GestorAsistencias();
        GestorAlumnos g = new GestorAlumnos();    
        
        ArrayList<Alumno> a;
        if (legajo != 0) {
            a = g.obtenerAlumnosxLegajo(legajo);
        } else{
            a = g.obtenerAlumnos();
        }
        
        ArrayList<VMAlumnosCursoInasistencias> alumno = new ArrayList<>();

        for (Alumno vm : a) {
            VMAlumnosCursoInasistencias p = ga.obtenerCantidadAusencias(vm.getIdAlumno());
            alumno.add(p);
        }
        
        request.setAttribute("alumno", alumno);
        
        getServletContext().getRequestDispatcher("/ListadoAsistenciasEspecifico.jsp").forward(request, response);
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
