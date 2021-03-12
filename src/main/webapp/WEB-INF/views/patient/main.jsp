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
            <img src="/imagens/draw_patient_inicio.svg" alt="" class="icon1"/>
        </div>

        <div class="col-8 display_time">
            <div class="time_box">
                <i class="fas fa-clock clock2"></i>
                <span id="hour">
                    </span>
            </div>
            <div class="date_box">
                    <span id="date">
                    </span>
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

        <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">

            <div class="carousel-inner">
                <div class="carousel-item active" data-interval="10000">
                    <img src="/imagens/pub_1.png" class="d-block w-100" alt="First slide"/>
                </div>
                <div class="carousel-item">
                    <img src="/imagens/pub_2.png" class="d-block w-100" alt="Second slide"/>
                </div>
                <div class="carousel-item">
                    <img src="/imagens/pub_3.png" class="d-block w-100" alt="Third slide"/>
                </div>
                <div class="carousel-item ">
                    <img src="/imagens/pub_4.png" class="d-block w-100" alt="Fourth slide"/>
                </div>
                <div class="carousel-item">
                    <img src="/imagens/pub_5.png" class="d-block w-100" alt="Fifth slide"/>
                </div>
                <div class="carousel-item">
                    <img src="/imagens/pub_6.png" class="d-block w-100" alt="Sixth slide"/>
                </div>
                <div class="carousel-item">
                    <img src="/imagens/pub_7.png" class="d-block w-100" alt="Seventh slide"/>
                </div>
                <div class="carousel-item">
                    <img src="/imagens/pub_8.png" class="d-block w-100" alt="Eighth slide"/>
                </div>
            </div>

            <a class="carousel-control-prev seta" href="#carouselExampleInterval" role="button" data-slide="prev">
                <i class="fas fa-less-than simbolo_seta"></i>
            </a>

            <a class="carousel-control-next seta" href="#carouselExampleInterval" role="button" data-slide="next">
                <i class="fas fa-greater-than simbolo_seta"></i>
            </a>

        </div>
    </div>
</div>

<script>

    $('.carousel').carousel();

    function startTime() {
        let today = new Date();
        let h = today.getHours();
        let m = today.getMinutes();
        m = checkTime(m);
        h= checkTime(h);
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