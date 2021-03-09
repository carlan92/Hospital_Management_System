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
                    <img src="imagens/draw_information_appt.svg" alt="fill form" class="img-fill-form"/>
                    <h3 class="title_next_appt">Consulta</h3>
                </div>
            </div>
        </div>


        <div class="perfil-main-col">
            <div class="perfil-row">
                <div class="cell-row">Data:</div>
                <div class="cell-row">20-04-2021</div>
            </div>
            <div class="perfil-row">
                <div class="cell-row">Hora:</div>
                <div class="cell-row">11:00</div>
            </div>
            <div class="perfil-row">
                <div class="cell-row">Especialidade:</div>
                <div class="cell-row">Cardiologia</div>
            </div>
            <div class="perfil-row">
                <div class="cell-row">Médico:</div>
                <div class="cell-row">André Nogueira</div>
            </div>


            <div class="info_appt">
                <div class="perfil-row">
                    <p class="cell-row status">Estado da Consulta: MARCADA </p>
                </div>

            </div>


            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="cell-row">
                        <a href="" class="btn btn-green">Cancelar Consulta</a>
                    </div>

                    <div class="cell-row">
                        <a href="" class="btn btn-blue">Reagendar Consulta</a>
                    </div>
                </div>
                <div class="perfil-row">
                    <div class="cell-back">
                        <a href="" class="btn btn-outline-dark btn-back">Voltar atrás</a>
                    </div>
                </div>

            </div>


        </div>

    </div>
</div>

</body>
</html>