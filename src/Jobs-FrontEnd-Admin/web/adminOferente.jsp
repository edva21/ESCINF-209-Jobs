<%-- 
    Document   : adminOferente
    Created on : 18-May-2018, 21:15:53
    Author     : edva5
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-git.js"></script>
 <meta charset="utf-8">
 <meta name="viewport" content-width="device-width">
 <title>Remove a specific table row using jQuery.</title>
 </head>
 <body>
     <jsp:useBean id="oferentes" scope="request" type="List<BussinessLogic.Oferente>" class="java.util.ArrayList" />
   <script src="js/adminOferente.js">
   </script>
 <table id="mytable">
 <tr>
  <th>Email</th>
  <th>Nombre</th>
  <th>Apellidos</th>
  </tr>
  <tr id="r1">
  <td>Rahul</td>
  <td>Sethi</td>
  <td> <button type="button" id="r1" onclick="removeRow(this)">Click Me!</button> </td>
  </tr>
  <tr id="r2">
   <td>Sara</td>
   <td>Rayy</td>
   <td> <button type="button" id="r2" onclick="removeRow(this)">Click Me!</button> </td>
   </tr>
   <%for(BussinessLogic.Oferente o : oferentes){ %>                            
                    <tr id="<%=o.getOferenteEmail()%>">
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
                            <button type="button" id="<%=o.getOferenteEmail()%>" onclick="removeRow(this)">
                                Aceptar
                            </button>
                        </td>
                        <td> 
                            <button type="button" id="<%=o.getOferenteEmail()%>" onclick="removeRow(this)">
                                Rechazar
                            </button>
                        </td>
                    </tr>                
            <%}%>
   </table>
   <p> <input id="button1" type="button" value="Click to remove 2nd Row." /></p>
</body>
</html>
