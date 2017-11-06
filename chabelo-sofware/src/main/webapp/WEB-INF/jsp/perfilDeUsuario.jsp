<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Perfil de Usuario</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

    <!-- Plugin CSS -->
    <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/creative.min.css" rel="stylesheet">

  </head>

  <body id="page-top">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">Mis Datos</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#services">Gustos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link js-scroll-trigger" href="#portfolio">M�s</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <header class="masthead">
      <div class="header-content">
        <div class="header-content-inner">
          <h1 id="homeHeading">Bienvenido a Friend Zone ${username}</h1>
          <hr>
          <p>Tu Nombre: ${nombre} </p>
          <p>Tu Correo: ${correo}</p>
          <a class="btn btn-primary btn-xl js-scroll-trigger" href="#services">Encuentra m�s ;)</a>
        </div>
      </div>
    </header>

    <section id="services">
      <div class="container">
        <div class="row">
          <div class="col-lg-12 text-center">
            <h2 class="section-heading">Tus gustos son: </h2>
            <hr class="primary">
          </div>
        </div>
      </div>
        
      <script type="text/javascript">var m = "${m}";</script>
      <script type="text/javascript">var j = "${j}";</script>
      <script type="text/javascript">var d = "${d}";</script>
      <script type="text/javascript">var l = "${l}";</script>
      <script type="text/javascript">var p = "${p}";</script>
        
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-6 text-center" id="musica">
            <div class="service-box">
              <i class="fa fa-4x fa-music text-primary sr-icons"></i>
              <h3>M�sica</h3>
              <p class="text-muted">�Pegale al ritmo!</p>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 text-center" id="pelis">
            <div class="service-box">
              <i class="fa fa-4x fa-film text-primary sr-icons"></i>
              <h3>Pel�culas/Series</h3>
              <p class="text-muted">�Listas las palomitas!</p>
            </div>
          </div>
          <div class="col-lg-4 col-md-6 text-center" id="juegos">
            <div class="service-box">
              <i class="fa fa-4x fa-gamepad text-primary sr-icons"></i>
              <h3>Videojuegos</h3>
              <p class="text-muted">Press Start</p>
            </div>
          </div>
          <div class="col-lg-6 col-md-6 text-center" id="libros">
            <div class="service-box">
              <i class="fa fa-4x fa-book text-primary sr-icons"></i>
              <h3>Libros</h3>
              <p class="text-muted">Menos face y m�s book</p>
            </div>
          </div>
          <div class="col-lg-6 col-md-6 text-center" id="deportes" >
            <div class="service-box">
              <i class="fa fa-4x fa-soccer-ball-o text-primary sr-icons"></i>
              <h3>Deportes</h3>
              <p class="text-muted">El deporte no solo cambia tu cuerpo, tambi�n tu mente</p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="p-0" id="portfolio">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-4 col-sm-6 text-center">
              <form action="/chabelo-sofware/sesion/buscGustos">
                <button class="btn btn-primary btn-xl" style="color: white; margin: 10px;">�Haz Amigos!</button>
              </form>
          </div>
          <div class="col-lg-4 col-sm-6 text-center links">
            <a class="btn btn-primary btn-xl" style="color: white; margin: 10px;">Chat</a>
          </div>
          <div class="col-lg-4 col-sm-6 text-center links">
            <a class="btn btn-primary btn-xl" style="color: white; margin: 10px;">Actualizar</a>
          </div>
        </div>  
        <div class="row no-gutter popup-gallery">
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/1.jpg">   
              <img class="img-fluid" src="img/portfolio/thumbnails/1.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                     �Haz Amigos!
                  </div>
                  <div class="project-name">
                    Encuentra otros que busquen lo mismo
                  </div>
                </div>
              </div>
            </a>             
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/2.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/2.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    Chat
                  </div>
                  <div class="project-name">
                    Ponte en contacto con otras personas
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/3.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/3.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                      Actualizar
                  </div>
                  <div class="project-name">
                    Cambia lo que quieras de tu perfil
                  </div>
                </div>
              </div>
            </a>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-4 col-sm-6 text-center">
            <form action="/chabelo-sofware/confirmacionElimina">
                <button class="btn btn-primary btn-xl" style="color: white; margin: 10px;">Borrar Perfil</button>
            </form>
          </div>
          <div class="col-lg-4 col-sm-6 text-center">
            <a class="btn btn-primary btn-xl" style="color: white; margin: 10px;">Logo</a>
          </div>
          <div class="col-lg-4 col-sm-6 text-center">
            <form action="/chabelo-sofware/logout">
                <button class="btn btn-primary btn-xl" style="color: white; margin: 10px;">Cerrar Sesi�n</button>
            </form>
          </div>
        </div>
        <div class="row no-gutter popup-gallery">
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/4.png">
              <img class="img-fluid" src="img/portfolio/thumbnails/4.png" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    Borrar Perfil
                  </div>
                  <div class="project-name">
                    �Te vamos a extra�ar!
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/5.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/5.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    Chabelo-Software
                  </div>
                  <div class="project-name">
                    Equipo de Dioses
                  </div>
                </div>
              </div>
            </a>
          </div>
          <div class="col-lg-4 col-sm-6">
            <a class="portfolio-box" href="img/portfolio/fullsize/6.jpg">
              <img class="img-fluid" src="img/portfolio/thumbnails/6.jpg" alt="">
              <div class="portfolio-box-caption">
                <div class="portfolio-box-caption-content">
                  <div class="project-category text-faded">
                    Cerrar Sesi�n
                  </div>
                  <div class="project-name">
                    �Hasta la pr�xima!
                  </div>
                </div>
              </div>
            </a>
          </div>
        </div>
      </div>
    </section>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper/popper.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/scrollreveal/scrollreveal.min.js"></script>
    <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/creative.min.js"></script>
    <script src="js/perfilDeUsuario.js"></script>

  </body>

</html>
