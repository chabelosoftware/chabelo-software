/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var musica = document.getElementById('Musica');
var juegos = document.getElementById('Juegos');
var libros = document.getElementById('Libros');
var pelis = document.getElementById('Cine');
var deportes = document.getElementById('Deportes');

$(function() {
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
  
});

function loadMusica() {
            window.location = "/chabelo-sofware/sesion/buscMusica";
        }
function loadJuegos() {
            window.location = "/chabelo-sofware/sesion/buscJuegos";
        }
function loadLibros() {
            window.location = "/chabelo-sofware/sesion/buscLibros";
        }
function loadCine() {
            window.location = "/chabelo-sofware/sesion/buscCine";
        }
function loadDeportes() {
            window.location = "/chabelo-sofware/sesion/buscDeportes";
        }