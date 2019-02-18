<%-- 
    Document   : UpdateCondicion
    Created on : 04/06/2018, 13:54:09
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Nueva Condicion</title>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
            <h1>Carga Condicion Academica</h1>
            <h5>${condi.getCondicion()}</h5>
        </br>
        
            <form action="UpdateCondicionServlet" method="POST">
                <div class="form-group">
                  <label for="exampleFormControlInput1">Nombre Condicion</label>
                  <input class="form-control" type="text" name="Condicion" placeholder="${condi.getCondicion()}" value="${condi.getCondicion()}">
                </div>
                <input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>