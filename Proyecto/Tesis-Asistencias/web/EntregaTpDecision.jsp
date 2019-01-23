<%-- 
    Document   : EntregaTpDecision
    Created on : 12/06/2018, 03:21:04
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>TP</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesEspecificoGenerales">
            <button type="button" class="btn btn-primary btn-lg" id="BototnTP">
                <a id="Link" href="/Tesis-Asistencias/AltaEntregaTPServlet" style="color: white">Entrega TP</a> 
            </button>
            <div>
            <button type="button" class="btn btn-secondary btn-lg" id="BototnTFI">
                <a id="Link" href="/Tesis-Asistencias/AltaEntregaTFIServlet" style="color: white">Entrega TFI</a>
            </button>
            </div>
        </div>
    </body>
</html>
