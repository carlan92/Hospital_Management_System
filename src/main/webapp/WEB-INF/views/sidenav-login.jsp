<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <div class="sidenav">
        <!-- menu da esquerda -->

        <img src="imagens\noun_centro_hospitalar_logo.svg" alt="logo" class="logo" />

        <div class="panel-scroll">
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
        </div>
        
        <div class="sidenav_row log_out_box2">
            <img src="imagens/noun_upskill.png" alt="" id="upskill_logo2" />
            <hr />
        </div>

    </div>