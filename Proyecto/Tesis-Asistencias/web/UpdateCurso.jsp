<%-- 
    Document   : UpdateCurso
    Created on : 04/06/2018, 14:26:03
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Modificar Curso</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1>Modificar Curso</h1>
        
        <div>
            <h5>${curso.getNombreCurso()} - ${curso.getSeccionCurso()}</h5>
            <form action="CargaCondicionesServlet" method="POST">
                <div class="form-group">
                  <label for="exampleFormControlInput1">Nombre Curso</label>
                  <input class="form-control" type="text" name="Curso" placeholder="${curso.getNombreCurso()}">
                </div>
                <div class="form-group">
                  <label for="exampleFormControlInput1">Seccion</label>
                  <input class="form-control" type="text" name="Seccion" placeholder="${curso.getSeccionCurso()}">
                </div>
                <input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>
