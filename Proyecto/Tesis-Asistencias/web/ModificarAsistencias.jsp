<%-- 
    Document   : ModificarAsistencias
    Created on : 31/05/2018, 16:20:44
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Asistencia</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <div>
            <h2>Editar Asistencia</h2>
            <form action="ModificarAsistenciasServlet" method="POST">
                <input type="hidden" name="idAlquiler" value="${alumno.getIdAsistencias()}">
            
                <h5>
                    <c:if test="${alumno.isFechaObligatoria()}">
                        <input type="checkbox" name="FechaObligatoria" value="ture">
                    </c:if>
                    <c:if test="${!alumno.isFechaObligatoria()}">
                        <input type="checkbox" name="FechaObligatoria" value="false">
                    </c:if>
                Fecha Obligatoria</h5>
                <br>
                <table class="table table-striped" name="tabla">
                  <thead>
                        <tr>
                          <th scope="col">legajo</th>
                          <th scope="col">Apellido, Nombre</th>
                          <th scope="col">Divicion</th>
                          <th scope="col">Fecha</th>
                          <th scope="col">Asistio?</th>
                        </tr>
                  </thead>
                    <div>
                        <tbody>
                            <tr>
                                <th scope="row" >${alumno.getLegajo()}</th>
                                <td> ${alumno.getApellido()}, ${alumno.getNombre()}</td>
                                <td>${alumno.getDivicionCurso()}</td>
                                <td>${alumno.getFechaReguistro()}</td>
                                <td>
                                    <c:if test="${!alumno.isEstaPresente()}">
                                        A <input type="radio" name="${alumno.getIdAlumno()}" value="A" checked="true">
                                    </c:if>
                                    <c:if test="${alumno.isEstaPresente()}">
                                        P<input type="radio" name="${alumno.getIdAlumno()}" value="P" checked="true">
                                    </c:if>
                                </td>
                            </tr>
                          </tbody>
                    </div>
                </table>
                <input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
