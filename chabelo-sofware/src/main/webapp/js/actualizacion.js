/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var musica = document.getElementById('musica');
var juegos = document.getElementById('juegos');
var libros = document.getElementById('libros');
var pelis = document.getElementById('peliculas');
var deportes = document.getElementById('deportes');

$(function() {
    if(m==1){
        musica.checked = true;
    }
    if(j==1){
        juegos.checked = true;
    }
    if(l==1){
        libros.checked = true;
    }
    if(p==1){
        pelis.checked = true;
    }
    if(d==1){
        deportes.checked = true;
    }
});