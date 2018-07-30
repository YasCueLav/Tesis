/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorAlumnos;
import Model.TextoSolitario;
import Model.VMALumnoCursoPromedios;
import Model.VMAlumnosCursosCondiciones;
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
public class ListadoPromedioNotaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int condi =0;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        condi = Integer.parseInt(request.getParameter("condi"));
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
        condi = Integer.parseInt(request.getParameter("condi"));
        
        HttpSession mySession = request.getSession();
        boolean isLogged = (boolean) mySession.getAttribute("inicio");
        if (isLogged) {
            TextoSolitario t;
            
            GestorAlumnos ga;
            GestorAlumnos g;
            ArrayList <VMAlumnosCursosCondiciones> alum;
            ArrayList<VMALumnoCursoPromedios> alumno;
            VMALumnoCursoPromedios p;
            
            switch (condi){
                case 1: //APROBADO DIRECTO
                    g = new GestorAlumnos();
                    ga = new GestorAlumnos();
                    
                    alum = ga.obtenerAlumnoAprobadoDirecto();
                    alumno = new ArrayList<>();
                    
                    p = new VMALumnoCursoPromedios();
                    
                    for (VMAlumnosCursosCondiciones vm : alum) {
                        if(vm.getIdcondicion() == 1){
                            p = ga.obtenerAlumnoDatosVs(vm.getIdAlumno());
                            alumno.add(p);
                        }
                    }
                    
                    t = new TextoSolitario("ReporteAprobacionDirectaServlet");
                    request.setAttribute("t", t);
                    
                    request.setAttribute("alumno", alumno);

                    getServletContext().getRequestDispatcher("/ListadoPromedioNota.jsp").forward(request, response);
                    break;
                    
                case 2://Promosion SU
                    g = new GestorAlumnos();
                    ga = new GestorAlumnos();
                    
                    alum = ga.obtenerAlumnoPromocionSistemas();
                    alumno = new ArrayList<>();
                    
                    p = new VMALumnoCursoPromedios();
                    
                    for (VMAlumnosCursosCondiciones vm : alum) {
                        if(vm.getIdcondicion() == 2){
                            p = ga.obtenerAlumnoDatosVs(vm.getIdAlumno());
                            alumno.add(p);
                        }
                    }
                    
                    t = new TextoSolitario("ReportePromocionSUServlet");
                    request.setAttribute("t", t);
                    
                    request.setAttribute("alumno", alumno);

                    getServletContext().getRequestDispatcher("/ListadoPromedioNota.jsp").forward(request, response);
                    break;
                    
                case 3://Regular
                    g = new GestorAlumnos();
                    ga = new GestorAlumnos();
                    
                    alum = ga.obtenerAlumnoRegular();
                    alumno = new ArrayList<>();
                    
                    p = new VMALumnoCursoPromedios();
                    
                    for (VMAlumnosCursosCondiciones vm : alum) {
                        if(vm.getIdcondicion() == 3){
                            p = ga.obtenerAlumnoDatosVs(vm.getIdAlumno());
                            alumno.add(p);
                        }
                    }
                    
                    t = new TextoSolitario("ReporteRegularidadServlet");
                    request.setAttribute("t", t);
                    
                    request.setAttribute("alumno", alumno);

                    getServletContext().getRequestDispatcher("/ListadoPromedioNota.jsp").forward(request, response);
                    break;
                    
                case 4://Libre x No Cumplimeiento
                    g = new GestorAlumnos();
                    ga = new GestorAlumnos();
                    
                    alum = ga.obtenerAlumnoLibreNoCumplimiento();
                    alumno = new ArrayList<>();
                    
                    p = new VMALumnoCursoPromedios();
                    
                    for (VMAlumnosCursosCondiciones vm : alum) {
                        if(vm.getIdcondicion() == 4){
                            p = ga.obtenerAlumnoDatosVs(vm.getIdAlumno());
                            alumno.add(p);
                        }
                    }
                    
                    t = new TextoSolitario("ReporteLibreAplazoServlet");
                    request.setAttribute("t", t);
                    
                    request.setAttribute("alumno", alumno);

                    getServletContext().getRequestDispatcher("/ListadoPromedioNota.jsp").forward(request, response);
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
