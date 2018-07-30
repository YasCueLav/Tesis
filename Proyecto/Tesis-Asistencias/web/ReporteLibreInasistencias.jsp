<%-- 
    Document   : ReporteLibreInasistencias
    Created on : 17/06/2018, 17:40:48
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libre por Inasistencias</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1>Alumnos Libre por Inasistencias</h1>
        <div>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col" colspan="2">Alumno</th>
                        <th scope="col" colspan="2">Materia</th>
                        <th scope="col">Condicion</th>
                        <th scope="col"></th>
                    </tr>
                    <tr>
                        <th scope="col">legajo</th>
                        <th scope="col">Apellido, Nombre</th>
                        <th scope="col">Curso</th>
                        <th scope="col">Divicion</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${alumno}" var="a">
                            <tr>
                                <th>${a.getLegajo()}</th>
                                <td>${a.getApellido()} ${a.getNombre()}</tdh>
                                <td>${a.getNombreCurso()}</td>
                                <td>${a.getDivicionCurso()}</td>
                                <td>${a.getCondicion()}</td>
                                <td>
                                    <a id="Link" href="/Tesis-Asistencias/ListadoAsistenciasEspecificoServlet?legajo=${a.getLegajo()}">Ver</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
</html>
