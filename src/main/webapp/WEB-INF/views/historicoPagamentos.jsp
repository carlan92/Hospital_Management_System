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
  <div class="container">
    <div class="sidenav">
      <!-- menu da esquerda -->
      <img src="imagens\noun_centro_hospitalar_logo.svg" alt="logo" class="logo" />
      <div class="welcome_box">
        <p id="welcome">Olá de novo,</p>
        <p id="user_name">Pedro Romano</p>
        <p id="user_category">Utente</p>
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
      <div class="payment_history">
        <p class="payment_history">Histórico de Pagamentos</p>
      </div>

      <div class="payment_box">
        <div class="payment_values">
          <div class="payment_values-body">
            <div class= "pm_main_col">
            <div class= "payment_rowbold">Data:</div>
            <div class= "payment_row">24/02/2021</div>
            </div>
            <div class= "pm_main_col">
            <div class= "payment_rowbold">Valor:</div>
            <div class= "payment_row">60,33€</div>
            </div>
            <div class= "pm_main_col">
            <div class= "payment_rowbold">Especialidade:</div>
            <div class= "payment_row">Dentista</div>
            </div>
            <div class= "pm_main_col">
            <div class=payment_rowbold>Doutor/a:</div>
            <div class=payment_row>Maria João</div>  
            </div>    
            <div class= "buttons_payment">      
            <a href="#" class="btn-blue btn-w65">VER FATURA</a>
            <a href="#" class="btn-blue btn-w65">VER RECIBO</a>
            </div>
        </div>
        </div>
        <hr class= "payment_dash"></hr>
        <div class="payment_values">
          <div class="payment_values-body">
            <div class= "pm_main_col">
            <div class= "payment_rowbold">Data:</div>
            <div class= "payment_row">12/10/2020</div>
            </div>
            <div class= "pm_main_col">
            <div class= "payment_rowbold">Valor:</div>
            <div class= "payment_row">129,54€</div>
            </div>
            <div class= "pm_main_col">
            <div class= "payment_rowbold">Especialidade:</div>
            <div class= "payment_row">Otorrinologia</div>
            </div>
            <div class= "pm_main_col">
            <div class=payment_rowbold>Doutor/a:</div>
            <div class=payment_row>João António Migueis</div>  
            </div>    
            <div class= "buttons_payment">
            <a href="#" class="btn-blue btn-w65">VER FATURA</a>
            <a href="#" class="btn-blue btn-w65">VER RECIBO</a>
            </div>
        </div>
        </div>
        <hr class= "payment_dash"></hr>
  </div>
  </div>
</body>

</html>