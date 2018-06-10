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
    <title>Justificativo</title>
</head>
<body>
    <div>
        <h1>Registrar Justificativo</h1>
        <h3>${alumno.getLegajo()} / ${alumno.getApellido()}, ${alumno.getNombre()}</h3>
        <form action="AltaJustificativoServlet" method="POST">
            <div class="form-group">
                <label for="exampleFormControlTextarea1">Justificativo de Ausencia</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="5" name="Justificativo" ></textarea>
            </div>
            <input type="submit" value="Cargar" class="btn btn-primary">
        </form>
    </div>
</body>
</html>
