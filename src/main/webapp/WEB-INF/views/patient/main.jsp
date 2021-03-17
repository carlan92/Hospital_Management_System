<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body onload="startTime() ; currentDate()">
<%@ include file="../components/sidenav-utente.jsp" %>

<div class="main">
    <!--menu da direita-->
    <div class="row first_row">
        <div class="col-4">
            <img src="/imagens/draw_patient_inicio.svg" alt="patient" class="icon1"/>
        </div>

        <div class="col-8 display_time">
            <div class="time_box">
                <i class="fas fa-clock clock2"></i>
                <span id="hour"> </span>
            </div>
            <div class="date_box">
                    <span id="date"> </span>
            </div>
        </div>
    </div>


    <div class="row middle-row margin-row">
        <div class="card_box">
            <div class="card mw-270">
                <div class="card-body ">
                    <div class="patient_img">
                        <img src="/imagens/draw-health2.svg" class="make_appt_img" alt="..."/>
                    </div>
                    <div class="patient_title">
                        <h4 class="appt_title">Marcação de Consultas</h4>
                        <p class="linha_2">
                            Faça aqui a marcação da sua próxima consulta
                        </p>
                    </div>
                    <div class="btn-patient">
                        <a href="/patient/make-appointment" class="btn-green btn-w70">Marcar</a>
                    </div>
                </div>
                <div class="horizontal-border"></div>
            </div>
        </div>

        <div class="card_box">
            <div class="card mw-270">
                <div class="card-body ">
                    <div class="patient_img">
                        <img src="/imagens/draw_check-next.svg" class="make_appt_img" alt="..."/>
                    </div>
                    <div class="patient_title">
                        <h4 class="appt_title">Próximas Consultas</h4>
                        <p class="linha_2">
                            Consulte aqui as suas próximas consultas
                        </p>
                    </div>
                    <div class="btn-patient">
                        <a href="/patient/appointment-list/current" class="btn-green btn-w70">Consultar</a>
                    </div>
                </div>
                <div class="horizontal-border"></div>
            </div>
        </div>

        <div class="card_box">
            <div class="card mw-270">
                <div class="card-body ">
                    <div class="patient_img">
                        <img src="/imagens/draw_past-appt.svg" class="make_appt_img" alt="..."/>
                    </div>
                    <div class="patient_title">
                        <h4 class="appt_title">Histórico de Consultas</h4>
                        <p class="linha_2">
                            Consulte aqui o seu histórico de consultas
                        </p>
                    </div>
                    <div class="btn-patient">
                        <a href="/patient/appointment-list/past" class="btn-green btn-w70">Histórico</a>
                    </div>
                </div>
                <div class="horizontal-border"></div>
            </div>
        </div>
    </div>


    <div class="row last-row">

        <%@ include file="../components/carousel.jsp" %>

    </div>
</div>

<script>

    function startTime() {
        let today = new Date();
        let h = today.getHours();
        let m = today.getMinutes();
        m = checkTime(m);
        h = checkTime(h);
        document.getElementById('hour').innerHTML = h + ":" + m;
        let t = setTimeout(startTime, 500);
    }

    function checkTime(i) {
        if (i < 10) {
            i = "0" + i;
        }
        return i;
    }

    function currentDate() {
        let todayDate = new Date();

        let days = [
            "Domingo",
            "Segunda-feira",
            "Terça-feira",
            "Quarta-feira",
            "Quinta-feira",
            "Sexta-feira",
            "Sábado"];

        let months = [
            "Janeiro",
            "Fevereiro",
            "Março",
            "Abril",
            "Maio",
            "Junho",
            "Julho",
            "Agosto",
            "Setembro",
            "Outubro",
            "Novembro",
            "Dezembro"];

        let currentYear = todayDate.getFullYear();
        let currentDay = days[todayDate.getDay()];
        let currentMonth = months[todayDate.getMonth()];
        let currentData = todayDate.getDate();

        document.getElementById('date').innerHTML = currentDay + " " + currentData + " de " + currentMonth + " " + currentYear;
    }


</script>
</body>


</html>