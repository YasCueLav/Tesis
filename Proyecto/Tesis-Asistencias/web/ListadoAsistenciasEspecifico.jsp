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
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1>Listado de Inasistencias</h1>
        <div>
            <%--<form action="ListadoAsistenciasEspecificoServlet" method="POST">
                <div>
                    <input type="number" name="Legajo" value="0">
                    <select name="Curso">
                        <option value="0">Seleccione un curso ...</option>
                        <c:forEach items="${curso}" var="c">
                            <option name="IdCurso" value="${c.getIdCursos()}">${c.getIdCursos()}-${c.getNombreCurso()}/${c.getSeccionCurso()}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Filtrar" class="btn btn-primary" name="Boton">
                </div>
                </br>
            </form>--%>
            <table class="table table-striped" name="tabla">
                <thead>
					<tr>
                        <th scope="col" colspan="2">Nombre</th>
                        <th scope="col" colspan="2">Curso</th>
                        <th scope="col" colspan="2">Cantidad de Ausencias</th>
                        <th scope="col" rowspan="2"></th>
                    </tr>
                    <tr>
                        <th scope="col">legajo</th>
                        <th scope="col">Apellido, Nombre</th>
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
                                <td>
                                    <a id="Link" href="/Tesis-Asistencias/AusenciasListadoAlumnoServlet?getIdAlumno=${a.getIdAlumno()}">Ver</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </div>
            </table>
        </div>
    </body>
</html>
