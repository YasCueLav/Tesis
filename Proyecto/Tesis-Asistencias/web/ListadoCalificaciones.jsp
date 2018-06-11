<%-- 
    Document   : ListadoCalificaciones
    Created on : 10/06/2018, 20:21:14
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Listado</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        
        <h1>Listado Calificacion</h1>
        
        <div>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col">Legajo</th>
                        <th scope="col">Apellido, Nombre</th>
                        <th scope="col">Curso - Divicion</th>
                        <th scope="col">Tipo Examen</th>
                        <th scope="col">Examen</th>
                        <th scope="col">Nota</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${examen}" var="e">
                            <tr>
                                <th> ${e.getLegajo()}</th>
                                <td>${e.getApellido()}, ${e.getNombre()}</td>
                                <td>${e.getNombreCurso()} - ${e.getSeccion()}</td>
                                <td>${e.getTipoExamen()}</td>
                                <td>${e.getExamen()}</td>
                                <td>${e.getNota()}</td>
                                <td>
                                    <a id="Link" href="/Tesis-Asistencias/ModificarCalificacionesServlet?idNota=${e.getIdNota()}&estado=1">Editar</a> / 
                                    <a id="Link" href="/Tesis-Asistencias/ModificarCalificacionesServlet?idNota=${e.getIdNota()}&estado=2">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
</html>
