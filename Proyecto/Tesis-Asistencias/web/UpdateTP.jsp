<%-- 
    Document   : UpdateTP
    Created on : 31/05/2018, 22:29:40
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Modificar TP</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1>Modificar TP</h1>
        
        <div>
            <h5>${trabPrac.getNombreTp()}</h5>
            <form action="UpdateTPServlet" method="POST">
                <div class="form-group">
                  <label for="exampleFormControlInput1">Nombre Trabajo Pracico</label>
                  <input class="form-control" type="text" name="TrabajoP" placeholder="${trabPrac.getNombreTp()}" value="${trabPrac.getNombreTp()}">
                </div>
                <input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>