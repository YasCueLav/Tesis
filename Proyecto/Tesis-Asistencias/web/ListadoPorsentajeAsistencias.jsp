<%-- 
    Document   : ListadoPorsentajeAsistencias
    Created on : 19/06/2018, 10:54:52
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
        <nav aria-label="Page navigation example">
                <ul class="pagination">
                  <li class="page-item"><a class="page-link" href="/Tesis-Asistencias/${t.getTxt()}">Volver</a></li>
                </ul>
        </nav>
        <h1>Listado de Inasistencias</h1>
        <div>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col" colspan="2">Alumno</th>
                        <th scope="col" colspan="2">Materia</th>
                        <th scope="col" colspan="2">Asistencias Tomadas</th>
                        <th scope="col" colspan="2">Porcentaje de Asistencia</th>
                    </tr>
                    <tr>
                        <th scope="col">legajo</th>
                        <th scope="col">Apellido, Nombre</th>
                        <th scope="col">Curso</th>
                        <th scope="col">Divicion</th>
                        <th scope="col">Totales</th>
                        <th scope="col">Obligatorias</th>
                        <th scope="col">Totales</th>
                        <th scope="col">Obligatorias</th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${alumno}" var="a">
                            <tr>
                                <th scope="row" >${a.getLegajo()}</th>
                                <td> ${a.getApellido()}, ${a.getNombre()}</td>
                                <td>${a.getNombreCurso()}</td>
                                <td>${a.getDivicionCurso()}</td>
                                <td>${a.getTotalAsistencias}</td>
                                <td>${a.getTotalAsistenciasObligatoria}</td>
                                <td>${a.getPromedioAsis}</td>
                                <td>${a.getPromedioAsisObligatoria}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
</html>
