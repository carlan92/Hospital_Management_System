<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />

        <script src="https://kit.fontawesome.com/6afe83edf7.js" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="style.css" />
</head>

<body>


        <div class="sidenav">
            <!-- menu da esquerda -->

            <img src="imagens\noun_centro_hospitalar_logo.svg" alt="logo" class="logo" />

            <div class="welcome_box">
                <p id="bem-vindo"> Bem-vindo</p>
            </div>
            <form method="get" action="/homeToLogin">
                <div class="but-login">
                    <button type="submit" class="btn-green btn-login"> Login </button>
                </div>
            </form>

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

            <div class="sidenav_row log_out_box2">
                <img src="imagens/noun_upskill.png" alt="" id="upskill_logo2" />
                <hr />
            </div>

        </div>





</body>

</html>