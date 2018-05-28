/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorAlumnos;
import Controladores.GestorCursos;
import Controladores.GestorExamenes;
import Controladores.GestorNotas;
import Model.Cursos;
import Model.Notas;
import Model.VMAlumnosCursos;
import Model.VMTipoExamenExamen;
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
public class AltaCalificacionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        HttpSession mySession = request.getSession();
        boolean isLogged = (boolean) mySession.getAttribute("inicio");
        if (isLogged) {
            //Selecion Examen
            GestorExamenes ge = new GestorExamenes();
            ArrayList<VMTipoExamenExamen> examen = ge.obtenerTodosExamenes();
            //Selecion Curso
            GestorCursos gc = new GestorCursos();
            ArrayList<Cursos> curso = gc.obtenerCursos();
            //Lista Alumnos
            GestorAlumnos ga = new GestorAlumnos();
            ArrayList<VMAlumnosCursos> alumno = ga.obtenerAlumnoCurso();
            
            request.setAttribute("curso", curso);
            request.setAttribute("examen", examen);
            request.setAttribute("alumno", alumno);
            
            getServletContext().getRequestDispatcher("/AltaCalificacion.jsp").forward(request, response);
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
        //boton input filtrar valla al DOPOST y de hay un if y vea cual es, 
        //si es filtrar que valla a metodo actualizar tabla
        
        String valor = request.getParameter("Boton");
     
        switch (valor) {
            case "Filtrar":
                System.out.println("Filtro");
                System.out.println("Examen " + Integer.parseInt(request.getParameter("IdExamenA")));
                int c = Integer.parseInt(request.getParameter("IdCurso"));
                
                System.out.println("Cursos " + c);
                
                GestorCursos gc = new GestorCursos();
                Cursos curso = gc.obtenerCursoConID(c);
 
                GestorAlumnos ga = new GestorAlumnos();
                ArrayList<VMAlumnosCursos> alumno = ga.obtenerAlumnosXCurso(c);
                
                request.setAttribute("curso", curso);
                request.setAttribute("alumno", alumno);
                break;
                
            case "Cargar":
                System.out.println("Cargo");
                
                GestorNotas gn = new GestorNotas();
                
                String[] ids = request.getParameterValues("IdAlumno");
                String[] numeoNota = request.getParameterValues("NumeoNota");
                
                ArrayList <Notas> notas = new ArrayList<>();

                for (int i = 0; i < ids.length; i++) {
                    Notas n = new Notas();
                    
                    n.setIdAlumno(Integer.parseInt(ids[i]));
                    n.setIdExamen(Integer.parseInt(request.getParameter("IdExamen")));
                    n.setNota(Double.parseDouble(numeoNota[i]));
                    
                    notas.add(n);
                }   
                
                boolean cargo = gn.agregarNotaParcial(notas);
                if (cargo) {
                    getServletContext().getRequestDispatcher("/Exito.jsp").forward(request, response);
                } else {
                    getServletContext().getRequestDispatcher("/Problema.jsp").forward(request, response);
                }
                break;
                
            default:
                getServletContext().getRequestDispatcher("/Problema.jsp").forward(request, response);
                break;
        }
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
