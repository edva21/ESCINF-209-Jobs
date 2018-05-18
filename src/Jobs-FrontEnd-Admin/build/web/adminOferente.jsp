<%-- 
    Document   : adminOferente
    Created on : 18-May-2018, 05:20:00
    Author     : edva5
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estado de Oferentes</title>
        <link rel="stylesheet" href="css/master.css">    
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">         
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>        
        </head>
    </head>
    <body>
        <script src="js/script.js"></script>
        <jsp:useBean id="oferentes" scope="request" type="List<BussinessLogic.Oferente>" class="java.util.ArrayList" />
        <div class="col-sm-4">
        <table class="table table-dark table-hover">
        <thead>
          <tr>
            <th>Email</th>
            <th>Nombre</th>
            <th>Apellido</th>
          </tr>
        </thead>
        <tbody id="list" name="list">
            <%int i = 0; for(BussinessLogic.Oferente o : oferentes){ %>            
                <div class="item" >
                    <tr id=<%=o.getOferenteEmail()%>>
                         <td>
                            <%=o.getOferenteEmail()%>
                        </td>
                        <td>
                            <%=o.getOferenteNombre()%>
                        </td>
                        <td>
                            <%=o.getOferenteApellido()%>
                        </td>
                        <td>                            
                                <button id="<%=o.getOferenteEmail()%>" type="button" onclick="disaproveOferente(this)" class="btn btn-outline-danger">Denegar</button>                                                     
                        </td>
                        <td>                           
                                <button id="<%=o.getOferenteEmail()%>" type="button" onclick="aproveOferente(this)" class="btn btn-outline-success">Aprovar</button>                            
                        </td>
                    </tr>
                </div>
            <%}%>
        </tbody>
      </table>
    </div>
    </body>
</html>
