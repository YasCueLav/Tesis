<%-- 
    Document   : ModificarAlumnos
    Created on : 05/06/2018, 17:32:34
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Alumno</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <div>
            <h1>Modificar Alumno</h1>

            <form action="ModificarAlumnosServlet" method="POST">
                
		<div class="form-group">
                    <label for="exampleFormControlInput1">Legajo</label>
                    <input type="number" class="form-control" name="Legajo" min="0" placeholder="${alumno.getLegajo()}" value="${alumno.getLegajo()}">
                </div>
                
		<div class="form-group">
                    <label for="exampleFormControlInput1">Nombre</label>
                    <input type="text" class="form-control" name="Nombre" placeholder="${alumno.getNombre()}" value="${alumno.getNombre()}">
                </div>
                
		<div class="form-group">
                    <label for="exampleFormControlInput1">Apellido</label>
                    <input type="text" class="form-control" name="Apellido" placeholder="${alumno.getApellido()}" value="${alumno.getApellido()}">
                </div>
                
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Curso</label>
                    <select class="form-control" name="curso">
                        <option value="0">Selecione el Curso...</option>
                        <c:forEach items="${curso}" var="c">
                            <option value="${c.getIdCursos()}"> ${c.getIdCursos()} // ${c.getNombreCurso()}, ${c.getSeccionCurso()}</option>
                        </c:forEach>
                    </select>
                </div>
                
                </br>
                
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Condicion</label>
                    <select name="Condicion" class="form-control">
                        <option  value="0">Selecione la condicion...</option>
                        <c:forEach items="${condicion}" var="co">
                            <option value="${co.getIdCondicion()}" >${co.getIdCondicion()} // ${co.getCondicion()}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="exampleFormControlInput1">Grupo</label>
                    <input type="number" class="form-control" name="Grupo" value="0"  min="0" placeholder="">
                </div>
                
                <input type="submit" value="Cargar" class="btn btn-primary">
            </form>
        </div>
    </body>
</html>