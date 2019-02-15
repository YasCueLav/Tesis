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
    <body id="fondo-Color">
        <jsp:include page="Menu.jsp"></jsp:include>
        
        <h1 id="iniciosecionTitle">Inicio Sesión</h1>
        <div id="iniciosesion" class="border border-secondary">
            <div id="iniciosesionForm" >
                <form action="Login" method="POST">
                <div class="form-group">
                  <label for="exampleInputEmail1" id="titulo-menor">Usuario</label>
                  <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Usuario" name="mail">
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1" id="titulo-menor">Contraseña</label>
                  <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Contraseña" name="pass">
                </div>
                    <input type="submit" value="Iniciar" class="btn btn-primary" id="iniciosecionButton"/>
                </form>
            </div>
            
        </div>
    </body>
</html>
