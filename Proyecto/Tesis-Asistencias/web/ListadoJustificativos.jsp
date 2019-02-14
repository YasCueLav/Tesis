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
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        
        <div id="bordesGenerales">
            <h1>Listado de Justificativos de Inasistencias</h1>
            
            </br>
            
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col" width="50">Legajo</th>
                        <th scope="col" width="300">Apellido, Nombre</th>
                        <th scope="col" width="200">Fecha Inasistencia</th>
                        <th scope="col" width="100">Justificativo</th>
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
                                <td id="letraNegrita">
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
