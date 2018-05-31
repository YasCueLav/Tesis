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
        ArrayList<TpsAlumnos> trabAlum = new ArrayList<>();
        ArrayList<Notas> notas = new ArrayList<>();
        
        GestorTPsAlumnos gta = new GestorTPsAlumnos();
        GestorNotas gn = new GestorNotas();
        
        int idTp = Integer.parseInt(request.getParameter("Tp"));
                
        String[] ids = request.getParameterValues("IdAlumno");
        
        String[] nota = request.getParameterValues("NotaTp");
        
        for (int i = 0; i < ids.length; i++) {
            
            TpsAlumnos tpa = new TpsAlumnos();
            Notas n = new Notas();

            tpa.setIdTp(idTp);
            tpa.setIdAlumno(Integer.parseInt(ids[i]));
            String entregado = request.getParameter(""+tpa.getIdAlumno());
            if (entregado.equals("Si")) {
                tpa.setPresentado(0);
            }else {
                tpa.setPresentado(1);
            }
            
            n.setNota(Double.parseDouble(nota[i]));
            n.setIdAlumno(Integer.parseInt(ids[i]));
            
            n.setIdTp(idTp);
            
            trabAlum.add(tpa);
            notas.add(n);
        }
        
        boolean cargo = gta.agregarTPsAlumnos(trabAlum);
        boolean cargoN = gn.agregarNotaTPs(notas);
        
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
