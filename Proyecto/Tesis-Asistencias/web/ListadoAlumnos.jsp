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
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h2>Listados</h2>
        
        <h5>Listados de Alumnos</h5>
        <div>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col">legajo</th>
                        <th scope="col">Apellido, Nombre</th>
                        <th scope="col">Curso - Divicion</th>
                        <th scope="col">Condicion</th>
                        <th scope="col">Grupo</th>
                        <th scope="col">Fecha de ingreso</th>
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
                                <td>
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