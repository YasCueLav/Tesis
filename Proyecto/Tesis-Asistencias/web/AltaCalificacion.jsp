<%-- 
    Document   : AltaCalificacion
    Created on : 02/05/2018, 19:09:14
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Cargar Notas Exámenes </title>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
            
            <h1>Cargar Notas Exámenes </h1>
            
            <form action="AltaCalificacionServlet" method="POST">
                
                <select name="Examen">
                    <option>Seleccione un examen ...</option>
                <c:forEach items="${examen}" var="e">
                     <option name="IdExamen" value="${e.getIdExamen()}">${e.getIdExamen()}- ${e.getExamenNombre()} - ${e.getTipoExamne()}</option>
                </c:forEach>
                </select>
                
                <select name="Curso">
                    <option>Seleccione un curso ...</option>
                <c:forEach items="${curso}" var="c">
                     <option name="IdCurso" value="${c.getIdCursos()}">${c.getIdCursos()}-${c.getNombreCurso()}/${c.getSeccionCurso()}</option>
                </c:forEach>
                </select>
                <input type="submit" value="Filtrar" class="btn btn-primary" name="Boton">
                </br>
                </br>

                <table class="table table-striped">
                <thead>
                    <tr>
                      <th scope="col" width="50">Legajo</th>
                      <th scope="col" width="300">Apellido, Nombre</th>
                      <th scope="col" width="60">División</th>
                      <th scope="col">Nota</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${alumno}" var="a">
                        <tr>
                            <th><input type="hidden" value="${a.getIdAlumno()}" name="IdAlumno"> ${a.getLegajo()}</th>
                            <td>${a.getApellido()}, ${a.getNombre()} </td>
                            <td>${a.getDivicionCurso()}</td>
                            <td><input type="number" name="NumeoNota" value="0" placeholder="0"></td>
                        </tr>
                    </c:forEach>
                </tbody>
                </table>
                <input type="submit" value="Cargar" class="btn btn-primary" name="Boton" id="BotronCarga">
            </form>
        </div>
    </body>
</html>
