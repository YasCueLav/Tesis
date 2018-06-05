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
                
            
                <h5> Fecha Obligatoria
                    <c:if test="${alu.isFechaObligatoria()}">
                        Si <input type="radio" name="FechaObligatoria" value="ture"> - 
                        No<input type="radio" name="FechaObligatoria">
                    </c:if>
                    <c:if test="${!alu.isFechaObligatoria()}">
                        Si<input type="radio" name="FechaObligatoria"> - 
                        No<input type="radio" name="FechaObligatoria" value="ture">
                    </c:if>
                </h5>
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
                                <th scope="row" >${alu.getLegajo()}</th>
                                <td> ${alu.getApellido()}, ${alu.getNombre()}</td>
                                <td>${alu.getDivicionCurso()}</td>
                                <td>${alu.getFechaReguistro()}</td>
                                <td>
                                    <c:if test="${!alu.isEstaPresente()}">
                                        A <input type="radio" name="${alu.getIdAlumno()}" value="A" checked="true">
                                        P<input type="radio" name="${alu.getIdAlumno()}" value="P">
                                    </c:if>
                                    <c:if test="${alu.isEstaPresente()}">
                                        A <input type="radio" name="${alu.getIdAlumno()}" value="A"> - 
                                        P<input type="radio" name="${alu.getIdAlumno()}" value="P" checked="true">
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
