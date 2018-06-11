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
        <title>Nueva Condicion</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1>Carga Condicion Academica</h1>
        
        <div>
            <form action="CargaCondicionesServlet" method="POST">
                <div class="form-group">
                  <label for="exampleFormControlInput1">Nombre Condicion</label>
                  <input class="form-control" type="text" name="Condicion" placeholder="">
                </div>
                <input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>