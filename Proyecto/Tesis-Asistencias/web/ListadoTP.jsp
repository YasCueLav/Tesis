<%-- 
    Document   : ListadoTP
    Created on : 16/06/2018, 18:09:48
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
        
        <h1>Listado de entregas de trabajos Practicos</h1>
        
        <div>
            <table class="table table-striped" name="tabla">
                <thead>
                    <tr>
                        <th scope="col" colspan="2">Alumno</th>
                        <th scope="col" colspan="2">Curso</th>
                        <th scope="col" rowspan="2">Trabajo Practico</th>
                        <th scope="col" rowspan="2">Fecha de Entrega</th>
                        <th scope="col" rowspan="2">Fecha Entregado</th>
                        <th scope="col" rowspan="2">Estado</th>
                        <th scope="col" rowspan="2"></th>
                    </tr>
                    <tr>
                        <th scope="col">legajo</th>
                        <th scope="col">Apellido, Nombre</th>
                        <th scope="col">Curso</th>
                        <th scope="col">Divicion</th>
                    </tr>
                </thead>
                <div>
                    <tbody>
                        <c:forEach items="${justi}" var="j">
                            <tr>
                                <td> ${j.getLegajo()}</td>
                                <th>${j.getApellido()} ${j.getNombre()}</th>
                                <td> curso</td>
                                <td> divicion</td>
                                <td> f entrega</td>
                                <td> f entregado</td>
                                <td>estado</td>
                                <td> divicion</td>
                                <td>
                                    <a id="Link" href="/Tesis-Asistencias/ListadoAsistenciasServlet?idAlumno=${a.getLegajo()}">Modificar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
</html>
