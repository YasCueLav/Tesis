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
            <h2>Asistencia día <input type="date" name="fechaHoy" value=""> </h2>
            <form action="AltaAsistenciaServlet" method="POST">
                <input type="checkbox" name="FechaObligatoria" value=""> Fecha Obligatoria<br>
                <table class="table table-striped">
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
                                    <th val scope="row" <%--value="${a.getIdAlumno}"--%>> ${a.getLegajo}</th>
                                    <td> ${a.getApellido}, ${a.getNombre}</td>
                                    <td <%--value="${a.getIdCurso}"--%>>${a.getDivicionCurso}</td>
                                    <td><input type="checkbox" class="form-check-input" name="Asistencia" value="false"></td>
                                </tr>
                            </c:forEach>
                          </tbody>
                    </div>
                </table>
                <input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
        <!--<c:forEach items="${alumno}" var="a">
            <p>${a.getLegajo}</p>            
        </c:forEach>-->
    </body>
</html>
