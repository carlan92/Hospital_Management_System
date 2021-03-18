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

    <div class="row middle-row margin-row">
        <div class="card_box">
            <div class="card mw-270">
                <div class="card-body">
                    <img src="/imagens/draw_patient-wait.svg" class="wait-img" alt="..."/>
                    <p class="utentes"><span id="num_utentes">${pacientes_confirmadosEspera}</span> UTENTES</p>
                    <p class="linha_1">A AGUARDAR CONSULTA</p>
                    <p class="linha_2">
                        Nº de utentes atrasados: <span id=num_atrasados>${pacientes_faltaram}</span>
                    </p>
                    <a href="/receptionist/waiting-list" class="btn btn-blue"> Ver lista de espera</a>
                </div>
                <div class="horizontal-border"></div>
            </div>
        </div>


        <div class="card_box">
            <div class="card mw-270">
                <div class="card-body">
                    <div>
                        <img src="/imagens/draw_office.svg"  width="220px" height="201px" alt="..."/>
                    </div>
                    <p class="linha_2">
                        Efectue aqui o check-in do utente
                    </p>
                    <form action="/receptionist/checkinbyAppointmentId" method="post">
                        <button type="submit" class="btn btn-blue">Check-in</button>
                    </form>
                </div>
                <div class="horizontal-border"></div>
            </div>
        </div>

        <div class="card_box">
            <div class="card mw-270">
                <div class="card-body">
                    <p class="utentes add-title">ADICIONAR</p>
                    <img src="/imagens/draw_new_entries.svg" class="add-img" alt="..."/>
                    <div class="add-pat">
                        <a class="btn btn-blue" href="/receptionist/add-user" type="submit">
                            Novo utilizador</a>
                        <p></p>
                        <a class="btn btn-blue" href="/receptionist/add-speciality"
                           type="submit">Nova especialidade
                        </a>
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