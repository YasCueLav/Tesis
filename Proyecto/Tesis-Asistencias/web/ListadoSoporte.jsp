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
                                <th>${e.getTipoExamne()} ${e.getExamenNombre()}</th>
                                <td> ${e.getFecha()}</td>
                                <td>
                                    <a id="Link" href="/Tesis-Asistencias/UpdateTPServlet?idExamen=${e.getIdExamen()}?M=1">Editar</a> / 
                                    <a id="Link" href="/Tesis-Asistencias/UpdateTPServlet?idExamen=${e.getIdExamen()}?M=2">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
</html>
