<%-- 
    Document   : ModificarTFI
    Created on : 17/06/2018, 00:22:17
    Author     : Yasmin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Links.jsp"></jsp:include>
        <title>Modificar</title>
    </head>
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="bordesGenerales">
        <h1>Modificar de Trabajos Final Integrador</h1>
        
            <c:forEach items="${tp}" var="p">
                <h3>${p.getLegajo()} -- ${p.getfEntregado()} </h3>
            </c:forEach>
                
            </br>
                
            <form action="ModificarTFIServlet" method="POST">
                <table class="table table-striped">
		  <thead>
			<tr>
			  <th scope="col">Legajo</th>
			  <th scope="col">Apellido, Nombre</th>
			  <th scope="col">División</th>
			  <th scope="col">Entregado?</th>
			  <th scope="col">Nota</th>
			</tr>
		  </thead>
                    <tbody>
                        <c:forEach items="${tp}" var="p">
                                <th><input type="hidden" value="${p.getIdAlumno()}" name="IdAlumno"> ${p.getLegajo()}</th>
                                <td>${p.getApellido()}, ${p.getNombre()}</td>
                                <td>${p.getDivicionCurso()}</td>
                                <td>
                                    <c:if test="${p.isPresentado()}">
                                        Si <input type="radio" name="${p.getIdAlumno()}" value="Si" checked="true">- 
                                        No <input type="radio" name="${p.getIdAlumno()}" value="No">
                                    </c:if>
                                    <c:if test="${!p.isPresentado()}">
                                        Si <input type="radio" name="${p.getIdAlumno()}" value="Si">- 
                                        No <input type="radio" name="${p.getIdAlumno()}" value="No" checked="true">
                                    </c:if>
                                </td>
                                <td>
                                    <input type="number" name="Nota" value="${p.getNota()}" placeholder="${p.getNota()}">
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
		</table>
                <div class="form-group">
                    <label for="exampleFormControlInput1">Fecha Entregado  .</label>
                    Si <input type="radio" name="FechaS" value="S"> - 
                    No <input type="radio" name="FechaS" value="N" checked="true">
                    
                    <%--DIA--%>
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
                    
                </div>
		<input type="submit" value="Cargar" class="btn btn-primary" id="BotronCarga">
                <div id="mp"></div>
            </form>
        </div>
    </body>
</html>
