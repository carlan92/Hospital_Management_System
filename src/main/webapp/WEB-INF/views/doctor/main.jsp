<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body onload="startTime() ; currentDate()">
<%@ include file="../components/sidenav-medico.jsp" %>


<div class="main">
    <!--menu da direita-->
    <div class="row first_row">
        <div class="col-4">
            <img src="/imagens/draw_doctor.svg" alt="doctor" class="icon1"/>
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

    <div class="row middle-row3">

        <div class="col-3">
            <div class="card_box2">
                <div class="card2">
                    <div class="card-body2">
                        <h2>
                            <span>${pacientes_agendados}</span>
                        </h2>
                        <h3>Pacientes agendados</h3>
                        <i class="far fa-calendar-alt "></i>
                    </div>
                </div>
            </div>
        </div>


        <div class="col-3">
            <div class="card_box2">
                <div class="card2">
                    <div class="card-body2">
                        <h2>
                            <span>${pacientes_confirmados}</span>
                        </h2>
                        <h3>Pacientes confirmados</h3>
                        <i class="fas fa-calendar-check "></i>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-3">
            <div class="card_box2">
                <div class="card2">
                    <div class="card-body2">
                        <h2>
                            <span>${pacientes_atendidos}</span>
                        </h2>
                        <h3>Pacientes atendidos
                            <i class="fas fa-user-check "></i>

                        </h3>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-3">
            <div class="card_box2">
                <div class="card2">
                    <div class="card-body2">
                        <h2>
                            <span>${pacientes_faltaram}</span>
                        </h2>
                        <h3>Pacientes que faltaram
                        </h3>
                        <i class="fas fa-calendar-times "></i>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Consulta em curso (begin) -->
    <!-- For -->
    <c:forEach var="appointment" items="${todayOngoingAppointments}">
        <div class="row middle-row">
            <div class="col-7 data_appt">
                <div class="row">
                    <div class="col-2 icon3">
                        <i class="fas fa-stethoscope"></i>
                    </div>
                    <div class="col-8 title_next_appt">
                        <span class="text_next_appt">Consulta a decorrer</span>
                        <p class="text_next_appt2">Ainda não tem consultas a decorrer ou apresentar info:</p>
                    </div>
                </div>

                <div class="row">
                    <div class="col-5 next_appt_time time_box2">
                        <span class="time_box2"><i
                                class="fas fa-clock clocktime"></i>${appointment.getSlot().getTimeBeginStr()}</span>
                    </div>

                    <div class="col-7">
                        <div class="perfil-row">
                            <div class="col user_photo">
                                <img src="/uploaded_images/${appointment.getPatient().getPhotoURL()}" alt="utente"/>
                            </div>
                            <div class="col user_info">
                                <span class="patient_name">${appointment.getPatient().getFirstAndLastName()}</span>
                                <br/>
                                <span class="patient_age">${appointment.getPatient().getAge()} anos</span>
                                <br/>
                                <span class="first_appt_ask">Primeira Consulta:
                                    <span>${isFirstAppointmentOngoingMap.get(appointment.getPatient().getUserId())}</span>
                                </span>
                            </div>
                        </div>

                        <div class="row">
                            <a href="/doctor-receptionist/patient-profile/${appointment.getPatient().getUserId()}" class="btn-blue btn-w85">Ver Perfil</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-4 appt_options">
                <div>
                    <div class="but-cancel_appt">
                        <a type="button" href="/doctor/appointment-notes" class="btn-green btn-w75">Registo da
                            consulta!!!!</a>
                    </div>
                    <div class="but-end_appt">
                        <a href="/doctor/appointment/end/${appointment.getAppointmentId()}" class="btn-green btn-w75">Terminar consulta</a>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
    <!-- Consulta em curso (end) -->

    <!-- Próxima Consulta (begin) -->
    <!-- For -->
    <c:forEach var="appointment" items="${todayCheckedInAppointments}">
        <div class="row middle-row">

            <div class="col-7 data_appt">
                <div class="row">

                    <div class="col-2 icon3">
                        <i class="fas fa-stethoscope"></i>
                    </div>

                    <div class="col-8 title_next_appt">
                        <span class="text_next_appt">Próxima consulta</span>
                        <p class="text_next_appt2">Consulte a sua próxima consulta e paciente</p>
                    </div>
                </div>

                <div class="row">

                    <div class="col-5 next_appt_time">
                        <span class="time_box2">${appointment.getSlot().getTimeBeginStr()}</span>
                    </div>

                    <div class="col-7">
                        <div class="perfil-row">
                            <div class="col user_photo">
                                <img src="/uploaded_images/${appointment.getPatient().getPhotoURL()}" alt="utente"/>
                            </div>
                            <div class="col user_info">
                                <span class="patient_name">${appointment.getPatient().getFirstAndLastName()}</span>
                                <br/>
                                <span class="patient_age">${appointment.getPatient().getAge()} anos</span>
                                <br/>
                                <span class="first_appt_ask">Primeira Consulta:
                                    <span>${isFirstAppointmentCheckedIntMap.get(appointment.getPatient().getUserId())}</span>
                                </span>
                            </div>
                        </div>

                        <div class="row">
                            <a href="/doctor-receptionist/patient-profile/${appointment.getPatient().getUserId()}"
                               class="btn-blue btn-w85">Ver Perfil</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-4 appt_options">
                <div>
                    <div class="but-begin_appt">
                        <button type="button" class="btn-green btn-w75">Chamar utente!!!</button>
                    </div>
                    <div class="but-begin_appt">
                        <a href="/doctor/appointment/start/${appointment.getAppointmentId()}" class="btn-green btn-w75">
                            Iniciar consulta</a>
                    </div>
                    <div class="but-cancel_appt">
                        <button type="button" class="btn-green btn-w75"> Cancelar consulta!!!</button>
                    </div>
                    <div class="but-end_appt">
                        <button type="button" class="btn-green btn-w75"> Registar falta de comparência!!!</button>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
    <!-- Próxima Consulta (end) -->


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