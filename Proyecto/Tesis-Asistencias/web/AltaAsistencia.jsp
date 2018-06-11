<%-- 
    Document   : AltaAsistencia
    Created on : 25/04/2018, 16:40:15
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Asistencia</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <div>
            <h2>Asistencia día </h2>
            <form action="AltaAsistenciaServlet" method="POST">
                <h5><input type="date" name="fechaHoy" value=""> <input type="checkbox" name="FechaObligatoria" value="false"> Fecha Obligatoria</h5>
                <br>
                <table class="table table-striped" name="tabla">
                  <thead>
                        <tr>
                          <th scope="col">legajo</th>
                          <th scope="col">Apellido, Nombre</th>
                          <th scope="col">Divicion</th>
                          <th scope="col">Asistio?</th>
                        </tr>
                  </thead>
                    <div>
                        <tbody>
                            <c:forEach items="${alumno}" var="a">
                                <tr>
                                    <th scope="row" >
                                        <input type="hidden" value="${a.getIdAlumno()}" name="IdAlumno"> ${a.getLegajo()}
                                    </th>
                                    <td> ${a.getApellido()}, ${a.getNombre()}</td>
                                    <td value="${a.getIdCurso()}" name="IdCurso">${a.getDivicionCurso()}</td>
                                    <td>
                                        P<input type="radio" name="${a.getIdAlumno()}" value="P"> - 
                                        A<input type="radio" name="${a.getIdAlumno()}" value="A" checked="true">
                                    </td>
                                </tr>
                                
                            </c:forEach>
                          </tbody>
                    </div>
                </table>
                <input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
