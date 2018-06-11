<%-- 
    Document   : ListadoJustificativos
    Created on : 10/06/2018, 17:46:46
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
        
        <h2>Listado de Justificativos de Inasistencias</h2>
        <div>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col">Legajo</th>
                        <th scope="col">Apellido, Nombre</th>
                        <th scope="col">Fecha Inasistencia</th>
                        <th scope="col">Justificativo</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${justi}" var="j">
                            <tr>
                                <td> ${j.getLegajo()}</td>
                                <th>${j.getApellido()} ${j.getNombre()}</th>
                                <td> ${j.getFecha()}</td>
                                <td> ${j.getTexto()}</td>
                                <td>
                                    <a id="Link" href="/Tesis-Asistencias/UpdateJustificativoServlet?idAsistencia=${j.getIdAsistencias()}&estado=1">Editar</a> / 
                                    <a id="Link" href="/Tesis-Asistencias/UpdateJustificativoServlet?idAsistencia=${j.getIdAsistencias()}&estado=2">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
</html>
