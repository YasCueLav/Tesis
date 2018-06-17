<%-- 
    Document   : ModificarTP
    Created on : 16/06/2018, 22:39:44
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
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1>Modificar de Trabajos Practicos</h1>
        <div>
        <c:forEach items="${tp}" var="p">
            <h3>${p.getLegajo()} -- ${p.getfEntregado()} </h3>
        </c:forEach>
            
            <form action="ModificarTPServlet" method="POST">
                <table class="table table-striped">
		  <thead>
			<tr>
			  <th scope="col">legajo</th>
			  <th scope="col">Apellido, Nombre</th>
			  <th scope="col">Divicion</th>
			  <th scope="col">Entregado?</th>
			  <th scope="col">Estado TP</th>
			</tr>
		  </thead>
                    <tbody>
                        <c:forEach items="${tp}" var="p">
                            <tr>
                                <th><input type="hidden" name="Legajo" value="${p.getLegajo()}"> ${p.getLegajo()}</th>
                                <td>${p.getApellido()}, ${p.getNombre()} </td>
                                <td>${p.getDivicionCurso()}</td>
                                <td>
                                    <c:if test="${p.isPresentado()}">
                                        Si <input type="radio" name="${p.getLegajo()}" value="Si" checked="true">- 
                                        No <input type="radio" name="${p.getLegajo()}" value="No">
                                    </c:if>
                                    <c:if test="${!p.isPresentado()}">
                                        Si <input type="radio" name="${p.getLegajo()}}" value="Si">- 
                                        No <input type="radio" name="${p.getLegajo()}" value="No" checked="true">
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${p.isEstadoBool()} && !${p.isX()}">
                                        Aprobado <input type="radio" name="Estado${p.getLegajo()}" value="A"  checked="true">- 
                                        No Aprobado<input type="radio" name="Estado${p.getLegajo()}" value="D">
                                        <input type="radio"  id="invisible" name="Estado${p.getLegajo()}" value="N">
                                    </c:if>
                                    <c:if test="${!p.isEstadoBool()}  && !${p.isX()}">
                                        Aprobado <input type="radio" name="Estado${p.getLegajo()}" value="A">- 
                                        No Aprobado<input type="radio" name="Estado${p.getLegajo()}" value="D"  checked="true">
                                        <input type="radio"  id="invisible" name="Estado${p.getLegajo()}" value="N">
                                    </c:if>
                                    <c:if test="${p.isX()}">
                                        Aprobado <input type="radio" name="Estado${p.getLegajo()}" value="A">- 
                                        No Aprobado<input type="radio" name="Estado${p.getLegajo()}" value="D">
                                        <input type="radio"  id="invisible" name="Estado${p.getLegajo()}" value="N" checked="true">
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
		</table>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Fecha Entregado</label>
                    Si<input type="radio" name="FechaS" value="S"> - 
                    No<input type="radio" name="FechaS" value="N" checked="true">
                    <input type="date" name="Fecha"> 
                </div>
		<input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
