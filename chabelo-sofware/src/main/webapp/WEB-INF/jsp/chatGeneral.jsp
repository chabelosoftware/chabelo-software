
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
       <link rel="stylesheet" type="text/css" href="<c:url value="/css/chatGeneral.css"/> ">
    
        <title>Lista de chats</title>
    </head>
<body>    
    
<script src="https://use.fontawesome.com/45e03a14ce.js"></script>
<div class="main_section">
   <div class="container">
      <div class="chat_container">
         <div class="col-sm-3 chat_sidebar">
    	 <div class="row">
            
            <div class="dropdown all_conversation">
               <form action="/chabelo-sofware/sesion/inicioU">
                    <button>Regresa</button>
               </form>
            </div>
            <div class="member_list">
               <ul class="list-unstyled">
                   <c:choose>
                        <c:when test="${empty chats}">
                            <p>No tienes ningun Chat :(</p>
                        </c:when>
                        <c:otherwise>
                           <c:forEach var="c" items="${chats}">
                                <li class="left clearfix">
                                <span class="chat-img pull-left">
                                    <img src="http://www.fillmurray.com/320/310" alt="User Avatar" class="img-circle">
                                </span>
                                <div class="chat-body clearfix">
                                    <div class="header_sec">
                                        <strong class="primary-font">${c.getVarNombre_UsuarioR().getVarNombre_Usuario()}</strong>
                                    </div>
                                    <div class="contact_sec">
                                        <strong class="primary-font">Chatea con ${c.getVarNombre_UsuarioR().getVarNombre_Usuario()}</strong> 
                                        <span class="badge pull-right">
                                            <form action="/chabelo-sofware/sesion/chatindividual">
                                                <input name = "u" onlyread value ="${c.getVarNombre_UsuarioR().getVarNombre_Usuario()}" style="display:none;"/>
                                                <button>Chat</button>
                                            </form>
                                        </span>
                                    </div>
                                </div>
                                </li>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
               </ul>
            </div></div>
         </div>
         <!--chat_sidebar-->
		 
		 
      </div>
   </div>
    <div>
        <img style="width:25%; float: right;" src= "img/logo2.png">    </div>
</div>
</body>
</html>