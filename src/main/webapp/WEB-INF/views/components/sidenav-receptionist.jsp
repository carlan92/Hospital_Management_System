<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="sidenav">
    <!-- menu da esquerda RECEPCIONISTA-->
    <a href="/">
        <img src="/imagens/noun_centro_hospitalar_logo.svg" alt="logo" class="logo"/>
    </a>
    <div class="welcome_box">
        <div class="perfil-row">
            <div class="col-4 user_photo">
                <img src="/uploaded_images/${user_logged.getPhotoURL()}" alt="user_photography"/>
            </div>
            <div class="col user_info">
                <p id="welcome">
                    <c:if test="${user_logged.getSex().equals('Masculino')}">
                        Bem-vindo
                    </c:if>
                    <c:if test="${user_logged.getSex().equals('Feminino')}">
                        Bem-vinda
                    </c:if>

                </p>

                <p id="user_name">${user_logged.getFirstAndLastName()}</p>
                <p id="user_category">${user_logged.getAccount()}</p>
            </div>
        </div>
        <div>
            <a type="button" href="/user/user-profile" class="btn-green btn-w40"> Ver Perfil </a>
        </div>
    </div>

    <div class="panel-scroll">
        <div class="sidenav_row">
            <a href="/receptionist/main" class="botao_acessos">
                <img src="/imagens/noun_home.svg" class="sidenav-icon"/> Início
            </a>
            <%@ include file="../components/mail.jsp" %>
            <a href="/doctor-receptionist/patient-list" class="botao_acessos">
                <img src="/imagens/noun_utentes.svg"class="sidenav-icon"/> Utentes
            </a>
            <a href="/user/doctor-list" class="botao_acessos">
                <img src="/imagens/noun_doctor-list.svg" class="sidenav-icon"/> Médicos
            </a>
            <a href="/receptionist/appointment-list/resume" class="botao_acessos">
                <img src="/imagens/noun_heart_rate.svg"class="sidenav-icon"/> Consultas
            </a>
            <a href="/receptionist/checkin" class="botao_acessos">
                <img src="/imagens/draw_cal_checkmark.svg" class="sidenav-icon"/> Check-in
            </a>
            <a href="/user/lista-chamada" class="botao_acessos">
                <img src="/imagens/noun_time.svg" class="sidenav-icon"/> Chamada para consulta
            </a>
            <a href="/receptionist/waitingAppointment" class="botao_acessos">
                <img src="/imagens/noun_wait.svg" class="sidenav-icon"/> Lista de Espera para Marcação
            </a>
        </div>

        <div class="sidenav_row">
            <p id="acessos_rapidos">Acessos Rápidos</p>
            <a type="button" href="/public/general-information" class="botao_acessos">
                <img src="/imagens/noun_information.svg"/> Informações gerais
            </a>
            <a type="button" href="/public/contacts" class="botao_acessos">
                <img src="/imagens/noun_phone.svg"/> Contactos
            </a>
        </div>
    </div>

    <div class="sidenav_row log_out_box">
        <img src="/imagens/noun_upskill.png" alt="" id="upskill_logo"/>
        <hr/>
        <form method="post" action="/logout">
            <button type="submit">
                <img src="/imagens/noun_logout.svg"/> Terminar Sessão
            </button>
        </form>
    </div>
</div>