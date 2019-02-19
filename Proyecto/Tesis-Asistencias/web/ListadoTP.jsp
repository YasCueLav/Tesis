<%-- 
    Document   : ListadoTP
    Created on : 16/06/2018, 18:09:48
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
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
            
        <h1>Listado de entregas de trabajos prácticos</h1>
        </br>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr id="centrarConTabla">
                        <th scope="col" colspan="2" id="bordesCeldas">Alumno</th>
                        <th scope="col" colspan="2" id="bordesCeldas">Materia</th>
                        <th scope="col" rowspan="2" id="bordesCeldasSuperior">Trabajo Prácticos </th>
                        <th scope="col" colspan="2" id="bordesCeldas">Fecha</th>
                        <th scope="col" rowspan="2" id="bordesCeldasSuperior">Estado</th>
                        <th scope="col" rowspan="2" id="bordesCeldasSuperior"></th>
                    </tr>
                    <tr>
                        <th scope="col">Legajo</th>
                        <th scope="col">Apellido, Nombre</th>
                        <th scope="col">Curso</th>
                        <th scope="col">División</th>
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
                                <td>${a.getfEntrega()}</td>
                                <td>${a.getfEntregado()}</td>
                                <td>${a.getEstado()}</td>
                                <td id="letraNegrita">
                                    <a id="Link" href="/Tesis-Asistencias/ModificarTPServlet?idTpAlumno=${a.getIdTpAlumno()}&tipo=1">Editar</a> /
                                    <a id="Link" href="/Tesis-Asistencias/ModificarTPServlet?idTpAlumno=${a.getIdTpAlumno()}&tipo=2">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
</html>
