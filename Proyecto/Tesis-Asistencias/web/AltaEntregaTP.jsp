<%-- 
    Document   : AltaEntregaTP
    Created on : 07/05/2018, 18:31:37
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Entrega TP</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1>Entrega de Trabajos Practicos</h1>
        <div>
            <form>
                <div>
                    <select name="Tp">
                    <option>Seleccione un Trabajo Practico ...</option>
                    <c:forEach items="${tp}" var="t">
                        <option>  ${t.getIdTp()} - ${t.getNombreTp()}</option>
                    </c:forEach>
                    </select>
                    <input type="date" name="fechaHoy" placeholder=""><!-- Crear clase que traiga fecha hoy y colocarla en valor por defecto-->
                </div>
                </br>
                <table class="table table-striped">
		  <thead>
			<tr>
			  <th scope="col">legajo</th>
			  <th scope="col">Apellido, Nombre</th>
			  <th scope="col">Divicion</th>
			  <th scope="col">entregado?</th>
			  <th scope="col">Nota?</th>
			</tr>
		  </thead>
                    <tbody>
                        <c:forEach items="${alumno}" var="a">
                            <tr>
                                <th name="Alumno" scope="row">${a.getLegajo()}</th>
                                <td>${a.getApellido()}, ${a.getNombre()} </td>
                                <td>${a.getDivicionCurso()}</td>
                                <td><input type="checkbox" name="Entregado"></td>
                                <td><input type="number" name="NotaTp"></td>
                            </tr>
                        </c:forEach>
                    </tbody>
		</table>
		<input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
