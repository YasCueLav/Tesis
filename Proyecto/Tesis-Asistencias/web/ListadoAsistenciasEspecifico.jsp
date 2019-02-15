<%-- 
    Document   : ListadoAsistenciasEspecifico
    Created on : 16/06/2018, 15:22:04
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Listado</title>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
       <div id="bordesGenerales"> 
           <h1>Listado de Inasistencias</h1>
        
            <form action="ListadoAsistenciasEspecificoServlet" method="POST">
                <div>
                    <input type="number" name="Legajo" value="0" id="tamLegajoLBL">
                    <input type="submit" value="Filtrar" class="btn btn-primary" name="Boton">
                </div>
                </br>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr id="centrarConTabla">
                        <th scope="col" colspan="2" width="600" id="bordesCeldas">Alumno</th>
                        <th scope="col" colspan="2" width="300" id="bordesCeldas">Curso</th>
                        <th scope="col" colspan="2" id="bordesCeldas">Cantidad de Ausencias</th>
                        <th scope="col" ></th>
                    </tr>
                    <tr>
                        <th scope="col">legajo</th>
                        <th scope="col" width="300">Apellido, Nombre</th>
                        <th scope="col">Curso</th>
                        <th scope="col">Divicion</th>
                        <th scope="col">General</th>
                        <th scope="col">Obligatorias</th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${alumno}" var="a">
                            <tr>
                                <th scope="row" >${a.getLegajo()}</th>
                                <td> ${a.getApellido()}, ${a.getNombre()}</td>
                                <td>${a.getNombreCurso()}</td>
                                <td>${a.getDivicionCurso()}</td>
                                <td>${a.getCantAusenciasG()}</td>
                                <td>${a.getCantAusenciasO()}</td>
                                <td id="letraNegrita">
                                    <a id="Link" href="/Tesis-Asistencias/ListadoAsistenciasServlet?legajo=${a.getLegajo()}">Ver</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
</html>
