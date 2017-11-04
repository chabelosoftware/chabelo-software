/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var musica = document.getElementById('musica');
var juegos = document.getElementById('juegos');
var libros = document.getElementById('libros');
var pelis = document.getElementById('pelis');
var deportes = document.getElementById('deportes');
var suma = parseInt(m)+parseInt(j)+parseInt(l)+parseInt(p)+parseInt(d);

$(function() {
    console.log(suma);
    if(m == 0)
        musica.style.display = "none";
    if(j == 0)
        juegos.style.display = "none";
    if(l == 0)
        libros.style.display = "none";
    if(p == 0)
        pelis.style.display = "none";
    if(d == 0)
        deportes.style.display = "none";
    
    if(suma === 1){
        musica.className = "col-lg-12 col-md-6 text-center";
        juegos.className = "col-lg-12 col-md-6 text-center";
        libros.className = "col-lg-12 col-md-6 text-center";
        pelis.className = "col-lg-12 col-md-6 text-center";
        deportes.className = "col-lg-12 col-md-6 text-center";
    }else if(suma === 2){
        musica.className = "col-lg-6 col-md-6 text-center";
        juegos.className = "col-lg-6 col-md-6 text-center";
        libros.className = "col-lg-6 col-md-6 text-center";
        pelis.className = "col-lg-6 col-md-6 text-center";
        deportes.className = "col-lg-6 col-md-6 text-center";
    }else if(suma === 3){
        musica.className = "col-lg-4 col-md-6 text-center";
        juegos.className = "col-lg-4 col-md-6 text-center";
        libros.className = "col-lg-4 col-md-6 text-center";
        pelis.className = "col-lg-4 col-md-6 text-center";
        deportes.className = "col-lg-4 col-md-6 text-center";
    }else if(suma === 4){
        if(d == 0){
            musica.className = "col-lg-4 col-md-6 text-center";
            juegos.className = "col-lg-4 col-md-6 text-center";
            libros.className = "col-lg-12 col-md-6 text-center";
            pelis.className = "col-lg-4 col-md-6 text-center";
            deportes.className = "col-lg-12 col-md-6 text-center";
        }else{
            musica.className = "col-lg-4 col-md-6 text-center";
            juegos.className = "col-lg-4 col-md-6 text-center";
            libros.className = "col-lg-4 col-md-6 text-center";
            pelis.className = "col-lg-4 col-md-6 text-center";
            deportes.className = "col-lg-12 col-md-6 text-center";
        }
    }else{
        musica.className = "col-lg-4 col-md-6 text-center";
        juegos.className = "col-lg-4 col-md-6 text-center";
        libros.className = "col-lg-6 col-md-6 text-center";
        pelis.className = "col-lg-4 col-md-6 text-center";
        deportes.className = "col-lg-6 col-md-6 text-center";
    }
});
