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
        <title>Modificar Asistencia</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
            
            <h2>Modificar Asistencia</h2>
            </br>
            
            <form action="ModificarAsistenciasServlet" method="POST">
                
            <%--
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
            --%>
                <table class="table table-striped" name="tabla">
                  <thead>
                        <tr>
                          <th scope="col">Legajo</th>
                          <th scope="col">Apellido, Nombre</th>
                          <th scope="col">División</th>
                          <th scope="col">Fecha</th>
                          <th scope="col">Asistió?</th>
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
                                        A <input type="radio" name="estado" value="A" checked="true">
                                        P<input type="radio" name="estado" value="P">
                                    </c:if>
                                    <c:if test="${alu.isEstaPresente()}">
                                        A <input type="radio" name="estado" value="A"> - 
                                        P<input type="radio" name="estado" value="P" checked="true">
                                    </c:if>
                                </td>
                            </tr>
                          </tbody>
                    </div>
                </table>
                <input type="submit" value="Cargar" class="btn btn-primary" id="BotronCarga">
                <div id="mp"></div>
        </form>
        </div>
    </body>
</html>
