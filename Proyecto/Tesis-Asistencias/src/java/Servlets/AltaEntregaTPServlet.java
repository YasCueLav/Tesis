/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorAlumnos;
import Controladores.GestorNotas;
import Controladores.GestorTPs;
import Controladores.GestorTPsAlumnos;
import Model.Notas;
import Model.TPs;
import Model.TpsAlumnos;
import Model.VMAlumnosCursos;
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
public class AltaEntregaTPServlet extends HttpServlet {

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
            //tipo TP
            GestorTPs gt = new GestorTPs();
             ArrayList<TPs> tp = gt.obtenerTPs();
            //Lista Alumnos
            GestorAlumnos ga = new GestorAlumnos();
            ArrayList<VMAlumnosCursos> alumno = ga.obtenerAlumnoCurso();
            
            request.setAttribute("tp", tp);
            request.setAttribute("alumno", alumno);
            
            getServletContext().getRequestDispatcher("/AltaEntregaTP.jsp").forward(request, response);
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
        TpsAlumnos tpa = new TpsAlumnos();
        GestorTPsAlumnos gta = new GestorTPsAlumnos();
        Notas n = new Notas();
        GestorNotas gn = new GestorNotas();
        //n.setIdAlumno(Integer.parseInt(request.getParameter("Alumno")));
        tpa.setIdTp(Integer.parseInt(request.getParameter("Tp")));
        tpa.setIdAlumno(Integer.parseInt(request.getParameter("Alumno")));
        tpa.setPresentado(Integer.parseInt(request.getParameter("Entregado")));
        
        n.setNota(Double.parseDouble(request.getParameter("NotaTp")));
        n.setIdAlumno(Integer.parseInt(request.getParameter("Alumno")));
        n.setIdAlumno(Integer.parseInt(request.getParameter("Tp")));
        
        boolean cargo = gta.agregarTPsAlumnos(tpa);
        boolean cargoN = gn.agregarNotaTPs(n);
        
        if (cargo && cargoN) {
            getServletContext().getRequestDispatcher("/Exito.jsp").forward(request, response);
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
