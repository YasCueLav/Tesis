/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorTPs;
import Controladores.GestorTPsAlumnos;
import Model.TPs;
import Model.TpsAlumnos;
import Model.VMAlumnoCursoTpConFecha;
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
public class ModificarTPServlet extends HttpServlet {

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
        id = Integer.parseInt(request.getParameter("idTpAlumno"));
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
        id = Integer.parseInt(request.getParameter("idTpAlumno"));
        m = Integer.parseInt(request.getParameter("tipo"));
        
        HttpSession mySession = request.getSession();
        boolean isLogged = (boolean) mySession.getAttribute("inicio");
        if (isLogged) {
            GestorTPsAlumnos gt;
            switch (m){
                case 1: 
                    gt = new GestorTPsAlumnos();
                    ArrayList<VMAlumnoCursoTpConFecha> tp = gt.obtenerAlumnosCursoTpUno(id);

                    for (VMAlumnoCursoTpConFecha vm : tp) {
                        if(vm.getIdEstado() == 2){
                            vm.setEstadoBool(true);
                            vm.setX(false);
                        } else if (vm.getIdEstado() == 3){
                            vm.setEstadoBool(false);
                            vm.setX(false);
                        }else {
                            vm.setX(true);
                        }
                    }

                    request.setAttribute("tp", tp);

                    getServletContext().getRequestDispatcher("/ModificarTP.jsp").forward(request, response);
                    break;
                case 2:
                    GestorTPsAlumnos g =new GestorTPsAlumnos();
                    TpsAlumnos t = g.obtenerTPsAlumnos(id);
                    
                    gt = new GestorTPsAlumnos();
                    boolean ca = gt.EliminarTP(t.getIdAlumno() , t.getIdTp());
                    
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
    /*
    gt = new GestorTPsAlumnos();
            ArrayList<VMAlumnoCursoTpConFecha> tp = gt.obtenerAlumnosCursoTpUno(id);
            
            for (VMAlumnoCursoTpConFecha vm : tp) {
                if(vm.getIdEstado() == 2){
                    vm.setEstadoBool(true);
                    vm.setX(false);
                } else if (vm.getIdEstado() == 3){
                    vm.setEstadoBool(false);
                    vm.setX(false);
                }else {
                    vm.setX(true);
                }
            }
            
            request.setAttribute("tp", tp);
            
            getServletContext().getRequestDispatcher("/ModificarTP.jsp").forward(request, response);
    */

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
        GestorTPsAlumnos gt = new GestorTPsAlumnos();
        TpsAlumnos tpa = new TpsAlumnos();
        
        boolean cargar = false;
        
        tpa.setIdTpAlumno(id);
        
        int legajo = Integer.parseInt(request.getParameter("Legajo"));
        
        String presentado = request.getParameter(""+legajo);
        String estado = request.getParameter("Estado"+legajo);
        if (presentado.equals("Si")) {
            tpa.setPresentado(1);
            if (estado.equals("A")) {
            tpa.setIdEstado(2);
        } else if (estado.equals("D")){
            tpa.setIdEstado(3);
        }else if (estado.equals("N")) {
            tpa.setIdEstado(1);
        }
        } else if (presentado.equals("No")){
            tpa.setPresentado(0);
            tpa.setIdEstado(1);
        }
        
        String p = request.getParameter("FechaS");
        if (p.equals("S")) {
            tpa.setFecha(request.getParameter("Fecha"));
            cargar = gt.modificarTPsAlumnosConfecha(tpa);
        } else if (p.equals("N")){
            cargar = gt.modificarTPsAlumnos(tpa);
        }
        
        if (cargar) {
            GestorTPsAlumnos g = new GestorTPsAlumnos();
            ArrayList<VMAlumnoCursoTpConFecha> alumno = g.obtenerAlumnosCursoTpTodos();
            
            request.setAttribute("alumno", alumno);
            
            getServletContext().getRequestDispatcher("/ListadoTP.jsp").forward(request, response);
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
