<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="components/head.jsp" %>
</head>

<body>
<%@ include file="components/sidenav-main.jsp" %>

    <div class="main">
        <div class="white_box box-align-left">

            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="perfil-row">
                        <img src="imagens/draw_text_field.svg" alt="fill form" class="img-fill-form" />
                    </div>

                    <div class="perfil-row">
                        <h3 class="registo">Página de testes</h3>
                    </div>
                </div>
            </div>

            <div class="perfil-main-col">
                <h4> Utente: </h4>
                <div class="perfil-row">
                    <div class="cell-row">
                        <a href="patient-inicio" class="btn btn-green">Início</a>
                    </div>

                    <div class="cell-row">
                        <a href="lista_medicos_doctor_patient" class="btn btn-blue">Médicos</a>
                    </div>

                    <div class="cell-row">
                        <a href="consultas_patient" class="btn btn-green">Consultas</a>
                    </div>

                    <div class="cell-row">
                        <a href="make-appointment" class="btn btn-blue">Marcar Consulta</a>
                    </div>


                </div>
            </div>

            <div class="perfil-main-col">
                <h4> Recepcionista: </h4>
                <div class="perfil-row">

                    <div class="cell-row">
                        <a href="main" class="btn btn-blue">Inicio</a>
                    </div>

                    <div class="cell-row">
                        <a href="lista_utentes_recep" class="btn btn-green">Utentes</a>
                    </div>

                    <div class="cell-row">
                        <a href="lista_medicos_recep" class="btn btn-blue">Médicos</a>
                    </div>

                    <div class="cell-row">
                        <a href="consultas_recep" class="btn btn-green">Consultas</a>
                    </div>

                    <div class="cell-row">
                        <a href="add-patient" class="btn btn-blue">Adicionar Utente</a>
                    </div>

                    <div class="cell-row">
                        <a href="add-doctor" class="btn btn-blue">Adicionar Médico</a>
                    </div>

                    <div class="cell-row">
                        <a href="add-speciality" class="btn btn-green">Criar Especialidade</a>
                    </div>

                    <div class="cell-row">
                        <a href="lista_espera_recep" class="btn btn-blue">Lista Espera</a>
                    </div>

                </div>
            </div>

            <div class="perfil-main-col">
                <h4> Médico: </h4>
                <div class="perfil-row">

                    <div class="cell-row">
                        <a href="doctor-inicio" class="btn btn-green">Inicio</a>
                    </div>

                    <div class="cell-row">
                        <a href="lista_utentes_doctor" class="btn btn-blue">Utentes</a>
                    </div>

                    <div class="cell-row">
                        <a href="lista_medicos_doctor_patient" class="btn btn-green">Médicos</a>
                    </div>

                    <div class="cell-row">
                        <a href="consultas_doctor" class="btn btn-blue">Consultas</a>
                    </div>

                    <div class="cell-row">
                        <a href="info-appointment" class="btn btn-green">Registo Consulta</a>
                    </div>

                    <div class="cell-row">
                        <a href="lista_espera_doctor" class="btn btn-blue">Lista Espera</a>
                    </div>

                </div>
            </div>

            <div class="perfil-main-col">
                    <h4> Geral: </h4>
                <div class="perfil-row">
                    <div class="cell-row">
                        <a href="historicoPagamentos" class="btn btn-green">Histórico de Pagamentos</a>
                    </div>

                    <div class="cell-row">
                        <a href="faturaForm" class="btn btn-blue">Fatura</a>
                    </div>
                </div>
            </div>






        </div>
    </div>

</body>

</html>