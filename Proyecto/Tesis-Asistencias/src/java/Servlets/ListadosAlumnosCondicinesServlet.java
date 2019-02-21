/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorAlumnos;
import Controladores.GestorCondiciones;
import Model.ParametroCondicion;
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
public class ListadosAlumnosCondicinesServlet extends HttpServlet {

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
            GestorAlumnos ga = new GestorAlumnos();
            ArrayList<VMAlumnosCursosCondiciones> alumno = ga.obtenerAlumnoCursoCondiciones();
            
            request.setAttribute("alumno", alumno);
            
            getServletContext().getRequestDispatcher("/ListadosAlumnosCondicines.jsp").forward(request, response);
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
        GestorCondiciones gc = new GestorCondiciones();
        String[] ids = request.getParameterValues("IdAlumno");
        int[] id = new int[ids.length];
        
        for (int i = 0; i < ids.length; i++) {
            id[i]=Integer.parseInt(ids[i]);
        }
        
        ArrayList<ParametroCondicion> parametroCondicion = gc.obtenerParametrosCondiciones(id);
        boolean[] cargo = new boolean[ids.length];
        
        int alu = 0;
        double totalAsistencias = 0;
        double asistencia = 0;
        double notaParcial = 0;
        int todosTP = 0;
        int entregadosTP = 0;
        double notaTFI = 0;
        
        int j = 0;
        
        for (ParametroCondicion pc : parametroCondicion) {

            alu = pc.getIdAlmno();
            totalAsistencias = pc.getCantiAsistio();
            asistencia = (totalAsistencias*100)/pc.getTotalAsistencias();
            notaParcial = pc.getNotaParcial();
            todosTP = pc.getCantiTpAEntregar();
            entregadosTP = pc.getCantiTpEntregados();
            notaTFI = pc.getNotaTFI();
            
            if(todosTP <= entregadosTP){
                if(asistencia >= 80){
                    if(notaParcial >= 8){
                        if (notaTFI >= 8){
                            cargo[j] = gc.modificarCondicionAlumno(1, alu);
                        }
                    } //else 
                    if (notaParcial >= 7) {
                        if (notaTFI >= 7){
                            cargo[j] = gc.modificarCondicionAlumno(2, alu);
                        }
                    } //else 
                    if (notaParcial >= 4) {
                        if (notaTFI >= 7){
                            cargo[j] = gc.modificarCondicionAlumno(3, alu);
                        }else{
                            cargo[j] = gc.modificarCondicionAlumno(4, alu);
                        }
                    }else{
                        cargo[j] = gc.modificarCondicionAlumno(4, alu);
                    }
                }else{
                    cargo[j] = gc.modificarCondicionAlumno(5, alu);
                }
            }else{
                cargo[j] = gc.modificarCondicionAlumno(4, alu);
            }
            
            j++;
        }
        
       ///////////////////////////////////////////////////////////////////////// 
       /*
        //PROMOCION DIRECTA //
            if (asistencia >= 80){
                if (notaParcial >= 8){
                    if(todosTP <= entregadosTP) {
                        if (notaTFI >= 8) {
                            cargo[j] = gc.modificarCondicionAlumno(1, alu);
                            j++;
                            continue;
                        }
                    }
                }
            }

             //PROMOCION SISTEMA DE UNIDADES //
            if (asistencia >= 80){
                if (notaParcial >= 7){
                    if(todosTP <= entregadosTP) {
                        if (notaTFI >= 7) {
                            cargo[j] = gc.modificarCondicionAlumno(2, alu);
                            j++;
                            continue;
                        }
                    }
                }
            }

             //REGULAR //
            if (asistencia >= 80){
                if (notaParcial >= 4){
                    if(todosTP <= entregadosTP) {
                        if (notaTFI >= 7) {
                            cargo[j] = gc.modificarCondicionAlumno(3, alu);
                            j++;
                            continue;
                        }
                    }
                }
            }

             //LIBRE X NO CUMPLIMIENTO //
            if(todosTP >entregadosTP) {
                cargo[j] = gc.modificarCondicionAlumno(4, alu);
                j++;
                continue;
            }

             //lIBRE X AUSENCIAS //
            if (asistencia < 80){
                cargo[j] = gc.modificarCondicionAlumno(5, alu);
                j++;
            }else{
                j++;
            }

             //j++;
        }*/

        ////////////////////////////////////////////////////////////////////////
        int bien = 0;
        for (int i = 0; i < cargo.length; i++) {
            if(cargo[i]){
                bien++;
            }
        }
       
        if (bien == cargo.length) {
            GestorAlumnos g = new GestorAlumnos();
            ArrayList<VMAlumnosCursosCondiciones> alumno = g.obtenerAlumnoCursoCondiciones();
            
            request.setAttribute("alumno", alumno);
            
            getServletContext().getRequestDispatcher("/ListadosAlumnosCondicines.jsp").forward(request, response);
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
