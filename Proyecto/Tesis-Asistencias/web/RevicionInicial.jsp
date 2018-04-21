<%-- 
    Document   : RevicionInicial
    Created on : 19/04/2018, 17:58:08
    Author     : Yasmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% HttpSession mySession = request.getSession();
        mySession.setAttribute("inicio", false);
        getServletContext().getRequestDispatcher("/Index").forward(request, response);
        %>
    </body>
</html>
