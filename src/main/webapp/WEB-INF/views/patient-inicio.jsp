<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="components/head.jsp" %>
</head>

<body>
<%@ include file="components/sidenav-utente.jsp" %>
<div class="main">
    <!--menu da direita-->
    <div class="row first_row">

        <div class="col-4">
            <img src="imagens/draw_patient_inicio.svg" alt="" class="icon1" />
        </div>

        <div class="col-8 display_time">
            <div class="time_box">
                    <span id="hour">
                        <i class="fas fa-clock clock2"></i>
                        10:00
                    </span>
            </div>
            <div class="date_box">
                    <span id="date">
                        Quarta-feira 25 Fevereiro 2021
                    </span>
            </div>
        </div>
    </div>



    <div class="row middle-row margin-row">
        <div class="card_box">
            <div class="card">
                <div class="card-body align-bottom" >
                    <img src="imagens/draw-health2.svg" class="make_appt_img1" alt="..." />
                    <h4 class="appt_title">Marcação de Consultas</h4>
                    <p class="linha_2">
                        Faça aqui a marcação da sua próxima consulta
                    </p>
                    <a href="#" class="btn-green btn-w70">Marcar</a>
                </div>
                <div class="horizontal-border"></div>
            </div>
        </div>


        <div class="card_box">
            <div class="card ">
                <div class="card-body align-bottom">
                    <img src="imagens/draw_check-next.svg" class="make_appt_img2" alt="..." />
                    <h4 class="appt_title">Próximas Consultas</h4>
                    <p class="linha_2">
                        Consulte aqui as suas próximas consultas
                    </p>
                    <a href="#" class="btn-green btn-w70">Consultar</a>
                </div>
                <div class="horizontal-border"></div>
            </div>
        </div>

        <div class="card_box">
            <div class="card ">
                <div class="card-body align-bottom">
                    <img src="imagens/draw_past-appt.svg" class="make_appt_img3" alt="..." />
                    <h4 class="appt_title">Histórico de Consultas</h4>
                    <p class="linha_2">
                        Consulte aqui as suas anteriores consultas
                    </p>
                    <a href="#" class="btn-green btn-w70">Histórico</a>
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