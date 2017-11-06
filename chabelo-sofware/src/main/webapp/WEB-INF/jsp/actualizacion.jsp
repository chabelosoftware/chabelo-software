<%-- 
    Document   : actualizacion
    Created on : Oct 16, 2017, 3:17:43 PM
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
       <link rel="stylesheet" type="text/css" href="<c:url value="/css/actualizacion.css"/> ">

              
        <title>Actualizacion de Datos</title>
    </head>
    <body>
      <div class="container">
<div class="col-md-5">
    <div class="form-area">  
        <form action="/chabelo-sofware/actualizarUsuario" method="POST">
        <br style="clear:both">
                    <h3 style="margin-bottom: 25px; text-align: center;">Actualiza tus datos</h3>
    			
                    <div class="form-group">
						<input type="text" class="form-control" id="name" name="name" placeholder="Name" value=${nombre}>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="paterno" name="paterno" placeholder="Apellido Paterno" value=${paterno}>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="materno" name="materno" placeholder="Apellido Materno" value=${materno} >
					</div>
                                        <div class="form-group">
						<input type="text" class="form-control" id="email" name="email" placeholder="Email" value=${correo}>
					</div>
                                        <div class="form-group">
						<input type="text" class="form-control" id="usuario" name="usuario" placeholder="Nombre de Usuario" value=${usuario} readonly>
					</div>
                                        <div class="form-group">
						<input type="password" class="form-control" id="contrasena" name="contrasena" placeholder="Contrasena">
					</div>
                                        <div class="form-group">
						<input type="password" class="form-control" id="confirmacion" name="confirmacion" placeholder="Confirmacion Contrasena" required>
					</div>
                                        
                    <script type="text/javascript">var m = "${m}";</script> 
                    <script type="text/javascript">var l = "${l}";</script>  
                    <script type="text/javascript">var p = "${p}";</script>  
                    <script type="text/javascript">var d = "${d}";</script>  
                    <script type="text/javascript">var j = "${j}";</script>  
                    <div class="form-group">
                        <input type="checkbox" id="musica" name="choice1" value="musica"> <label for="musica">Musica</label>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" id="libros" name="choice2" value="libros"> <label for="libros">Libros</label>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" id="juegos" name="choice3" value="juegos"> <label for="juegos">Videojuegos</label>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" id="deportes" name="choice4" value="deportes" > <label for="deportes">Deportes</label>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" id="peliculas" name="choice5" value="peliculas"> <label for="peliculas">Peliculas/Series</label>                   
                    </div>
                    
            
        <button type="submit" id="submit" name="submit" class="btn btn-primary pull-right">Aceptar</button>
        </form>
    </div>
</div>
</div>
    
     <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    
    <script src="js/actualizacion.js"></script>
    </body>
</html>