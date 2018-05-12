<%-- 
    Document   : adminMngmnt
    Created on : 03-May-2018, 14:57:01
    Author     : edva5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
    <meta charset="utf-8">
    <title>Administradores</title>
    <link rel="stylesheet" href="css/master.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
    <script src="js/script.js"></script>
        </head>
      <body>
          
    <div class="formularioDiv">
      <form name="formulario" id="formulario" action="javascript:add()" method="post">
        <table cellpadding="3" cellspacing="4">
          <tr>
            <td class="titulo" colspan="2">Agregar Adminisrador</td>
          </tr>
          <tr>
            <td class="etiqueta">Nombre de Usuario:</td>
            <td><input type="text" name="username" id="username"></td>
            <td class="error" id="username_error"></td>
          </tr>
          <tr>
            <td class="etiqueta">Contrasenha</td>
            <td><input type="password" name="password" id="password"></td>
            <td class="error" id="password_error"></td>
          </tr>
          <tr>
            <td class="titulo" colspan="2">
              <input type="submit" name="" value="Registrar">
            </td>
          </tr>
        </table>
      </form>
    </div>
    <hr>
    <div class="listArea">
      <table>
        <thead>
          <tr>
            <th>Nombre de Usuario</th>
            <th>Contrasena</th>
          </tr>
        </thead>
        <tbody id="list">
        </tbody>
      </table>
    </div>
    
  </body>
</html>
