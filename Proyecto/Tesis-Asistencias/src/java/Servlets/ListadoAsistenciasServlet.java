/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorAsistencias;
import Controladores.GestorCursos;
import Model.Cursos;
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
public class ListadoAsistenciasServlet extends HttpServlet {

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
        le = Integer.parseInt(request.getParameter("legajo"));
        boolean  legajoNumero = false;
        HttpSession mySession = request.getSession();
        boolean isLogged = (boolean) mySession.getAttribute("inicio");
        if (isLogged) {
            if (le != 0) {
                GestorAsistencias ga = new GestorAsistencias();
                ArrayList<VMAsistenciaAlumnoCurso> alumno = ga.obtenerAsistenciasAlumnoCursoTodosXLegajo(le);
                
                GestorCursos gc = new GestorCursos();
                ArrayList<Cursos> curso = gc.obtenerCursos();

                //request.setAttribute("le", le);
                request.setAttribute("curso", curso);
                request.setAttribute("alumno", alumno);
                
                getServletContext().getRequestDispatcher("/ListadoAsistencias.jsp").forward(request, response);
            }else{
                GestorAsistencias ga = new GestorAsistencias();
                ArrayList<VMAsistenciaAlumnoCurso> alumno = ga.obtenerAsistenciasAlumnoCursoTodos();

                GestorCursos gc = new GestorCursos();
                ArrayList<Cursos> curso = gc.obtenerCursos();

                request.setAttribute("le", le);
                request.setAttribute("curso", curso);
                request.setAttribute("alumno", alumno);

                getServletContext().getRequestDispatcher("/ListadoAsistencias.jsp").forward(request, response);
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
        int cu = Integer.parseInt(request.getParameter("Curso"));
        
        GestorAsistencias ga = new GestorAsistencias();
        GestorCursos gc = new GestorCursos();
        
        ArrayList<VMAsistenciaAlumnoCurso> alumno;
        
        if (legajo != 0 && cu != 0) {
            alumno = ga.obtenerAsistenciasAlumnoCursoFiltroLegajoCurso(legajo,cu);
        } else if (legajo != 0){
            alumno = ga.obtenerAsistenciasAlumnoCursoFiltroLegajo(legajo);
        }else if (cu != 0){
            alumno = ga.obtenerAsistenciasAlumnoCursoFiltroCurso(cu);
        } else{
            alumno = ga.obtenerAsistenciasAlumnoCursoTodos();
        }
        
        ArrayList<Cursos> curso = gc.obtenerCursos();

        request.setAttribute("curso", curso);
        request.setAttribute("alumno", alumno);
        
        getServletContext().getRequestDispatcher("/ListadoAsistencias.jsp").forward(request, response);
        
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
