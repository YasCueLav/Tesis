/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorAlumnos;
import Controladores.GestorAsistencias;
import Model.TextoSolitario;
import Model.VMALumnoCursoPromedios;
import Model.VMAlumnosCursoInasistencias;
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
public class ListadoPorsentajeAsistenciasServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int condi;
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
            
            GestorAsistencias ga;
            GestorAlumnos g;
            ArrayList <VMAlumnosCursosCondiciones> a;
            ArrayList<VMAlumnosCursoInasistencias> alumno;
            VMAlumnosCursoInasistencias p;
            
            double porcentajeT = 0;
            double porcentajeO = 0;
            
            switch (condi){
                case 1: //APROBADO DIRECTO
                    g = new GestorAlumnos();
                    ga = new GestorAsistencias();
                    
                    a = g.obtenerAlumnoAprobadoDirecto();
                    alumno = new ArrayList<>();
                    
                    p = new VMAlumnosCursoInasistencias();
                    
                    for (VMAlumnosCursosCondiciones vm : a) {
                        if(vm.getIdcondicion() == 1){
                            p = ga.obtenerCantidadAusencias(vm.getIdAlumno());
                            porcentajeT = (p.getCantAusenciasG() * 100)/p.getTotalAsistencias();
                            porcentajeO = (p.getCantAusenciasO() * 100)/p.getTotalAsistenciasObligatoria();
                            
                            p.setPromedioAsis(porcentajeT);
                            p.setPromedioAsis(porcentajeO);
                            
                            alumno.add(p);
                        }
                    }
                    
                    t = new TextoSolitario("ReporteAprobacionDirectaServlet");
                    request.setAttribute("t", t);
                    
                    request.setAttribute("alumno", alumno);
                    
                    getServletContext().getRequestDispatcher("/ListadoPorsentajeAsistencias.jsp").forward(request, response);
                    break;
                    
                case 2://Promosion SU
                    g = new GestorAlumnos();
                    ga = new GestorAsistencias();
                    
                    a = g.obtenerAlumnoAprobadoDirecto();
                    alumno = new ArrayList<>();
                    
                    p = new VMAlumnosCursoInasistencias();
                    
                    for (VMAlumnosCursosCondiciones vm : a) {
                        if(vm.getIdcondicion() == 2){
                            p = ga.obtenerCantidadAusencias(vm.getIdAlumno());
                            porcentajeT = (p.getCantAusenciasG() * 100)/p.getTotalAsistencias();
                            porcentajeO = (p.getCantAusenciasO() * 100)/p.getTotalAsistenciasObligatoria();
                            
                            p.setPromedioAsis(porcentajeT);
                            p.setPromedioAsis(porcentajeO);
                            
                            alumno.add(p);
                        }
                    }
                    
                    t = new TextoSolitario("ReportePromocionSUServlet");
                    request.setAttribute("t", t);
                    
                    request.setAttribute("alumno", alumno);

                    getServletContext().getRequestDispatcher("/ListadoPorsentajeAsistencias.jsp").forward(request, response);
                    break;
                    
                case 3://Regular
                    g = new GestorAlumnos();
                    ga = new GestorAsistencias();
                    
                    a = g.obtenerAlumnoAprobadoDirecto();
                    alumno = new ArrayList<>();
                    
                    p = new VMAlumnosCursoInasistencias();
                    
                    for (VMAlumnosCursosCondiciones vm : a) {
                        if(vm.getIdcondicion() == 3){
                            p = ga.obtenerCantidadAusencias(vm.getIdAlumno());
                            porcentajeT = (p.getCantAusenciasG() * 100)/p.getTotalAsistencias();
                            porcentajeO = (p.getCantAusenciasO() * 100)/p.getTotalAsistenciasObligatoria();
                            
                            p.setPromedioAsis(porcentajeT);
                            p.setPromedioAsis(porcentajeO);
                            
                            alumno.add(p);
                        }
                    }
                    
                    t = new TextoSolitario("ReporteRegularidadServlet");
                    request.setAttribute("t", t);
                    
                    request.setAttribute("alumno", alumno);

                    getServletContext().getRequestDispatcher("/ListadoPorsentajeAsistencias.jsp").forward(request, response);
                    break;
                    
                case 4://Libre x No Cumplimeiento
                    g = new GestorAlumnos();
                    ga = new GestorAsistencias();
                    
                    a = g.obtenerAlumnoAprobadoDirecto();
                    alumno = new ArrayList<>();
                    
                    p = new VMAlumnosCursoInasistencias();
                    
                    for (VMAlumnosCursosCondiciones vm : a) {
                        if(vm.getIdcondicion() == 4){
                            p = ga.obtenerCantidadAusencias(vm.getIdAlumno());
                            porcentajeT = (p.getCantAusenciasG() * 100)/p.getTotalAsistencias();
                            porcentajeO = (p.getCantAusenciasO() * 100)/p.getTotalAsistenciasObligatoria();
                            
                            p.setPromedioAsis(porcentajeT);
                            p.setPromedioAsis(porcentajeO);
                            
                            alumno.add(p);
                        }
                    }
                    
                    t = new TextoSolitario("ReporteLibreAplazoServlet");
                    request.setAttribute("t", t);
                    
                    request.setAttribute("alumno", alumno);

                    getServletContext().getRequestDispatcher("/ListadoPorsentajeAsistencias.jsp").forward(request, response);
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
