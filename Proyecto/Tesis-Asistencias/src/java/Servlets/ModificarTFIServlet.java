/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controladores.GestorTPsAlumnos;
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
public class ModificarTFIServlet extends HttpServlet {

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
        id = Integer.parseInt(request.getParameter("idAlumno"));
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
        id = Integer.parseInt(request.getParameter("idAlumno"));
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

                    getServletContext().getRequestDispatcher("/ModificarTFI.jsp").forward(request, response);
                    break;
                case 2:
                    gt = new GestorTPsAlumnos();
                    boolean ca = gt.EliminarTFI(id );
                    
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
        GestorTPsAlumnos gt = new GestorTPsAlumnos();
        VMAlumnoCursoTpConFecha tpa = new VMAlumnoCursoTpConFecha();
        
        boolean cargar = false;
        
        tpa.setIdAlumno(id);
        
        int alum = Integer.parseInt(request.getParameter("IdAlumno"));
        
        String presentado = request.getParameter(""+alum);
        if (presentado.equals("Si")) {
            tpa.setPresentado(1);
            tpa.setNota(Integer.parseInt(request.getParameter("Nota")));
        } else if (presentado.equals("No")){
            tpa.setPresentado(0);
            tpa.setNota(0);
        }
        
        String p = request.getParameter("FechaS");
        if (p.equals("S")) {
            tpa.setFechaS(request.getParameter("Fecha"));
            cargar = gt.modificarTfiAlumnosConfecha(tpa);
        } else if (p.equals("N")){
            cargar = gt.modificarTfiAlumnos(tpa);
        }
        
        if (cargar) {
            GestorTPsAlumnos g = new GestorTPsAlumnos();
            ArrayList<VMAlumnoCursoTpConFecha> alumno = g.obtenerAlumnosCursoTfiTodo();
            
            request.setAttribute("alumno", alumno);
            
            getServletContext().getRequestDispatcher("/ListadoTFI.jsp").forward(request, response);
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
