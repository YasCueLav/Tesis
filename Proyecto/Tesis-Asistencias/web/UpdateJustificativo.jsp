<%-- 
    Document   : UpdateJustificativo
    Created on : 10/06/2018, 18:19:09
    Author     : Yasmin
justi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Modificar Justificativo</title>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        
        <div id="bordesGenerales">
            <h1>Modificar Justificativo</h1>
            
            <h3>${justi.getLegajo()} / ${justi.getApellido()}, ${justi.getNombre()}</h3>
            </br>
        
            <form action="UpdateJustificativoServlet" method="POST">
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Justificativo de Ausencia</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="10" cols="30" name="Justificativo" placeholder="${justi.getTexto()}" value="${justi.getTexto()}"></textarea>
                </div>
                <input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>