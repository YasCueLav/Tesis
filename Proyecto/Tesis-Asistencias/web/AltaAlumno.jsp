<%-- 
    Document   : AltaAlumno
    Created on : 08/05/2018, 16:18:46
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Alumno</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
            
            <h1>Registrar Nuevo Alumno</h1>
            
            </br>
            <form action="AltaAlumnoServlet" method="POST">
                
                <select name="dia">
                        <option value="">Día</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                      </select>/
                <%--MES--%>
                <select name="mes">
                  <option value="">Mes</option>
                  <option value="1">1</option>
                  <option value="2">2</option>
                  <option value="3">3</option>
                  <option value="4">4</option>
                  <option value="5">5</option>
                  <option value="6">6</option>
                  <option value="7">7</option>
                  <option value="8">8</option>
                  <option value="9">9</option>
                  <option value="10">10</option>
                  <option value="11">11</option>
                  <option value="12">12</option>
                </select>/
                <%--AÑO--%>
                <select name="anio">
                        <option value="">Año</option>
                        <option value="2000">2000</option>
                        <option value="2001">2001</option>
                        <option value="2002">2002</option>
                        <option value="2003">2003</option>
                        <option value="2004">2004</option>
                        <option value="2005">2005</option>
                        <option value="2006">2006</option>
                        <option value="2007">2007</option>
                        <option value="2008">2008</option>
                        <option value="2009">2009</option>
                        <option value="2010">2010</option>
                        <option value="2011">2011</option>
                        <option value="2012">2012</option>
                        <option value="2013">2013</option>
                        <option value="2014">2014</option>
                        <option value="2015">2015</option>
                        <option value="2016">2016</option>
                        <option value="2017">2017</option>
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                        <option value="2020">2020</option>
                        <option value="2021">2021</option>
                        <option value="2022">2022</option>
                      </select>
                    
                </br></br>
                
		<div class="form-group">
                    <label for="exampleFormControlInput1">Legajo</label>
                    <input type="number" class="form-control" id="" name="Legajo" min="0" placeholder="108809">
                </div>
                
                <div class="form-group" id="divDistanciaApeForm">
                    <label for="exampleFormControlInput1">Apellido</label>
                    <input type="text" class="form-control" id="tamLbl" name="Apellido" placeholder="Apellido">
                </div>
                
                <div class="form-group" id="divDistanciaNomForm">
                    <label for="exampleFormControlInput1">Nombre</label>
                    <input type="text" class="form-control" id="tamLbl" name="Nombre"  placeholder="Nombre">
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
                    <label for="exampleFormControlSelect1">Condicion</label>
                    <select name="Condicion" class="form-control">
                        <option>Seleccione la condicion...</option>
                        <c:forEach items="${con}" var="co">
                            <option value="${co.getIdCondicion()}" >${co.getCondicion()}</option>
                        </c:forEach>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="exampleFormControlInput1">Grupo</label>
                    <input type="number" class="form-control" name="Grupo" value="0"  min="0">
                </div>
                
                <input type="submit" value="Cargar" class="btn btn-primary" id="BotronCarga">
                <div id="mp"></div>
        </form>
        </div>
    </body>
</html>