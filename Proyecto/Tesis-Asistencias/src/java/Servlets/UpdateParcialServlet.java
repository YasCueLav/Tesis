/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorExamenes;
import Controladores.GestorTiposExamenes;
import Model.Examenes;
import Model.TiposExamenes;
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
public class UpdateParcialServlet extends HttpServlet {

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
        id = Integer.parseInt(request.getParameter("idExamen"));
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
        m = Integer.parseInt(request.getParameter("estado"));
        
        HttpSession mySession = request.getSession();
        boolean isLogged = (boolean) mySession.getAttribute("inicio");
        if (isLogged) {
            GestorExamenes ge;
            switch (m){
                case 1: 
                    GestorTiposExamenes gte = new GestorTiposExamenes();
                    ge = new GestorExamenes();
                    ArrayList<TiposExamenes> tipoexamen = gte.obtenerTiposExamenes();
                    VMTipoExamenExamen examen = ge.obtenerVMExamenes(id);

                    request.setAttribute("examen", examen);
                    request.setAttribute("tipoexamen", tipoexamen);
            
                    getServletContext().getRequestDispatcher("/UpdateParcial.jsp").forward(request, response);
                    break;
                case 2:
                    ge = new GestorExamenes();
                    boolean ca = ge.elimniarExamen(id);
                    if (ca) {
                        getServletContext().getRequestDispatcher("/ListadoSoporteServlet").forward(request, response);
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
        boolean cargar = false;
        GestorExamenes ge = new GestorExamenes();
        Examenes e = new Examenes(); 
        e.setIdExamen(id);
        e.setIdTipoExamne(Integer.parseInt(request.getParameter("TipoExamen")));
        e.setExamenNombre(request.getParameter("Examen"));
        String presente = request.getParameter("FechaS");
            if (presente.equals("S")) {
                e.setFecha(request.getParameter("Fecha"));
                cargar = ge.modificarExamenConFecha(e);
            } else if (presente.equals("N")){
                cargar = ge.modificarExamenSinFecha(e);
            }
                
        if (cargar) {
            getServletContext().getRequestDispatcher("/ListadoSoporteServlet").forward(request, response);
        }else{
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
