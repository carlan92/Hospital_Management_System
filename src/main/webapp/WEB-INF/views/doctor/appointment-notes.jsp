<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body>
<%@ include file="../components/sidenav-medico.jsp" %>


<div class="main">
    <!--menu da direita-->
    <div class="white_box box-align-left">
        <div class="perfil-main-col">
            <div class="perfil-row">
                <div class="perfil-row">
                    <img src="/imagens/draw_information.svg" alt="fill form" class="img-fill-form" />
                </div>

                <div class="perfil-row">
                    <h3 class="registo">Registo Consulta</h3>
                </div>
            </div>
        </div>





        <div class="perfil-main-col">
            <div class="perfil-row">
                <div class="cell-row">Nome do Utente</div>
                <div class="cell-row">${appointment.getPatient().getName()}</div>
            </div>
            <div class="perfil-row">
                <div class="cell-row">Data de nascimento</div>
                <div class="cell-row">${appointment.getPatient().getBirthdayStr()}</div>
            </div>
            <div class="perfil-row">
                <div class="cell-row">Telemóvel</div>
                <div class="cell-row">${appointment.getPatient().getPhoneStr()}</div>
            </div>

            <div class="info_appt">
                <div class="perfil-row">
                    <div class="cell-row">Data da consulta</div>
                    <div class="cell-row">${appointment.getSlot().getDateStr()}</div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">Hora da consulta</div>
                    <div class="cell-row">${appointment.getSlot().getTimeBeginStr()}</div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">Primeira Consulta:</div>
                    <p class="cell-row status">${isFirstAppointmentStr}</p>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">Estado da Consulta:</div>
                    <p class="cell-row status">${appointmentState}</p>
                </div>

            </div>


            <form action="/doctor/appointment/notes/${appointment.getAppointmentId()}" method="post">
                <h3>Notas:</h3>
                <textarea name="message" class="perfil-row" rows=10 >${appointment.getNotes()}</textarea>

                <div class="perfil-main-col">
                    <div class="perfil-row">
                        <div class="cell-row">
                            <a href="/doctor/main" class="btn btn-green">Voltar atrás</a>
                        </div>

                        <div class="cell-row">
                            <button type="submit" class="btn btn-blue">Guardar</button>
                        </div>
                    </div>
                </div>


            </form>



        </div>


    </div>

</div>
</body>
</html>