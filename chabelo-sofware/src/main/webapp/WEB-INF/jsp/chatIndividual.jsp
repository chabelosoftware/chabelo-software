<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/chatIndividual.css"/> ">
        <title>Chat</title>
        
        
    <body>
        <div class="chat_window">
           <div class="top_menu">
               <div class="title">Chat</div>
           </div>
           <ul class="messages" id="chat">
                
           </ul>
           <div class="bottom_wrapper clearfix">
               <div class="message_input_wrapper">
                    
                        <input name="mensaje" class="message_input" placeholder="Escribe un mensaje aquí..." />
                                                                                                    
               </div>  
                         <div class="send_message">
                       
                            <div class="icon"></div>
                                <!--<div class="text">Send</div>-->
                            <div class="text" type="button" onclick="func()" id="demo">Enviar</div>    
                         </div>
           </div>
       </div>
       <div class="message_template">
           <li class="message">
               <div class="avatar"></div>
               <div class="text_wrapper">
                   <div class="text"></div>
                       
               </div>
           </li>
               
       </div>
        <form action="/chabelo-sofware/sesion/inicioU">
            <button>Regresa</button>
        </form>
    </body>
    </head>
    <script>var mensajes = []; </script>
    <script>var nombre = "${nom}";</script>
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/chat.js"></script>

    <script>
        function func(){
            var $message_input;
            $message_input = $('.message_input');
            var $message_value = $message_input.val();
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "mandarMsg?mensaje="+$message_value+"&nom="+nombre, true);
            xhttp.send();
        }            
        
        function loadDoc() {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                //document.getElementById("chat").innerHTML =
                //this.responseText;
                //document.getElementById("chat").appendChild(document.getElementById("message").cloneNode(true));
                    var $message;
                    $message = $($('.message_template').clone().html());
                    $message.addClass('left').find('.text').html(this.responseText);
                    $('.messages').append($message);
                    $messages = $('.messages');
                    $messages.animate({ scrollTop: $messages.prop('scrollHeight') }, 300);
                    return setTimeout(function () {
                        return $message.addClass('appeared');
                    }, 0);
                }
            };
            xhttp.open("GET", "respuestaChat", true);
            xhttp.send();
        }
    </script>
    
    
    
</html>
