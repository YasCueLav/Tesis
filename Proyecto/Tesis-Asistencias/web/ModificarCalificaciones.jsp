<%-- 
    Document   : ModificarCalificaciones
    Created on : 10/06/2018, 20:23:49
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Modificar</title>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
        <h1>Modificar Notas</h1>
        </br>
        
            <form action="ModificarCalificacionesServlet" method="POST">
                <table class="table table-striped">
                <thead>
                    <tr>
                      <th scope="col">Legajo</th>
                      <th scope="col">Apellido, Nombre</th>
                      <th scope="col">División</th>
                      <th scope="col">Nota</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${examen}" var="e">
                        <tr>
                            <th><input type="hidden" value="${e.getIdAlumno()}" name="IdAlumno">${e.getLegajo()}</th>
                            <td>${e.getApellido()}, ${e.getNombre()}</td>
                            <td>${e.getSeccion()}</td>
                            <td><input type="number" name="NumeoNota" placeholder="${e.getNota()}" value="${e.getNota()}"></td>
                        </tr>
                    </c:forEach>
                </tbody>
                </table>
                <input type="submit" value="Cargar" class="btn btn-primary" name="Boton" id="BotronCarga">
            </form>
        </div>
    </body>
</html>