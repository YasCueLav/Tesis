<%-- 
    Document   : AltaCalificacion
    Created on : 02/05/2018, 19:09:14
    Author     : Yasmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="Links.jsp"></jsp:include>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargar Notas Examenes</title>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <h1>Cargar Notas Examenes</h1>
        <div>
            <div class="btn-group">
                <button class="btn btn-secondary btn-lg dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Elige un examen ...
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </div>
            
            <form>
			<select name="Examen">
			  <option value="1">1</option>
			  <option value="2">2</option>
			  <option value="3">3</option>
			  <option value="4">4</option>
			</select>
			<select name="curso">
			  <option value="1v1">1v1</option>
			  <option value="1v2">1v2</option>
			</select>
			</br>
			<table class="table table-striped">
		  <thead>
			<tr>
			  <th scope="col">legajo</th>
			  <th scope="col">Apellido, Nombre</th>
			  <th scope="col">Divicion</th>
			  <th scope="col">Nota</th>
			</tr>
		  </thead>
			<div>
			  <tbody>
				<tr>
				  <th scope="row">108809</th>
				  <td>Cueva Lavezzo, Yasmin </td>
				  <td>1v2</td>
				  <td>(<input type="number" name="nota">)</td>
				</tr>
			  </tbody>
			</div>
		</table>
		<input type="submit" value="submit">
		</form>
        </div>
    </body>
</html>
