/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorAsistencias;
import Controladores.GestorCursos;
import Model.Asistencias;
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
public class ModificarAsistenciasServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        id = Integer.parseInt(request.getParameter("idAsistencia"));
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
        id = Integer.parseInt(request.getParameter("idAsistencia"));
        HttpSession mySession = request.getSession();
        boolean isLogged = (boolean) mySession.getAttribute("inicio");
        if (isLogged) {
            GestorAsistencias ga = new GestorAsistencias();
            VMAsistenciaAlumnoCurso alu = ga.obtenerAsistenciasAlumnoCursoID(id);
            request.setAttribute("alu", alu);
            
            getServletContext().getRequestDispatcher("/ModificarAsistencias.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
        }
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
        GestorAsistencias ga = new GestorAsistencias();
        Asistencias asis = ga.obtenerAsistencias(id);
        Asistencias as = new Asistencias();
        Asistencias a = new Asistencias();
        
        a.setIdAsistencias(asis.getIdAsistencias());
        
        boolean p = asis.isEstaPresente();
        String presente = request.getParameter("estado");
        
            if (presente.equals("P")) {
                as.setEstaPresente(1);
            } else {
                as.setEstaPresente(0);
            }
            
            boolean pre = as.isEstaPresente();
            if (p == pre){
                if (pre) {
                    a.setEstaPresente(1);
                }else{
                    a.setEstaPresente(0);
                }
            } else {
                if (pre) {
                    a.setEstaPresente(1);
                }else{
                    a.setEstaPresente(0);
                }
            }
            boolean cargo = ga.modificarAsistencias(a);
            if (cargo) {
                GestorAsistencias g = new GestorAsistencias();
                ArrayList<VMAsistenciaAlumnoCurso> alumno = g.obtenerAsistenciasAlumnoCursoTodos();

                GestorCursos gc = new GestorCursos();
                ArrayList<Cursos> curso = gc.obtenerCursos();

                request.setAttribute("curso", curso);
                request.setAttribute("alumno", alumno);
            
                getServletContext().getRequestDispatcher("/ListadoAsistencias.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/Problema.jsp").forward(request, response);
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
