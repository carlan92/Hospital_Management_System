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
                <div class="perfil-row">
                    <div class="cell-row">
                        <a href="make-appointment" class="btn btn-green">Marcar Consulta</a>
                    </div>

                    <div class="cell-row">
                        <a href="add-speciality" class="btn btn-blue">Criar Especialidade</a>
                    </div>
                </div>
            </div>

            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="cell-row">
                        <a href="doctor-inicio" class="btn btn-green">Médico-Início</a>
                    </div>

                    <div class="cell-row">
                        <a href="lista-utentes" class="btn btn-blue">Médico-utentes</a>
                    </div>
                </div>
            </div>

            <div class="perfil-main-col">
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