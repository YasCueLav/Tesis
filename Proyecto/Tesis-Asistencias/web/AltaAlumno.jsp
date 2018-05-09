<%-- 
    Document   : AltaAlumno
    Created on : 08/05/2018, 16:18:46
    Author     : Yasmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Alumno</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <div>
            <h1>Registrar Nuevo Alumno</h1>

            <form action="AltaAlquilerServlet" method="POST">
				<div class="form-group">
                    <label for="exampleFormControlInput1">Legajo</label>
                    <input type="number" class="form-control" id="" name="Legajo" min="0">
                </div>
				<div class="form-group">
                    <label for="exampleFormControlInput1">Nombre</label>
                    <input type="text" class="form-control" id="" name="Nombre">
                </div>
				<div class="form-group">
                    <label for="exampleFormControlInput1">Apellido</label>
                    <input type="text" class="form-control" id="" name="Apellido">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Curso</label>
                    <select name="Curso" class="form-control">
                        <option>Selecione el Curso...</option>
                        <c:forEach items="${curso}" var="c">
                            <option value="${c.getIdCurso()}">${c.getNombre()}, ${cl.getSeccion()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Condicion</label>
                    <select name="Condicion" class="form-control">
                        <option>Selecione la condicion...</option>
                        <c:forEach items="${condicion}" var="co">
                            <option value="${co.getIdondicion()}">${co.getCondicion()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Grupo</label>
                    <input type="number" class="form-control" name="Grupo" value="0"  min="0">
                </div>
                <input type="submit" value="Cargar" class="btn btn-primary" />
            </form>
        </div>
    </body>
</html>