<%-- 
    Document   : ListadoTPEntregados
    Created on : 19/06/2018, 10:55:17
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entrega TP</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <div>
            <h1>Trabajos Practicos Entregados</h1>
        
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col" colspan="2">Alumno</th>
                        <th scope="col" colspan="2">Materia</th>
                        <th scope="col" colspan="2">Fecha</th>
                    </tr>
                    <tr>
                        <th scope="col">legajo</th>
                        <th scope="col">Apellido, Nombre</th>
                        <th scope="col">Curso</th>
                        <th scope="col">Divicion</th>
                        <th scope="col">Examen</th>
                        <th scope="col">Promedio</th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${alumno}" var="a">
                            <tr>
                                <th>${a.getLegajo()}</th>
                                <td>${a.getApellido()} ${a.getNombre()}</tdh>
                                <td>${a.getNombreCurso()}</td>
                                <td>${a.getDivicionCurso()}</td>
                                <td>${a.getNotaExamen()}</td>
                                <td>${a.getPromedioNotas()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
            
        </div>
    </body>
</html>
<!--
<table class="table table-striped" name="tabla">
<thead>
    <tr>
        <th scope="col" colspan="2">Alumno</th>
        <th scope="col" colspan="2">Materia</th>
        <th scope="col" rowspan="2">Trabajo Practico</th>
        <th scope="col" colspan="2">Fecha</th>
        <th scope="col" rowspan="2">Estado</th>
        <th scope="col" rowspan="2"></th>
    </tr>
    <tr>
        <th scope="col">legajo</th>
        <th scope="col">Apellido, Nombre</th>
        <th scope="col">Curso</th>
        <th scope="col">Divicion</th>
        <th scope="col">de Entrega</th>
        <th scope="col">Entregado</th>
    </tr>
</thead>
<div>
    <tbody>
        <c:forEach items="${alumno}" var="a">
            <tr>
                <th> ${a.getLegajo()}</th>
                <td>${a.getApellido()} ${a.getNombre()}</td>
                <td>${a.getNombreCurso()}</td>
                <td>${a.getDivicionCurso()}</td>
                <td>${a.getTp()}</td>
                <td>${a.getfEntrega()}</td>
                <td>${a.getfEntregado()}</td>
                <td>${a.getEstado()}</td>
            </tr>
        </c:forEach>
    </tbody>
</div>
</table>
--!>