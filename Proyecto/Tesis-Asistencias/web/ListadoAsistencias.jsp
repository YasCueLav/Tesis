<%-- 
    Document   : ListadoAsistencias
    Created on : 31/05/2018, 16:21:24
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado Asistencia</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
            <h1>Listado Asistencia</h1>
            <br>
            <form action="ListadoAsistenciasServlet" method="POST">
                <div>
                    <input type="number" name="Legajo" value="0" id="tamLegajoLBL">
                    
                    <select name="Curso" id="tamcursoCMB">
                        <option value="0">Seleccione un curso ...</option>
                        <c:forEach items="${curso}" var="c">
                            <option name="IdCurso" value="${c.getIdCursos()}">${c.getIdCursos()}-${c.getNombreCurso()}/${c.getSeccionCurso()}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Filtrar" class="btn btn-primary" name="Boton" >
                </div>
                </br>
            </form>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col" width="50">Legajo</th>
                        <th scope="col" width="300">Apellido, Nombre</th>
                        <th scope="col" >Divicion</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Obligatoria</th>
                        <th scope="col">Asistió?</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${alumno}" var="a">
                            <tr>
                                <th scope="row" >${a.getLegajo()}</th>
                                <td> ${a.getApellido()}, ${a.getNombre()}</td>
                                <td>${a.getDivicionCurso()}</td>
                                <td>${a.getFechaReguistro()}</td>
                                <c:if test="${a.isFechaObligatoria()}">
                                    <td>Si</td>
                                </c:if>
                                <c:if test="${!a.isFechaObligatoria()}">
                                    <td>No</td>
                                </c:if>

                                <c:if test="${!a.isEstaPresente()}">
                                    <td>A</td>
                                </c:if>
                                <c:if test="${a.isEstaPresente()}">
                                    <td>P</td>
                                </c:if>

                                <td id="letraNegrita">
                                    <a id="Link" href="/Tesis-Asistencias/ModificarAsistenciasServlet?idAsistencia=${a.getIdAsistencias()}">Editar</a>
                                    <c:if test="${!a.isEstaPresente()}">
                                        /<a id="Link" href="/Tesis-Asistencias/AltaJustificativoServlet?idAsistencia=${a.getIdAsistencias()}">Justificar</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
</html>
