<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>

</head>

<body>
<c:if test="${user_logged.getAccount().equals('Médico')}">
    <%@ include file="../components/sidenav-medico.jsp" %>
</c:if>
<c:if test="${user_logged.getAccount().equals('Recepcionista')}">
    <%@ include file="../components/sidenav-receptionist.jsp" %>
</c:if>
<c:if test="${user_logged.getAccount().equals('Utente')}">
    <%@ include file="../components/sidenav-utente.jsp" %>
</c:if>

<div class="main">
    <!--menu da direita-->
    <div class="white_box box-align-left">
        <div class="perfil-main-col">
            <div class="perfil-row">
                <div class="perfil-row">
                    <img src="/imagens/draw_information_appt.svg" alt="fill form" class="img-fill-form"/>
                    <h3 class="title_next_appt">Consulta</h3>
                </div>
            </div>
        </div>

        <!-- For -->
        <div class="perfil-main-col">
            <div class="perfil-row">
                <div class="cell-row">Data:</div>
                <div class="cell-row">${appointment.getSlot().getDateStr()}</div>
            </div>
            <div class="perfil-row">
                <div class="cell-row">Hora:</div>
                <div class="cell-row">${appointment.getSlot().getTimeBegin()}</div>
            </div>
            <div class="perfil-row">
                <div class="cell-row">Utente:</div>
                <div class="cell-row">${appointment.getPatient().getName()}</div>
            </div>
            <div class="perfil-row">
                <div class="cell-row">Especialidade:</div>
                <div class="cell-row">${appointment.getSlot().getDoctor().getSpeciality().getName()}</div>
            </div>
            <div class="perfil-row">
                <div class="cell-row">Médico:</div>
                <div class="cell-row">${appointment.getSlot().getDoctor().getTitleAndName()}</div>
            </div>


            <c:if test="${user_logged.getAccount().equals('Utente') ||  user_logged.getAccount().equals('Recepcionista')}">
                <div class="perfil-row">
                    <div class="cell-row">Estado da facturação:<span class="cell-row"> Paga</span></div>

                    <div class="cell-row">
                        <a class="cell-row">Ver Fatura</a>
                    </div>
                </div>
            </c:if>

            <div class="info_appt">
                <div class="perfil-row">
                    <p class="cell-row">Estado da
                        Consulta: ${appointmentDescription}</p>
                </div>

                <c:if test="${user_logged.getAccount().equals('Médico')}">
                    <form action="/action_page.php">
                        <h3>Notas:</h3>
                        <p class="text-black-50"> Dores nas costas, possível lesão devido a má postura a trabalhar
                            ao
                            computador</p>
                    </form>
                </c:if>
            </div>


            <div class="perfil-main-col">
                <c:if test="${appointment.getAppointmentStatus()==1}">
                <div class="perfil-row">
                    <c:if test="${user_logged.getAccount().equals('Utente') ||  user_logged.getAccount().equals('Médico')}">

                        <div class="cell-row">
                            <a href="/${userType}/appointment-details/${tempo}/${appointmentId}/cancel"
                               class="btn btn-green">Cancelar Consulta</a>
                        </div>
                    </c:if>
                    <c:if test="${user_logged.getAccount().equals('Utente')}">
                        <div class="cell-row">
                            <a href="/patient/reschedule/${appointmentId}" class="btn btn-blue">Reagendar Consulta</a>
                        </div>
                    </c:if>
                </div>
                </c:if>
                <div class="perfil-row">
                    <div class="cell-back">
                        <a href="/${userType}/appointment-list/${tempo}" class="btn btn-outline-dark btn-back">Voltar
                            atrás</a>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>