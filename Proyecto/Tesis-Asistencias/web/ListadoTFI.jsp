<%-- 
    Document   : ListadoTFI
    Created on : 16/06/2018, 18:10:03
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
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        
        <h1>Listado de entregas de trabajos final Integrador</h1>
        
        <div>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col" colspan="2">Alumno</th>
                        <th scope="col" colspan="2">Materia</th>
                        <th scope="col" rowspan="2">Trabajo Final Intgrador</th>
                        <th scope="col" colspan="2">Fecha</th>
                        <th scope="col" rowspan="2">Nota</th>
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
                                <td> ${a.getLegajo()}</td>
                                <th>${a.getApellido()} ${a.getNombre()}</th>
                                <td>${a.getNombreCurso()}</td>
                                <td>${a.getDivicionCurso()}</td>
                                <td>${a.getTp()}</td>
                                <td>${a.getfEntrega()}</td>
                                <td>${a.getfEntregado()}</td>
                                <td>${a.getNota()}</td>
                                <td>
                                    <a id="Link" href="/Tesis-Asistencias/ModificarTFIServlet?idAlumno=${a.getIdAlumno()}">Modificar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
</html>
