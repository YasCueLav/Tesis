<%-- 
    Document   : CargaTP
    Created on : 31/05/2018, 21:43:32
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Nuevo Trabajo Práctico </title>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
            <h1>Carga Trabajo Práctico</h1>
            </br>
            
            <form action="CargaTPServlet" method="POST">
                <div class="form-group">
                  <label for="exampleFormControlInput1">Nombre Trabajo Práctico</label>
                  <input class="form-control" type="text" name="TrabajoP" placeholder="Trabajo Práctico N°1">
                </div>
                
                <input type="submit" value="Cargar" class="btn btn-primary" id="BotronCarga">
            </form>
        </div>
    </body>
</html>