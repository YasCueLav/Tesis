<%-- 
    Document   : ListadoPromedioNota
    Created on : 19/06/2018, 10:54:28
    Author     : Yasmin
obtenerAlumnoDatosVs
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promedio Notas</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <nav aria-label="Page navigation example">
                <ul class="pagination">
                  <li class="page-item"><a class="page-link" href="/Tesis-Asistencias/${t.getTxt()}">Volver</a></li>
                </ul>
        </nav>
        <h1>Promedio Notas</h1>
        <div>    
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col" colspan="2">Alumno</th>
                        <th scope="col" colspan="2">Materia</th>
                        <th scope="col" colspan="2">Nota</th>
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
