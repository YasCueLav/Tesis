/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorCondiciones;
import Controladores.GestorCursos;
import Controladores.GestorExamenes;
import Controladores.GestorTPs;
import Model.Condiciones;
import Model.Cursos;
import Model.TPs;
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
public class UpdateCursoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int id=0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        id = Integer.parseInt(request.getParameter("idCurso"));
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
        int m = 0;
        id = Integer.parseInt(request.getParameter("idCurso"));
        m = Integer.parseInt(request.getParameter("estado"));
        
        HttpSession mySession = request.getSession();
        boolean isLogged = (boolean) mySession.getAttribute("inicio");
        if (isLogged) {
            GestorCursos gcu;
            switch (m){
                case 1: 
                    gcu = new GestorCursos();
                    Cursos curso = gcu.obtenerCursoConID(id);

                    request.setAttribute("curso", curso);
            
                    getServletContext().getRequestDispatcher("/UpdateCurso.jsp").forward(request, response);
                    break;
                case 2:
                    gcu = new GestorCursos();
                    boolean ca = gcu.elimniarCurso(id);
                    if (ca) {
                        getServletContext().getRequestDispatcher("/Exito.jsp").forward(request, response);
                    }else{
                        getServletContext().getRequestDispatcher("/Problema.jsp").forward(request, response);
                    }
                    
                    break;
                    
                default:
                    getServletContext().getRequestDispatcher("/Problema.jsp").forward(request, response);
                    break;
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
        GestorCursos gcu = new GestorCursos();
        Cursos c = new Cursos();
        
        c.setIdCursos(id);
        c.setNombreCurso(request.getParameter("Curso"));
        c.setSeccionCurso(request.getParameter("Seccion"));
        
        boolean cargo = gcu.modificarCurso(c);
        if (cargo) {
            GestorExamenes ge = new GestorExamenes();
            ArrayList<VMTipoExamenExamen> examen = ge.obtenerTodosExamenes();
            
            GestorTPs gt = new GestorTPs();
            ArrayList<TPs> tp = gt.obtenerTPs();

            GestorCondiciones gc = new GestorCondiciones();
            ArrayList<Condiciones> condicion = gc.obtenerCondiciones();
            
            GestorCursos g = new GestorCursos();
            ArrayList<Cursos> curso = g.obtenerCursos();
            
            request.setAttribute("tp", tp);
            request.setAttribute("examen", examen);
            request.setAttribute("condicion", condicion);
            request.setAttribute("curso", curso);
            
            getServletContext().getRequestDispatcher("/ListadoSoporte.jsp").forward(request, response);
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
