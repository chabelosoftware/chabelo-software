/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var limit = 10;
(function () {
    var Message;
    Message = function (arg) {
        this.text = arg.text, this.message_side = arg.message_side;
        this.draw = function (_this) {
            return function () {
                var $message;
                $message = $($('.message_template').clone().html());
                $message.addClass(_this.message_side).find('.text').html(_this.text);
                $('.messages').append($message);
                return setTimeout(function () {
                    return $message.addClass('appeared');
                }, 0);
            };
        }(this);
        return this;
    };
    $(function () {
        var getMessageText, sendMessage;
        getMessageText = function () {
            var $message_input;
            $message_input = $('.message_input');
            return $message_input.val();
        };
        sendMessage = function (text,message_side) {
            var $messages, message;
            if (text.trim() === '') {
                return;
            }
            if(message_side == 'right')
                $('.message_input').val('');
            $messages = $('.messages');
            message = new Message({
                text: text,
                message_side: message_side
            });
            message.draw();
            return $messages.animate({ scrollTop: $messages.prop('scrollHeight') }, 300);
        };
        $('.send_message').click(function (e) {
            return sendMessage(getMessageText(),'right');
        });
        $('.message_input').keyup(function (e) {
            if (e.which === 13) {
                var $message_input;
                $message_input = $('.message_input');
                var $message_value = $message_input.val();
                var xhttp = new XMLHttpRequest();
                xhttp.open("GET", "mandarMsg?mensaje="+$message_value+"&nom="+nombre, true);
                xhttp.send();
                return sendMessage(getMessageText(),'right');
            }
        });
        
        dameMensajes();
        setTimeout(function () {
            for(k = 0; k < limit ;k++){
                var t = mensajes[k];
                if(t.charAt(t.length-1) == 0){
                    sendMessage(t.substring(0,t.length - 1),'right');
                }else{
                    sendMessage(t.substring(0,t.length - 1),'left');   
                }
            }
        }, 3000);
        
        setTimeout(yourFunction,7000);
    });
}.call(this));

function yourFunction(){
    var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    text = this.responseText;
                    if(!mensajes.includes(text)){
                        console.log("no está");
                        mensajes.push(text);                        
                        //código de definición del Mensaje
                        var Message = function (arg) {
                                    this.text = arg.text, this.message_side = arg.message_side;
                                    this.draw = function (_this) {
                                                        return function () {
                                                            var $message;
                                                            $message = $($('.message_template').clone().html());
                                                            $message.addClass(_this.message_side).find('.text').html(_this.text);
                                                            $('.messages').append($message);
                                                            return setTimeout(function () {
                                                                                return $message.addClass('appeared');
                                                                               }, 0);
                                                                };
                                                }(this);
                                    return this;
                                   };
                        
                        //Termina definición del Mensaje, empieza código de sendMessage()
                        var $messages, message;
                        if (text.trim() === '') {
                            return;
                        }
                        $messages = $('.messages');
                        var message = new Message({
                        text: text.substring(0,text.length -1 ),
                        message_side: 'left'
                        });
                        message.draw();
                        $messages.animate({ scrollTop: $messages.prop('scrollHeight') }, 300);                                                
                        //termina sendMessage()
                        
                    }else{
                        console.log("está");
                    }
                }
            };
            xhttp.open("GET", "respuestaChatRecibidos?nom="+nombre+"&index=0", true);
            xhttp.send();
    setTimeout(yourFunction, 5000);
}


function createCallback(ind,xhttp) {
    return function() {
        if (this.readyState == 4 && this.status == 200) {
                                            mensajes[ind]=xhttp.responseText;
                                       }
    };
}

function dameMensajes(){ 
    for(i = 1; i <= limit ; i++){
        var xhttp;
        xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = createCallback(i-1,xhttp);
        xhttp.open("GET", "respuestaChat?nom="+nombre+"&index="+(limit - i), true);
        xhttp.send();
    }
    var xhttp;
    xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = createCallback(limit,xhttp);
    xhttp.open("GET", "respuestaChatRecibidos?nom="+nombre+"&index=0", true);
    xhttp.send();
}

