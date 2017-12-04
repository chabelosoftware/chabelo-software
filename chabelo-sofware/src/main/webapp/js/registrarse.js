/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validarFormularios(){
var usuario = document.form1.username.value;
var x = document.getElementById("fallo");
console.log(usuario);
if(usuario=="dewer1234")
{
document.getElementById('error-user').innerHTML = "El nombre de usuario ya está registrado";
}else{
document.getElementById('error-user').innerHTML = "";
}
var email = document.form1.email.value;
if(email=="dewer1234@hotmail.com")
{
document.getElementById('error-mail').innerHTML = "El e-mail proporcionado ya está registrado";
}else{
document.getElementById('error-mail').innerHTML = "";
}

var contrasena1 = document.form1.password.value;
var contrasena2 = document.form1.passworConf.value;
if(contrasena1!=contrasena2)
{
 document.getElementById('error-pass').innerHTML = "Las contraseñas son distintas";   
}else{
 document.getElementById('error-pass').innerHTML = "";   
}


}


