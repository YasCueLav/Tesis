/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.Fecha;
import Controladores.GestorAlumnos;
import Controladores.GestorAsistencias;
import Model.Alumno;
import Model.Asistencias;
import Model.VMAlumnosCursos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.component.UIData;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author Yasmin
 */
public class AltaAsistenciaServlet extends HttpServlet {

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

    private ArrayList<Fecha> cargarFechas(){
        ArrayList<Fecha> lista = new ArrayList<>();
                
                
        return lista;
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
            ArrayList<VMAlumnosCursos> alumno = ga.obtenerAlumnoCurso();
            
            Fecha f = new Fecha();
            
            /*DIA
            ArrayList<Integer> d = f.caragaDia();*/
            /*MES
            ArrayList<Integer> m = f.caragaMes();*/
            /*AÑO
            ArrayList<Integer> a = f.caragaAnio();*/
            /*
            request.setAttribute("d", d);
            request.setAttribute("m", m);
            request.setAttribute("a", a);*/
            request.setAttribute("alumno", alumno);
            
            getServletContext().getRequestDispatcher("/AltaAsistencia.jsp").forward(request, response);
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

        GestorAsistencias ga = new GestorAsistencias();

        String[] ids = request.getParameterValues("IdAlumno");
        String fechaObligatoria = request.getParameter("FechaObligatoria");
        
        System.out.println("CANT ID = " + ids.length);
        
        ArrayList <Asistencias> asistencias = new ArrayList<>();
                
        for (int i = 0; i < ids.length; i++) {
            
            System.out.println("ID = "+ ids[i]);
            
            Asistencias a = new Asistencias();
            a.setIdAlumno(Integer.parseInt(ids[i])); 
                        
            String presente = request.getParameter(""+a.getIdAlumno());
            if (presente.equals("P")) {
                a.setEstaPresente(1);
            } else {
                a.setEstaPresente(0);
            }
            
            if (fechaObligatoria != null) {
                a.setFechaObligatoria(1);
            } else {
                a.setFechaObligatoria(0);
            }
            
            asistencias.add(a);
        }
        
        boolean cargo = ga.agregarAsistencias(asistencias);
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
