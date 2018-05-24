<%-- 
    Document   : OfferentRegistro
    Created on : 20/05/2018, 12:53:36 AM
    Author     : fabio
--%>

<%@page import="java.util.List"%>
<%@page import="BussinessLogic.Nacionalidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/master.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            $(document).on("load", function () {
                $.get("ControllerOferente", function (responseJson) {
                    var $select = $("<tr><td><select class=\"etiqueta\" id=\"nacionalidad\">").appendTo($("#tbl"));
                            $.each(responseJson, function (index, nac) {
                                $("<option>").appendTo($select).append($("<td>").text(nac.getNacionalidadNombre()));
                            });
                });
            });
        </script>
        <title>OferenteRegistro</title>
    </head>
    <body>
        <%@ include file="Header.jsp" %>
        <div id="body" style="margin: 0 auto; width:85%; ">
            <div id="formularioDiv" style="display: block;vertical-align:top;">
                <form method="POST" name="formulario" id="formulario" action="javascript:registrar();">
                    <table border=0 cellpadding=3 cellspacing=4 id="tbl">
                        <tr><td colspan="2" class="titulo">Registro Oferentes</td></tr>
                        <tr><td class="etiqueta">Correo</td><td><input type="text" name="correo" id="correo"></td></tr>
                        <tr><td class="etiqueta">Cedula</td><td><input type="text" name="correo" id="cedula"></td></tr>
                        <tr><td class="etiqueta">Nombre</td><td><input type="text" name="correo" id="nombre"></td></tr>
                        <tr><td class="etiqueta">Apellido</td><td><input type="text" name="correo" id="apellido"></td></tr>
                        <tr><td class="etiqueta">Telefono</td><td><input type="text" name="correo" id="telefono"></td></tr>
                        <tr><td class="etiqueta">Residencia</td><td><input type="text" name="correo" id="residencia"></td></tr>
                        <tr><td class="etiqueta">UserName</td><td><input type="text" name="correo" id="username"></td></tr>
                        <tr><td class="etiqueta">Clave</td><td><input type="password" name="clave" id="clave"></td></tr>
                        <tr><td class="titulo" colspan="2"><input class="boton" type="submit" value="Registrar"></td></tr>	   
                    </table>
                </form>
            </div>     
        </div>
        <script>
            function registrar() {
                oferente = {oferenteEmail: $("#correo").val(), ofrenteCedula: $("#cedula"), ofrenteTelefono: $("#telefono"), ofrenteResidencia: $("#residencia"),
                    ofrenteNombre: $("#nombre"), ofrenteApellido: $("#apellido"), ofrenteUserName: $("#username"), oferenteClave: $("#clave").val(), ofrenteNacionalidad: $("#nacionalidad")};
                $.ajax({type: "POST",
                    url: "OferenteRegistro",
                    data: JSON.stringify(oferente),
                    dataType: "json",
                    success:
                            function (obj) {
                                show(obj);
                            },
                    error: function (status) {
                        window.alert("no");
                    }
                });

            }
            function show(per) {
                window.alert("siiiiiiiiiiii");
            }
        </script>
    </body>
</html>
