<%-- 
    Document   : ListadoTPEntregados
    Created on : 19/06/2018, 10:55:17
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrega TP</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <nav aria-label="Page navigation example" id="bordesnabegacion">
                <ul class="pagination">
                  <li class="page-item"><a class="page-link" href="/Tesis-Asistencias/${t.getTxt()}">Volver</a></li>
                </ul>
        </nav>
        
        <div id="bordesGenerales">
            <h1>Trabajos Practicos Entregados</h1>
            </br>
            
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col" colspan="2" id="bordesCeldas">Alumno</th>
                        <th scope="col" colspan="2" id="bordesCeldas">Materia</th>
                        <th scope="col" rowspan="2" id="bordesCeldasSuperior">Trabajo Practico</th>
                        <th scope="col" colspan="2" id="bordesCeldas">Fecha</th>
                        <th scope="col" rowspan="2" id="bordesCeldasSuperior">Estado</th>
                    </tr>
                    <tr>
                        <th scope="col">legajo</th>
                        <th scope="col">Apellido, Nombre</th>
                        <th scope="col">Curso</th>
                        <th scope="col">Divicion</th>
                        <th scope="col">de Entrega</th>
                        <th scope="col">Entregado</th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${alumno}" var="a">
                            <tr>
                                <th> ${a.getLegajo()}</th>
                                <td>${a.getApellido()} ${a.getNombre()}</td>
                                <td>${a.getNombreCurso()}</td>
                                <td>${a.getDivicionCurso()}</td>
                                <td>${a.getTp()}</td>
                                <td>${a.getFechaEntrega()}</td>
                                <td>${a.getFechaEntregado()}</td>
                                <td>${a.getEsatdo()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
            
        </div>
    </body>
</html>