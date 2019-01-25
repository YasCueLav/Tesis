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
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div  id="bordesGenerales">
            <h1>Listados</h1>
        
            <h5>Listados de Alumnos con Codiciones</h5>
            </br>
            <form action="ListadosAlumnosCondicinesServlet" method="POST">
                
                <label id="tamLetraListCon">Actualizar Regularidad</label> <input type="submit" value="Actualizar" class="btn btn-primary" id="tamBotonActualizarCon">
                </br></br>
                
                <table class="table table-striped" name="tabla">
                    <thead>
                        <tr>
                            <th scope="col" width="50">legajo</th>
                            <th scope="col" width="300">Apellido, Nombre</th>
                            <th scope="col"  width="100">Curso - Divicion</th>
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