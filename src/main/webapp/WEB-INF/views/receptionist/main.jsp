<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body onload="startTime() ; currentDate()">
<%@ include file="../components/sidenav-receptionist.jsp" %>

<div class="main">
    <!--menu da direita-->
    <div class="row first_row">
        <div class="col-4">
            <img src="/imagens/draw_desk.svg" alt="doctor" class="icon1"/>
        </div>

        <div class="col-8 display_time">
            <div class="time_box">
                <i class="fas fa-clock"></i>
                <span id="hour"> </span>
            </div>
            <div class="date_box">
                <span id="date"> </span>
            </div>
        </div>
    </div>

    <div id="vista_geral">
    </div>

    <div class="row middle-row">
        <div class="card_box">
            <div class="card">
                <div class="card-body">
                    <img src="/imagens/noun_wait.svg" class="wait_list" alt="..."/>
                    <h5 class="utentes"><span id="num_utentes">?</span> UTENTES</h5>
                    <p class="linha_1">A AGUARDAR CONSULTA</p>
                    <p class="linha_2">
                        <span id=num_atrasados>?</span> utentes estão atrasados
                    </p>
                    <a href="/receptionist/waiting-list" class="btn btn-button">VER LISTA DE ESPERA</a>
                </div>
                <div class="horizontal-border"></div>
            </div>
        </div>


        <div class="card_box">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">CHECK-IN</h5>
                    <p class="card-text">
                        Introduza o numero de consulta
                    </p>
                    <form action="/receptionist/checkinbyAppointmentId" method="post">
                        <input type="text" id="num_consulta" placeholder="Nº de Consulta" name="appointmentId">
                        <button type="submit" class="btn btn-button btn-2">EFETUAR CHECKIN > </button>
                    </form>
                </div>
                <div class="horizontal-border"></div>
            </div>
        </div>

        <div class="card_box">
            <div class="card">
                <div class="card-body">

                    <div class="add-pat">
                        <a class="btn btn-outline-secondary btn-add" href="/receptionist/add-speciality"
                           type="submit">Adicionar nova especialidade
                        </a>
                    </div>

                    <div class="add-pat">
                        <a class="btn btn-outline-secondary btn-add" href="/receptionist/add-user" type="submit">Adicionar
                            novo utilizador</a>
                    </div>
                </div>
                <div class="horizontal-border"></div>
            </div>
        </div>

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
        if (i === 0 || i < 10) {
            i = "0" + i;
        }

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