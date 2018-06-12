<%-- 
    Document   : ListadosAlumnosCondicines
    Created on : 12/06/2018, 04:25:58
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Lista</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h2>Listados</h2>
        
        <h5>Listados de Alumnos con Codiciones</h5>
        <div>
            <form action="ListadosAlumnosCondicinesServlet" method="POST">
                <label>Actualizar Regularidad</label><input type="submit" value="Actualizar" class="btn btn-primary">
                <table class="table table-striped" name="tabla">
                    <thead>
                        <tr>
                            <th scope="col">legajo</th>
                            <th scope="col">Apellido, Nombre</th>
                            <th scope="col">Curso - Divicion</th>
                            <th scope="col">Condicion</th>
                        </tr>
                    </thead>
                    <div>
                        <tbody>
                            <c:forEach items="${alumno}" var="a">
                                <tr>
                                    <th scope="row">
                                        <input type="hidden" value="${a.getIdAlumno()}" name="IdAlumno">${a.getLegajo()}
                                    </th>
                                    <td> ${a.getApellido()}, ${a.getNombre()}</td>
                                    <td>${a.getNombreCurso()} - ${a.getDivicionCurso()}</td>
                                    <td>${a.getCondicion()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </div>
                </table>
            </form>
        </div>
    </body>
 </html>