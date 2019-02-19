<%-- 
    Document   : UpdateParcial
    Created on : 31/05/2018, 22:29:55
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Modificar Examen</title>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
            
            <h1>Modificar Examen</h1>
            
            <h4>${ex.getTipoExamne()} ${ex.getExamenNombre()} -- ${ex.getFecha()}</h4>
            </br>
        
            <form action="UpdateParcialServlet" method="POST">
                <div class="form-group">
                  <label for="exampleFormControlSelect1">Tipo Examen</label>
                  <select class="form-control" id="exampleFormControlSelect1" name="TipoExamen">
                    <c:forEach items="${tipoexamen}" var="e">
                        <option value="${e.getIdTipoExamne()}">${e.getTipoExamen()}</option>
                    </c:forEach>
                  </select>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Nombre Examen</label>
                  <input class="form-control" type="text" name="Examen" placeholder="${ex.getExamenNombre()}" value="${ex.getExamenNombre()}">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Fecha Examen</label>
                    Si<input type="radio" name="FechaS" value="S"> - 
                    No<input type="radio" name="FechaS" value="N" checked="true">
                    <input type="date" name="Fecha" placeholder="${ex.getFecha()}" value="${ex.getFecha()}"> 
                </div>
                <input type="submit" value="Cargar" class="btn btn-primary" id="BotronCarga">
                <div id="mp"></div>
            </form>
        </div>
    </body>
</html>