<%-- 
    Document   : eliminacion
    Created on : Oct 18, 2017, 11:37:31 PM
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
       <link rel="stylesheet" type="text/css" href="<c:url value="/css/eliminacion.css"/> ">
        <title>Confirmacion de Eliminacion</title>
    </head>
    <body>
        <div class="container">
	<div class="row">
     <h2 class="titulo">¿Estas seguro de borrar tu perfil?</h2>
    <ul class="ds-btn">
        <li>
             <a class="btn btn-lg btn-primary" href="http://dotstrap.com/">
          <i class="glyphicon glyphicon-user pull-left"></i><span>Si<br><small>¡Borraras tu perfil!</small></span></a> 
            
        </li>
        <li>
             <a class="btn btn-lg btn-success " href="http://dotstrap.com/">
         <i class="glyphicon glyphicon-dashboard pull-left"></i><span>No<br><small>¡Seguiras con nosotros!</small></span></a> 
            
        </li>
        
    </ul>
    
	</div>
</div>
    </body>
</html>
