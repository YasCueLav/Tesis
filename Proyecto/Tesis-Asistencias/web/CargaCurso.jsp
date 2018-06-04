<%-- 
    Document   : CargaCurso
    Created on : 31/05/2018, 22:41:27
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Nuevo Curso</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1>Carga Curso</h1>
        
        <div>
            <form action="CargaCondicionesServlet" method="POST">
                <div class="form-group">
                  <label for="exampleFormControlInput1">Nombre Curso</label>
                  <input class="form-control" type="text" name="Curso" placeholder="">
                </div>
                <div class="form-group">
                  <label for="exampleFormControlInput1">Seccion</label>
                  <input class="form-control" type="text" name="Seccion" placeholder="">
                </div>
                <input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>