<%-- 
    Document   : AltaJustificativo
    Created on : 10/06/2018, 16:41:29
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="Links.jsp"></jsp:include>
    <title>Justificativo</title>
</head>
<body id="fondo-Color">
    <jsp:include page="Menu.jsp"></jsp:include>
    <div id="bordesGenerales">
        
        <h1>Registrar Justificativo</h1>
        
        <h3>${alumno.getLegajo()} / ${alumno.getApellido()}, ${alumno.getNombre()}</h3>
        </br>
        
        <form action="AltaJustificativoServlet" method="POST">
            <div class="form-group">
                <label for="exampleFormControlTextarea1"><h5>Justificativo de Ausencia</h5></label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="5" name="Justificativo" ></textarea>
            </div>
            <input type="submit" value="Cargar" class="btn btn-primary" id="BotronCarga">
        </form>
    </div>
</body>
</html>
