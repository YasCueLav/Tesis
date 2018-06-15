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
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class ModificarAlumnosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int id =0;
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
            GestorAlumnos ga;
            switch (m){
                case 1: 
                    ga = new GestorAlumnos();
                    Alumno alumno = ga.obtenerAlumno(id);
                    
                    GestorCursos gc = new GestorCursos();
                    ArrayList<Cursos> curso = gc.obtenerCursos();
                    
                    GestorCondiciones go = new GestorCondiciones();
                    ArrayList<Condiciones> condicion = go.obtenerCondiciones();

                    request.setAttribute("alumno", alumno);
                    request.setAttribute("curso", curso);
                    request.setAttribute("condicion", condicion);
            
                    getServletContext().getRequestDispatcher("/ModificarAlumnos.jsp").forward(request, response);
                    break;
                case 2:
                    ga = new GestorAlumnos();
                    boolean ca = ga.elimniarAlumno(id);
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
        GestorAlumnos ga = new GestorAlumnos();
        Alumno alu = ga.obtenerAlumno(id);
        Alumno a = new Alumno();
        
        int legajo = Integer.parseInt(request.getParameter("Legajo"));
        String nombre = request.getParameter("Nombre");
        String apellido = request.getParameter("Apellido");
        int cu = Integer.parseInt(request.getParameter("curso"));
        int con = Integer.parseInt(request.getParameter("Condicion"));
        int grupo = Integer.parseInt(request.getParameter("Grupo"));
        
        a.setIdAlumno(id);
        
        if(legajo != alu.getLegajo() || legajo != 0){
            a.setLegajo(legajo);
        } else{
            a.setLegajo(alu.getLegajo());
        }
        
        if(!nombre.equals("") || !nombre.equals(alu.getNombre())){
          a.setNombre(nombre);
        }else{
            a.setNombre(alu.getNombre());
        }
        
        if(!"".equals(apellido) && !apellido.equals(alu.getApellido())){
            a.setApellido(apellido);
        }else{
            a.setApellido(alu.getApellido());
        }
        
        if(cu != alu.getIdCurso()  && cu != 0){
            a.setIdCurso(cu);
        }else{
            a.setIdCurso(alu.getIdCurso());
        }
        
        if(con != alu.getIdCondicion()  && con != 0){
            a.setIdCondicion(con);
        }else{
            a.setIdCondicion(alu.getIdCondicion());
        }
        
        if(grupo != alu.getGrupo()){
            a.setIdCondicion(grupo);
        }else{
            a.setGrupo(alu.getGrupo());
        }
        
        boolean cargo = ga.modificarAlumno(a);
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

    public static Date ParseFecha(String fe) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaDate = null;
        try {
            fechaDate = (Date) formato.parse(fe);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
}
