<%-- 
    Document   : ModificarTFI
    Created on : 17/06/2018, 00:22:17
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
        <h1>Modificar de Trabajos Final Integrador</h1>
        <div>
            <c:forEach items="${tp}" var="p">
                <h3>${p.getLegajo()} -- ${p.getfEntregado()} </h3>
            </c:forEach>
            <form action="ModificarTFIServlet" method="POST">
                <table class="table table-striped">
		  <thead>
			<tr>
			  <th scope="col">legajo</th>
			  <th scope="col">Apellido, Nombre</th>
			  <th scope="col">Divicion</th>
			  <th scope="col">Entregado?</th>
			  <th scope="col">Nota</th>
			</tr>
		  </thead>
                    <tbody>
                        <c:forEach items="${tp}" var="p">
                                <th><input type="hidden" value="${p.getIdAlumno()}" name="IdAlumno"> ${p.getLegajo()}</th>
                                <td>${p.getApellido()}, ${p.getNombre()}</td>
                                <td>${p.getDivicionCurso()}</td>
                                <td>
                                    <c:if test="${p.isPresentado()}">
                                        Si <input type="radio" name="${p.getIdAlumno()}" value="Si" checked="true">- 
                                        No <input type="radio" name="${p.getIdAlumno()}" value="No">
                                    </c:if>
                                    <c:if test="${!p.isPresentado()}">
                                        Si <input type="radio" name="${p.getIdAlumno()}" value="Si">- 
                                        No <input type="radio" name="${p.getIdAlumno()}" value="No" checked="true">
                                    </c:if>
                                </td>
                                <td>
                                    <input type="number" name="Nota" value="${p.getNota()}" placeholder="${p.getNota()}">
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
