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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
       <link rel="stylesheet" type="text/css" href="<c:url value="/css/actualizacion.css"/> ">

              
        <title>Actualizacion de Datos</title>
    </head>
    <body>
      <div class="container">
<div class="col-md-5">
    <div class="form-area">  
        <form role="form">
        <br style="clear:both">
                    <h3 style="margin-bottom: 25px; text-align: center;">Actualiza tus datos</h3>
    				<div class="form-group">
						<input type="text" class="form-control" id="name" name="name" placeholder="Name" required>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="paterno" name="paterno" placeholder="Apellido Paterno" required>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="materno" name="materno" placeholder="Apellido Materno" required>
					</div>
                                        <div class="form-group">
						<input type="text" class="form-control" id="email" name="email" placeholder="Email" required>
					</div>
                                        <div class="form-group">
						<input type="text" class="form-control" id="usuario" name="usuario" placeholder="Nombre de Usuario" required>
					</div>
                                        <div class="form-group">
						<input type="password" class="form-control" id="contrasena" name="contrasena" placeholder="Contrasena" required>
					</div>
                                        <div class="form-group">
						<input type="password" class="form-control" id="confirmacion" name="confirmacion" placeholder="Confirmacion Contrasena" required>
					</div>
                    <div class="form-group">
                        <input type="checkbox" id="musica" value="musica"> <label for="musica">Musica</label>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" id="libros" value="libros"> <label for="libros">Libros</label>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" id="juegos" value="juegos"> <label for="juegos">Videojuegos</label>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" id="deportes" value="deportes"> <label for="deportes">Deportes</label>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" id="peliculas" value="peliculas"> <label for="peliculas">Peliculas/Series</label>                   
                    </div>
                    
            
        <button type="button" id="submit" name="submit" class="btn btn-primary pull-right">Aceptar</button>
        </form>
    </div>
</div>
</div>

    </body>
</html>