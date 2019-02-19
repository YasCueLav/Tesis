<%-- 
    Document   : CargaCondiciones
    Created on : 31/05/2018, 22:41:53
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Nueva Condición </title>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
            <h1>Carga Condición Académica </h1>
            </br>
            
            <form action="CargaCondicionesServlet" method="POST">
                <div class="form-group">
                  <label for="exampleFormControlInput1">Nombre Condición </label>
                  <input class="form-control" type="text" name="Condicion" placeholder="Regular">
                </div>
                
                <input type="submit" value="Cargar" class="btn btn-primary" id="BotronCarga">
            </form>
        </div>
    </body>
</html>