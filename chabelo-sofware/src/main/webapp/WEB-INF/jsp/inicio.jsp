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
<body>
    <div id="content">
        <h id="titulo">¡Bienvenido a Friend Zone!</h>
  <div class="login">
      <h><img class="logo" src="http://www.fillmurray.com/320/310"></h>
    <h1>Iniciar Sesión</h1>
    <form action="/">
      <p><input type="text" name="username" value="" placeholder="Nombre de usuario"></p>
      <p><input type="password" name="password" value="" placeholder="Contraseña"></p>
      <p class="remember_me">
        <label>
          <input type="checkbox" name="remember_me" id="remember_me">
          Remember me on this computer
        </label>
      </p>
      <p class="submit"><input type="submit" name="commit" value="Login"></p>
    </form>
  </div>
  <div class="register">
    <h1>¡Registrate Ahora!</h1>
    <form action="/chabelo-sofware/crearUsuario">
      <p><input type="text" name="nombre" value="" placeholder="Nombre"></p>
      <p><input type="text" name="apellidoP" value="" placeholder="Apellido"></p>
      <p><input type="text" name="apellidoM" value="" placeholder="Apellido2"></p>
      <p><input type="text" name="username" value="" placeholder="Nombre de usuario"></p>
      <p><input type="text" name="email" value="" placeholder="Correo"></p>
      <p><input type="password" name="password" value="" placeholder="Contraseña"></p>
      <p><input type="password" name="passworConf" value="" placeholder="Confirma Contraseña"></p>
      
      <p class="remember_me">
        <label>
          <input type="checkbox" name="remember_me" id="remember_me">
          Remember me on this computer
        </label>
      </p>
      <p class="submit"><input type="submit" name="commit" value="Login"></p>
    </form>
  </div>
    </div>
</body>
</html>
