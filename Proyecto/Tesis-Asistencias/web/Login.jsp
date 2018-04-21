<%-- 
    Document   : Login
    Created on : 19/04/2018, 17:53:37
    Author     : Yasmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio Sesión</title>
        <jsp:include page="Links.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
        <div id="iniciosesion">
            <h1> Inicio Sesión</h1>
            
            <form action="Login" method="POST">
            <div class="form-group">
              <label for="exampleInputEmail1">Usuario</label>
              <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Usuario" name="mail">
            </div>
            <div class="form-group">
              <label for="exampleInputPassword1">Contraseña</label>
              <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Contraseña" name="pass">
            </div>
                <input type="submit" value="Iniciar" class="btn btn-primary"/>
        </form>
        </div>
    </body>
</html>
