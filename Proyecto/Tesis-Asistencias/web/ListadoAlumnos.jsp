<%-- 
    Document   : ListadoAlumnos
    Created on : 04/06/2018, 21:55:33
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Lista</title>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
            <h1>Listados de Alumnos</h1>
        
            </br>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col">Legajo</th>
                        <th scope="col" width="300">Apellido, Nombre</th>
                        <th scope="col">Curso - División </th>
                        <th scope="col">Condición </th>
                        <th scope="col">Grupo</th>
                        <th scope="col">Fecha de Ingreso</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${alumno}" var="a">
                            <tr>
                                <th scope="row" >${a.getLegajo()}</th>
                                <td> ${a.getApellido()}, ${a.getNombre()}</td>
                                <td>${a.getNombreCurso()} - ${a.getDivicionCurso()}</td>
                                <td>${a.getCondicion()}</td>
                                <td>${a.getGrupo()}</td>
                                <td>${a.getFecha()}</td>
                                <td id="letraNegrita">
                                    <a id="Link" href="/Tesis-Asistencias/ModificarAlumnosServlet?idAlumno=${a.getIdAlumno()}&tipo=1">Editar</a> / 
                                    <a id="Link" href="/Tesis-Asistencias/ModificarAlumnosServlet?idAlumno=${a.getIdAlumno()}&tipo=2">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
 </html>