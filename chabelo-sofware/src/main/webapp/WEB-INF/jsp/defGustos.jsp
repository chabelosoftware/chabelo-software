<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Definición de Gustos</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto'>

      <link rel="stylesheet" href="css/style.css">

  
</head>

<body>
    
  <div class="container">
      
<form action="/chabelo-sofware/registraGustos" method="POST">     
 <ul class="list">
     <li>
        BIENVENIDO A FRIENDZONE 
     </li>   
  <li class="list__item">
   <input type="checkbox" class="radio-btn" name="choise1" id="a-opt"/>
   <label for="a-opt" class="label">Música</label>
  </li>
  <li class="list__item">
   <input type="checkbox" class="radio-btn" name="choise2" id="b-opt" />
   <label for="b-opt" class="label">Películas/Series</label>
  </li>
  <li class="list__item">
   <input type="checkbox" class="radio-btn" name="choise3" id="c-opt" />
   <label for="c-opt" class="label">Videojuegos</label>
  </li>
  <li class="list__item">
   <input type="checkbox" class="radio-btn" name="choise4" id="d-opt" />
   <label for="d-opt" class="label">Libros</label>
  </li>
  <li class="list__item">
   <input type="checkbox" class="radio-btn" name="choise5" id="e-opt" />
   <label for="e-opt" class="label">Deportes</label>
  </li>
  <input type="hidden" name="username" value=${username}>
  <li>
      <input type="submit" value="Enviar">
  </li>
 </ul>
   </form>         
</div>
  
  
</body>
</html>