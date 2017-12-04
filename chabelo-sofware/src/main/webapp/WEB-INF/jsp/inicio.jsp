<%-- 
    Document   : incio.jsp
    Created on : 11/10/2017, 06:34:44 PM
    Author     : ahernandez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Login Form</title>
  <link rel="stylesheet" href="css/inicio.css">
  <!--<link rel="stylesheet" href="css/bootstrap.min.css">-->
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body onload="myFunction()">
    <div id="content">
        <h id="titulo">¡Bienvenido a Friend Zone!</h>
  <div class="login">
      <h><img style="width:100%; margin: 0 auto;" src= "img/logo2.png"></h>
    <h1>Iniciar Sesión</h1>
    <form action="/chabelo-sofware/login" method="POST" class="login-form">
      <p><input type="text" name="username" value="" placeholder="Nombre de usuario"></p>
      <p><input type="password" name="password" value="" placeholder="Contraseña"></p>
     <input name = "fallo" id="fallo" onlyread value ="<%= request.getParameter("error") %>" style="display:none;"/>
      <p id="message" syle="color:red;"></p>
      
      <p class="submit"><input type="submit" name="commit" value="Inicia Sesión"></p>

<script>
function myFunction() {
    var message, x;
    message = document.getElementById("message");
    message.innerHTML = "";
    x = document.getElementById("fallo").value;
    try { 
        if(x == "1") throw "Nombre de Usuario o Contraseña no son correctos";
    }
    catch(err) {
        message.innerHTML = ""+err;
    }
}
</script>

    </form>
  </div>
  <div class="register">
    <h1>¡Registrate Ahora!</h1>
    <form action="/chabelo-sofware/crearUsuario" method="POST">
      <p><input type="text" name="nombre" value="" placeholder="Nombre"></p>
      <p><input type="text" name="apellidoP" value="" placeholder="Apellido Paterno"></p>
      <p><input type="text" name="apellidoM" value="" placeholder="Apellido Materno"></p>
      <p><input type="text" name="username" value="" placeholder="Nombre de usuario"></p>
      <p><input type="text" name="email" value="" placeholder="Correo" type="email"></p>
      <p><input type="password" name="password" value="" placeholder="Contraseña"></p>
      <p><input type="password" name="passworConf" value="" placeholder="Confirma Contraseña"></p>
      
      
      <p class="submit"><input type="submit" name="commit" value="Registrarse"></p>
    </form>
  </div>
    </div>
</body>
</html>
