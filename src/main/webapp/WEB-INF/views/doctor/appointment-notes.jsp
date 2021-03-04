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
                <div class="cell-row">Ana Antunes Pereira</div>
            </div>
            <div class="perfil-row">
                <div class="cell-row">Data de nascimento</div>
                <div class="cell-row">01/01/1990</div>
            </div>
            <div class="perfil-row">
                <div class="cell-row">Telemóvel</div>
                <div class="cell-row">915 452 657</div>
            </div>

            <div class="info_appt">
                <div class="perfil-row">
                    <div class="cell-row">Data da consulta</div>
                    <div class="cell-row">20/02/2021</div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">Hora da consulta</div>
                    <div class="cell-row">10:00</div>
                </div>

                <div class="perfil-row">
                    <p class="cell-row status">Primeira Consulta: SIM </p>
                </div>

                <div class="perfil-row">
                    <p class="cell-row status">Estado da Consulta: CONFIRMADA </p>
                </div>

            </div>


            <form action="/action_page.php">
                <h3>Notas:</h3>
                <textarea name="message" class="perfil-row" rows=10 ></textarea>
            </form>

            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="cell-row">
                        <a href="patient/main" class="btn btn-green">Voltar atrás</a>
                    </div>

                    <div class="cell-row">
                        <a href="" class="btn btn-blue">Guardar</a>
                    </div>
                </div>
            </div>

        </div>


    </div>

</div>
</body>
</html>