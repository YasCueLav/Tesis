<%-- 
    Document   : ListadoSoporte
    Created on : 31/05/2018, 21:44:43
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
        
        <h5>Listados de Examenes</h5>
        <div>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col">Examen</th>
                        <th scope="col">Fecha del Examen</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${examen}" var="e">
                            <tr>
                                <td>${e.getTipoExamne()} ${e.getExamenNombre()}</td>
                                <td> ${e.getFecha()}</td>
                                <td>
                                    <a id="Link" href="/Tesis-Asistencias/UpdateParcialServlet?idExamen=${e.getIdExamen()}&estado=1">Editar</a> / 
                                    <a id="Link" href="/Tesis-Asistencias/UpdateParcialServlet?idExamen=${e.getIdExamen()}&estado=2">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
        
        <h5>Listados de Trabajos Practicos</h5>
        <div>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col">Trabjao Practico</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${tp}" var="t">
                            <tr>
                                <td>${t.getNombreTp()}</td>
                                <td>
                                    <a id="Link" href="/Tesis-Asistencias/UpdateTPServlet?idTp=${t.getIdTp()}&estado=1">Editar</a> / 
                                    <a id="Link" href="/Tesis-Asistencias/UpdateTPServlet?idTp=${t.getIdTp()}&estado=2">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
<%--/////////////////////////////////////////////////////////////////////////// --%>
        <h5>Listados de Condiciones</h5>
        <div>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col">Condicion</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${condicion}" var="c">
                            <tr>
                                <td>${c.getCondicion()}</td>
                                <td>
                                    <a id="Link" href="/Tesis-Asistencias/UpdateCondicionServlet?idCodicion=${c.getIdCondicion()}&estado=1">Editar</a> / 
                                    <a id="Link" href="/Tesis-Asistencias/UpdateCondicionServlet?idCodicion=${c.getIdCondicion()}&estado=2">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
<%--/////////////////////////////////////////////////////////////////////////// --%>
        <h5>Listados de Cursos</h5>
        <div>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col">Nombre</th>
                        <th scope="col">Seccion</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${curso}" var="cu">
                            <tr>
                                <td>${cu.getNombreCurso()}</td>
                                <td> ${cu.getSeccionCurso()}</td>
                                <td>
                                    <a id="Link" href="/Tesis-Asistencias/UpdateCursoServlet?idCurso=${cu.getIdCursos()}&estado=1">Editar</a> / 
                                    <a id="Link" href="/Tesis-Asistencias/UpdateCursoServlet?idCurso=${cu.getIdCursos()}&estado=2">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
</html>
