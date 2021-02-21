<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <title>Centro Hospitalar UPskill</title>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
    crossorigin="anonymous"></script>

  <link rel="preconnect" href="https://fonts.gstatic.com">

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
    integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous" />
  <script src="https://kit.fontawesome.com/6afe83edf7.js" crossorigin="anonymous"></script>

  <link rel="stylesheet" href="style.css" />
  <link rel="icon" href="favicon.ico" type="image/x-icon">

</head>

<body>
  <div class="container">
    <div class="sidenav">
      <!-- menu da esquerda -->
      <img src="imagens\noun_centro_hospitalar_logo.svg" alt="logo" class="logo" />
      <div class="welcome_box">
        <p id="welcome">Olá de novo,</p>
        <p id="user_name">Pedro Romano</p>
        <p id="user_category">Funcionário</p>
      </div>
      <div class="sidenav_row">
        <button type="button" class="">
          <img src="imagens/noun_home.svg" /> Início
        </button>
        <button type="button" class="">
          <img src="imagens/noun_utentes.svg" /> Utentes
        </button>
        <button type="button" class="">
          <img src="imagens/noun_doctor.svg" /> Médicos
        </button>
        <button type="button" class="">
          <img src="imagens/noun_heart rate.svg" /> Consultas
        </button>
      </div>

      <div class="sidenav_row">
        <p id="acessos_rapidos">Acessos Rápidos</p>
        <button type="button" class="botao_acessos">
          <img src="imagens/noun_information.svg" /> Informações gerais
        </button>
        <button type="button" class="botao_acessos">
          <img src="imagens/noun_calendar.svg" /> Calendário de vagas
        </button>
        <button type="button" class="botao_acessos">
          <img src="imagens/noun_phone.svg" /> Contactos
        </button>
      </div>

      <div class="sidenav_row log_out_box">
        <img src="imagens/noun_upskill.png" alt="" id="upskill_logo" />
        <hr />
        <button type="button" class="">
          <img src="imagens/noun_logout.svg" /> Terminar Sessão
        </button>
      </div>
    </div>




    <div class="main">
      <!--menu da direita-->
      <div class="row first_row">
        <div class="col-4">
          <img src="imagens/noun_icon_01.svg" alt="" class="icon1" />
        </div>
        <div class="col-8 intro">
          <h1>CUIDE DE SI E DOS SEUS.</h1>
          <p id="texto-intro">
            O Centro Hospitalar UPskill inspira-se nos seus clientes para
            estar na vanguarda na proteção das famílias. Estamos mais
            inovadores na prestação de cuidados de saúde, mais próximos e mais
            ágeis.
          </p>
        </div>
      </div>
      <div id="vista_geral">
        VISTA GERAL
      </div>

      <div class="row middle-row">
        <div class="card_box">
          <div class="card">
            <div class="card-body">
              <img src="imagens/noun_wait.svg" class="wait_list" alt="..." />
              <h5 class="utentes"><span id="num_utentes">4</span> UTENTES</h5>
              <p class="linha_1">A AGUARDAR CONSULTAS</p>
              <p class="linha_2">
                <span id=num_atrasados>2</span> utentes estão atrasados
              </p>
              <a href="#" class="btn btn-button">VER LISTA DE ESPERA</a>
            </div>
            <div class="horizontal-border"></div>
          </div>
        </div>


        <div class="card_box">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">CHECK-IN</h5>
              <p class="card-text">
                Introduza o numero de consulta
              </p>
              <input type="text" id="num_consulta" placeholder="Nº de Consulta">
              <a href="#" class="btn btn-button btn-2">EFETUAR CHECKIN > </a>
            </div>
            <div class="horizontal-border"></div>
          </div>
        </div>
      </div>

      <div class="row last-row">
      
        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
      
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img src="imagens/noun_news2.png" class="d-block w-100" alt="..." />
            </div>
            <div class="carousel-item">
              <img src="imagens/noun_newssns.png" class="d-block w-100" alt="..." />
            </div>
            <div class="carousel-item">
              <img src="'imagens/noun_news2.png'" class="d-block w-100" alt="..." />
            </div>
          </div>
      
          <button class="carousel-control-prev seta" type="button" data-bs-target="#carouselExampleControls"
            data-bs-slide="prev">
            <i class="fas fa-less-than simbolo_seta"></i>
          </button>
      
          <button class="carousel-control-next seta" type="button" data-bs-target="#carouselExampleControls"
            data-bs-slide="next">
            <i class="fas fa-greater-than simbolo_seta"></i>
          </button>
      
        </div>
      
      </div>
    </div>
  </div>
</body>

</html>