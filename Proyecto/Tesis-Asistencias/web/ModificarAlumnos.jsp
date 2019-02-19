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
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
            <h1>Modificar Alumno</h1>
            </br>
            
            <div class="form-group">
                    <label for="exampleFormControlInput1">Legajo</label>
                    <input type="number" class="form-control" id="" name="Legajo" min="0" placeholder="${alumno.getLegajo()}" value="${alumno.getLegajo()}">
                </div>
                
                <div class="form-group" id="divDistanciaApeForm">
                    <label for="exampleFormControlInput1">Apellido</label>
                    <input type="text" class="form-control" id="tamLbl" name="Apellido" placeholder="${alumno.getApellido()}" value="${alumno.getApellido()}">
                </div>
                
                <div class="form-group" id="divDistanciaNomForm">
                    <label for="exampleFormControlInput1">Nombre</label>
                    <input type="text" class="form-control" id="tamLbl" name="Nombre"  placeholder="${alumno.getNombre()}" value="${alumno.getNombre()}">
                </div>
                
                <div class="form-group" id="ejem">
                    <label for="exampleFormControlSelect1">Curso</label>
                    <select class="form-control" name="Curso">
                        <option>Seleccione el Curso...</option>
                        <c:forEach items="${cu}" var="c">
                            <option value="${c.getIdCursos()}"> ${c.getNombreCurso()}, ${c.getSeccionCurso()}</option>
                        </c:forEach>
                    </select>
                </div>
                
                </br>
                
                <div class="form-group">
                    <label for="exampleFormControlSelect1">Condición </label>
                    <select name="Condicion" class="form-control">
                        <option>Seleccione la condición ...</option>
                        <c:forEach items="${con}" var="co">
                            <option value="${co.getIdCondicion()}" >${co.getCondicion()}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="exampleFormControlInput1">Grupo</label>
                    <input type="number" class="form-control" name="Grupo" placeholder="0" value="0"  min="0">
                </div>
            
                
                <input type="submit" value="Cargar" class="btn btn-primary" id="BotronCarga">
                <div id="mp"></div>
            </form>
        </div>
    </body>
</html>
