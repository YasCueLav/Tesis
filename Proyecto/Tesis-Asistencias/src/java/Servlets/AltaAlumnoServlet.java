/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorAlumnos;
import Controladores.GestorCondiciones;
import Controladores.GestorCursos;
import Model.Alumno;
import Model.Condiciones;
import Model.Cursos;
import java.io.IOException;
import java.sql.Date;
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
public class AltaAlumnoServlet extends HttpServlet {

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
            //Selecion curso
            GestorCursos gc = new GestorCursos();
            ArrayList<Cursos> cu = gc.obtenerCursos();
            //Seleccion condicion
            GestorCondiciones go = new GestorCondiciones();
            ArrayList<Condiciones> con = go.obtenerCondiciones();
            
            request.setAttribute("cu", cu);
            request.setAttribute("con", con);
            
            getServletContext().getRequestDispatcher("/AltaAlumno.jsp").forward(request, response);
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
        
        GestorAlumnos ga = new GestorAlumnos();
        Alumno alum = new Alumno();
        
//        String dia="";
//        String mes="";
//        String anio="";
        
//        String f = request.getParameter("Fecha");
//        System.out.println("FECHA --" + f);
        
        String dia = request.getParameter("dia");
        String mes = request.getParameter("mes");
        String anio = request.getParameter("anio");

        alum.setLegajo(Integer.parseInt(request.getParameter("Legajo")));
        alum.setNombre(request.getParameter("Nombre"));
        alum.setApellido(request.getParameter("Apellido"));
        alum.setIdCurso(Integer.parseInt(request.getParameter("Curso")));
        alum.setIdCondicion(Integer.parseInt(request.getParameter("Condicion")));
        alum.setGrupo(Integer.parseInt(request.getParameter("Grupo")));
        alum.setFechaS(anio+"/"+mes+"/"+dia);
                
        boolean cargo = ga.agregarAlumno(alum);
        
        if (cargo) {
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
