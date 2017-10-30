<!DOCTYPE html>
<html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <title>Busqueda por Gustos en Com�n</title>

<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic|Raleway:400,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'>

    <link rel="stylesheet" type="text/css" href="css/normalize.css">
    <link rel="stylesheet" type="text/css" href="css/buscastyle.css">

<style>

.demo-1 {
    position:relative;
    width:300px;
    height:200px;
    overflow:hidden;
    float:left;
    margin-right:20px;
    background-color:rgba(26,76,110,0.5)
}

.demo-1 p,.demo-1 h2 {
    color:#fff;
    padding:10px;
    left:-20px;
    top:20px;
    position:relative
}

.demo-1 p {
    font-family:'Lato';
    font-size:12px;
    line-height:18px;
    margin:0
}

.demo-1 h2 {
    font-family:'Lato';
    font-size:20px;
    line-height:24px;
    margin:0;
}

.effect img {
    position:absolute;
    margin:-15px 0;
    right:0;
    top:0;
    cursor:pointer;
    -webkit-transition:top .4s ease-in-out,right .4s ease-in-out;
    -moz-transition:top .4s ease-in-out,right .4s ease-in-out;
    -o-transition:top .4s ease-in-out,right .4s ease-in-out;
    transition:top .4s ease-in-out,right .4s ease-in-out
}

.effect img.top:hover {
    top:-230px;
    right:-330px;
    padding-bottom:200px;
    padding-left:300px
}
.libros{
width: 100%;
height: 110%;
    
}


    </style>

    </head>

<body>


<ul>
<li>
     <ul class="demo-1 effect">
        <li>
            <h2>This is a cool title!</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nost.</p>
        </li>
        
        <li><img class="top" src="img/microfono.jpg" alt=""/></li>
    </ul>
</li>


<li>
     <ul class="demo-1 effect">
        <li>
            <h2>This is a cool title!</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nost.</p>
        </li>
        
        <li><img id="libros" class="top" src="img/librosd.jpg" alt=""/></li>
    </ul>
</li>



<li>
     <ul class="demo-1 effect">
        <li>
            <h2>This is a cool title!</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nost.</p>
        </li>
        
        <li><img class="top" src="img/header.jpg" alt=""/></li>
    </ul>
</li>

</ul>

</body>
</html>