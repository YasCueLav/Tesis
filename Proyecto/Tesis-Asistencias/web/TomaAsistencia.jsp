<%-- 
    Document   : TomaAsistencia
    Created on : 25/04/2018, 16:40:15
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TomaAsistencia</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <div>
            <h2>Asistencia día <input type="date" name="fechaHoy"> </h2>
            <form>
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
                            <%--<c:forEach items="${}" var"">
                                <tr>
                                  <th scope="row">108809</th>
                                  <td>Cueva Lavezzo, Yasmin </td>
                                  <td>1w2</td>
                                  <td><input type="checkbox" name="Asistencia" value="false"></td>
                                </tr>
                            </c:forEach>--%>
                          </tbody>
                    </div>
                </table>
                <input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
