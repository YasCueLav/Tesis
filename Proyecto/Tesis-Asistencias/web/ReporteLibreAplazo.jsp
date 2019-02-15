<%-- 
    Document   : ReporteLibreAplazo
    Created on : 17/06/2018, 17:41:29
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libre</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <nav aria-label="Page navigation example" id="bordesnabegacion">
                <ul class="pagination">
                  <li class="page-item"><a class="page-link" href="/Tesis-Asistencias/ReporteAprobacionDirectaServlet">Listado</a></li>
                  <li class="page-item"><a class="page-link" href="/Tesis-Asistencias/ListadoPromedioNotaServlet?condi=4">Promedio Notas</a></li>
                  <li class="page-item"><a class="page-link" href="/Tesis-Asistencias/ListadoPorsentajeAsistenciasServlet?condi=4">Porsentajes Asistencias</a></li>
                  <li class="page-item"><a class="page-link" href="/Tesis-Asistencias/ListadoTPEntregadosServlet?condi=4">TPs Entregados</a></li>
                </ul>
            </nav>
        
        <div id="bordesGenerales">
            
            <h1>Alumnos Libre por no Cumplimiento</h1>
            </br>
        
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col" colspan="2" id="bordesCeldas">Alumno</th>
                        <th scope="col" colspan="2" id="bordesCeldas">Materia</th>
                        <th scope="col" id="bordesCeldas">Condicion</th>
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
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
</html>
