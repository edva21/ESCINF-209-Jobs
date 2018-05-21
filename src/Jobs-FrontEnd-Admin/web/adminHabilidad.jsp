<%-- 
    Document   : adminHabilidad
    Created on : 21-May-2018, 05:24:38
    Author     : edva5
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/adminHabilidad.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="js/adminHabilidad.js"></script>
    </head>
    <body>
        <jsp:useBean id="habilidades" scope="request" type="List<BussinessLogic.Habilidad>" class="java.util.ArrayList" />   
        <ul id="path"></ul>
        <ul id="habilidadList">
            <li><input id="newhabilidad" onkeydown="javascript:addHabilidad(event)" type="text" name="habilidad" value="" ></li>            
            <%int x = 0;for(BussinessLogic.Habilidad h : habilidades){ %> 
            <li class="item" onclick="javascript:navHabilidad(this)"><%=h.getHabilidadNombre()%></li>
            <%x++;};%>
        </ul>  
    </body>
</html>
