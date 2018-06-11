/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorTPs;
import Model.TPs;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yasmin
 */
public class UpdateTPServlet extends HttpServlet {

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
        id = Integer.parseInt(request.getParameter("idTp"));
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
        id = Integer.parseInt(request.getParameter("idTp"));
        m = Integer.parseInt(request.getParameter("estado"));
        
        HttpSession mySession = request.getSession();
        boolean isLogged = (boolean) mySession.getAttribute("inicio");
        if (isLogged) {
            GestorTPs gt;
            switch (m){
                case 1: 
                    gt = new GestorTPs();
                    TPs trabPrac = gt.obtenerTPs(id);

                    request.setAttribute("trabPrac", trabPrac);
            
                    getServletContext().getRequestDispatcher("/UpdateTP.jsp").forward(request, response);
                    break;
                case 2:
                    gt = new GestorTPs();
                    boolean ca = gt.elimniarTP(id);
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
        GestorTPs gt = new GestorTPs();
        TPs tp = new TPs();
        tp.setIdTp(id);
        tp.setNombreTp(request.getParameter("TrabajoP"));
        
        boolean c = gt.ModificarTP(tp);
        
        if (c) {
            getServletContext().getRequestDispatcher("/Exito.jsp").forward(request, response);
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
