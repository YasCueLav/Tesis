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
        <title>Cargar Notas Examenes</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1>Cargar Notas Examenes</h1>
        <div>
            <form action="AltaCalificacionServlet" method="POST">
                
                <select name="Examen">
                    <option>Seleccione un examen ...</option>
                <c:forEach items="${examen}" var="e">
                     <option name="IdExamen" value="${e.getIdExamen()}">${e.getIdExamen()}- ${e.getExamenNombre()} - ${e.getTipoExamne()}</option>
                </c:forEach>
                </select>
                
                <%--
                <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Seleccione un examen ...
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <c:forEach items="${examen}" var="e">
                        <a class="dropdown-item" name="IdExamenA" value="${e.getIdExamen()}" >${e.getExamenNombre()} - ${e.getTipoExamne()}</a>
                    </c:forEach>
                </div>
              </div>
                --%>
                
                <select name="Curso">
                    <option>Seleccione un curso ...</option>
                <c:forEach items="${curso}" var="c">
                     <option name="IdCurso" value="${c.getIdCursos()}">${c.getIdCursos()}-${c.getNombreCurso()}/${c.getSeccionCurso()}</option>
                </c:forEach>
                </select>
                <input type="submit" value="Filtrar" class="btn btn-primary" name="Boton">
                </br>
                
                <table class="table table-striped">
                <thead>
                    <tr>
                      <th scope="col">legajo</th>
                      <th scope="col">Apellido, Nombre</th>
                      <th scope="col">Divicion</th>
                      <th scope="col">Nota</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${alumno}" var="a">
                        <tr>
                            <th><input type="hidden" value="${a.getIdAlumno()}" name="IdAlumno"> ${a.getLegajo()}</th>
                            <td>${a.getApellido()}, ${a.getNombre()} </td>
                            <td>${a.getDivicionCurso()}</td>
                            <td><input type="number" name="NumeoNota"></td>
                        </tr>
                    </c:forEach>
                </tbody>
                </table>
                <input type="submit" value="Cargar" class="btn btn-primary" name="Boton">
            </form>
        </div>
    </body>
</html>
