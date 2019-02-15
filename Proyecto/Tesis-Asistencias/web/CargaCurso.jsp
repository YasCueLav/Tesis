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
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
            <h1>Carga Curso</h1>
            </br>
            
            <form action="CargaCursoServlet" method="POST">
                <div class="form-group">
                  <label for="exampleFormControlInput1">Nombre Curso</label>
                  <input class="form-control" type="text" name="Curso" placeholder="Integracion I">
                </div>
                <div class="form-group">
                  <label for="exampleFormControlInput1">Seccion</label>
                  <input class="form-control" type="text" name="Seccion" placeholder="1V1">
                </div>
                
                <input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>