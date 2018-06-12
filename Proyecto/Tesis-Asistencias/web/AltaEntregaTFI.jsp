<%-- 
    Document   : AltaEntregaTFI
    Created on : 12/06/2018, 03:24:20
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Entrega TFI</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1>Entrega de Trabajos Final Integrador</h1>
        <div>
            <form action="AltaEntregaTFIServlet" method="POST">
                <div>
                    <select name="Tp">
                    <option>Seleccione un Trabajo Practico ...</option>
                    <c:forEach items="${tp}" var="t">
                        <option value="${t.getIdTp()}">${t.getNombreTp()}</option>
                    </c:forEach>
                    </select>
                    <input type="date" name="Fecha">
                </div>
                </br>
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
                        <c:forEach items="${alumno}" var="a">
                            <tr>
                                <th><input type="hidden" value="${a.getIdAlumno()}" name="IdAlumno"> ${a.getLegajo()}</th>
                                <td>${a.getApellido()}, ${a.getNombre()} </td>
                                <td>${a.getDivicionCurso()}</td>
                                <td>
                                    Si <input type="radio" name="${a.getIdAlumno()}" value="Si">- 
                                    No <input type="radio" name="${a.getIdAlumno()}" value="No" checked="true">
                                </td>
                                <td>
                                    <input type="number" name="Nota" value="0">
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
		</table>
		<input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
