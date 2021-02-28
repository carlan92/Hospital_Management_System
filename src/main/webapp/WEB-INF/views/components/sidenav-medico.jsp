<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="sidenav">
    <!-- menu da esquerda MEDICO-->
    <img src="imagens\noun_centro_hospitalar_logo.svg" alt="logo" class="logo" />

    <div class="welcome_box">
        <div class="perfil-row">
            <div class="col-4 user_photo">
                <img src="imagens/imagem-test.png" alt="user_photography" />
            </div>
            <div class="col user_info">
                <p id="welcome">Bem-vindo</p>
                <p id="user_name">Dr. Miguel Pereira</p>
                <p id="user_category">Médico</p>
            </div>
        </div>
        <div>
            <button type="button" class="btn-green btn-w70"> Ver Perfil </button>
        </div>
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
    </div>

    <div class="sidenav_row log_out_box">
        <img src="imagens/noun_upskill.png" alt="" id="upskill_logo" />
        <hr />
        <button type="button" class="">
            <img src="imagens/noun_logout.svg" /> Terminar Sessão
        </button>
    </div>
</div>