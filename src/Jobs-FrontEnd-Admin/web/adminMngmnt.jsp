<%-- 
    Document   : adminMngmnt
    Created on : 03-May-2018, 14:57:01
    Author     : edva5
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
    <meta charset="utf-8">
    <title>Administradores</title>
    <link rel="stylesheet" href="css/master.css">    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>      
        </head>
      <body>
          <script src="js/script.js"></script>
          <jsp:useBean id="administradores" scope="request" type="List<BussinessLogic.Administrador>" class="java.util.ArrayList" />
          <div class="jumbotron text-center">
         <h1>Administración de Administradores</h1>
        <p>Agregue, Elimine o Edite Administradores</p>
        </div>
    <div class="row">      
    <div class="col-sm-4">
      <form name="formulario" id="formulario" action="javascript:add()" method="post">
        <table cellpadding="3" cellspacing="4">
          <tr>
            <td class="titulo" colspan="2">Agregar Adminisrador</td>
          </tr>
          <tr>
            <td class="etiqueta">Nombre de Usuario:</td>
            <td><input class="form-control"type="text" name="username" id="username"></td>
            <td class="error" id="username_error"></td>
          </tr>
          <tr>
            <td class="etiqueta">Contrasenha</td>
            <td><input class="form-control" type="password" name="password" id="password"></td>
            <td class="error" id="password_error"></td>
          </tr>
          <tr>
            <td class="titulo" colspan="2">
              <input type="submit" class="btn btn-success" name="" value="Registrar">
            </td>
          </tr>
        </table>
      </form>
    </div>
    <hr>
    <div class="col-sm-4">
        <table class="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Nombre de Usuario</th>
            <th>Contrasena</th>
          </tr>
        </thead>
        <tbody id="list" name="list">
            <%int x = 0; for(BussinessLogic.Administrador a : administradores){ %>            
                <div class="item">
                    <tr>
                        <td>
                            <%=a.getAdministradorUserName()%>
                        </td>
                        <td>
                            <%=a.getAdministradorClave()%>
                        </td>
                        <td>                            
                                <button type="button" onclick="remove(this)" class="btn btn-outline-danger">Eliminar</button>                                                     
                        </td>
                        <td>                           
                                <button type="button" onclick="remove(this)" class="btn btn-secondary">Editar</button>                            
                        </td>
                    </tr>
                </div>
            <%}%>
        </tbody>
      </table>
    </div>
    </div>
  </body>
</html>

    