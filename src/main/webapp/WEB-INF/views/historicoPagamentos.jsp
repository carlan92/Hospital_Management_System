<!DOCTYPE html>
<html lang="en">

<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="components/head.jsp" %>
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