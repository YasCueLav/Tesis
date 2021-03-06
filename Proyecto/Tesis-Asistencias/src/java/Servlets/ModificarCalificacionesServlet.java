/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorExamenes;
import Controladores.GestorNotas;
import Model.Notas;
import Model.VMAlumnoNotaTipoExamenExamen;
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
public class ModificarCalificacionesServlet extends HttpServlet {

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
        id = Integer.parseInt(request.getParameter("idNota"));
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
        id = Integer.parseInt(request.getParameter("idNota"));
        m = Integer.parseInt(request.getParameter("estado"));
        
        HttpSession mySession = request.getSession();
        boolean isLogged = (boolean) mySession.getAttribute("inicio");
        if (isLogged) {
            GestorExamenes ge;
            switch (m){
                case 1: 
                    ge = new GestorExamenes();
                    ArrayList<VMAlumnoNotaTipoExamenExamen> examen = ge.obtenerExamenesNotaAlumnoID(id);
                    
                    request.setAttribute("examen", examen);
                    
                    getServletContext().getRequestDispatcher("/ModificarCalificaciones.jsp").forward(request, response);
                    break;
                case 2:
                    ge = new GestorExamenes();
                    VMAlumnoNotaTipoExamenExamen e = ge.obtenerExamenesNotaAlumno(id);
                    
                    GestorNotas gn = new GestorNotas();
                    boolean ca = gn.elimniarNota(e.getIdNota());
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
        GestorNotas gn = new GestorNotas();
        Notas n = new Notas();
        
        n.setIdAlumno(Integer.parseInt(request.getParameter("IdAlumno")));
        n.setNota(Double.parseDouble(request.getParameter("NumeoNota")));
        
        boolean cargo = gn.modificarNotas(n);
        if (cargo) {
            GestorExamenes ge = new GestorExamenes();
            ArrayList<VMAlumnoNotaTipoExamenExamen> examen = ge.obtenerExamenesNotaAlumno();
            
            request.setAttribute("examen", examen);
            
            getServletContext().getRequestDispatcher("/ListadoCalificaciones.jsp").forward(request, response);
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
