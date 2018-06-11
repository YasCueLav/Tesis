<%-- 
    Document   : CargaParcial
    Created on : 31/05/2018, 21:44:07
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Nuevo Examene</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        
        <h1>Carga Examen</h1>
        
        <div>
            <form action="CargaParcialServlet" method="POST">
                <div class="form-group">
                  <label for="exampleFormControlSelect1">Tipo Examen</label>
                  <select class="form-control" id="exampleFormControlSelect1" name="TipoExamen">
                    <c:forEach items="${tipoexamen}" var="e">
                         <option name="IdTipoEx" value="${e.getIdTipoExamne()}">${e.getTipoExamen()}</option>
                    </c:forEach>
                  </select>
                </div>
                <div class="form-group">
                  <label for="exampleFormControlInput1">Nombre Examen</label>
                  <input class="form-control" type="text" name="Examen" placeholder="">
                </div>
                <div class="form-group">
                  <label for="exampleFormControlInput1">Fecha Examen</label>
                  <input type="date" name="Fecha"> 
                </div>
                <input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>