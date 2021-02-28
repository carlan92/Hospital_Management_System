<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <title>Centro Hospitalar UPskill</title>

  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
    crossorigin="anonymous"></script>

  <script src="https://kit.fontawesome.com/6afe83edf7.js" crossorigin="anonymous"></script>
  
  <link rel="stylesheet" href="bootstrap.min.4.5.3.css"/>
  <link rel="stylesheet" href="style.css" />
  <link rel="icon" href="favicon.ico" type="image/x-icon">

</head>

<body>
    <div class="sidenav">
      <!-- menu da esquerda -->
      <img src="imagens\noun_centro_hospitalar_logo.svg" alt="logo" class="logo" />
      <div class="welcome_box">
        <p id="welcome">Olá de novo,</p>
        <a id="user_name" href="/user">${user.getFirstAndLastName()}</a>
        <p id="user_category">${user.getAccount()}</p>
      </div>
      <div class="panel-scroll">
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
          <a href="#" type="button" class="botao_acessos">
            <img src="imagens/noun_information.svg" /> Informações gerais
          </a>
          <button type="button" class="botao_acessos">
            <img src="imagens/noun_calendar.svg" /> Calendário de vagas
          </button>
          <button type="button" class="botao_acessos">
            <img src="imagens/noun_phone.svg" /> Contactos
          </button>
        </div>
      </div>

      <div class="sidenav_row log_out_box">
        <img src="imagens/noun_upskill.png" alt="" id="upskill_logo" />
        <hr />
        <button type="button" class="">
          <img src="imagens/noun_logout.svg" /> Terminar Sessão
        </button>
      </div>
    </div>




    <div class="maininfo">
      <!--menu da direita-->
      <p class= "igtitlefont">Informações Gerais</p>
      <div class= "divinfo">
        <a href="">
        <div class="containerinfo">
          <img class= "imginfo" src="imagens/info_covid.png"/>
          <div class="textinfo-block">
            <p>Novas informações sobre a Sars-CoV-2</p>
          </div>
          <div class="overlaytextinfo">
            <div class="textinfo">Ver Mais</div>
          </div>
        </a>
        </div>
      
      
      <div class= "divinfo">
        <a href="">
        <div class="containerinfo">
          <img class= "imginfo" src="imagens/info_vacinacao.png"/>
          <div class="textinfo-block">
            <p>O que acontece no nosso corpo quando somos vacinados?</p>
          </div>
          <div class="overlaytextinfo">
            <div class="textinfo">Ver Mais</div>
          </div>
        </div>
        </a>
      </div>

      <div class= "divinfo">
       <a href="m"> 
        <div class="containerinfo">
          <img class= "imginfo" src="imagens/info_teleconsulta.png"/>
          <div class="textinfo-block">
            <p>Mais informações sobre Teleconsultas</p>
          </div>
          <div class="overlaytextinfo">
            <div class="textinfo">Ver Mais</div>
          </div>
        </div>
      </a>
      </div>

      <div class= "divinfo">
        <a href=""> 
        <div class="containerinfo">
          <img class= "imginfo" src="imagens/info_epilepsia.png"/>
          <div class="textinfo-block">
            <p>Epilepsia. O que é?</p>
          </div>
          <div class="overlaytextinfo">
            <div class="textinfo">Ver Mais</div>
          </div>
        </div>
      </a>
      </div>
      
    </div>
    </div>
      

</body>

</html>