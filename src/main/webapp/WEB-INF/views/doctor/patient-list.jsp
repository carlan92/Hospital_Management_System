<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>

</head>

<body>
<%@ include file="../components/sidenav-medico.jsp" %>


<div class="main">
    <!--menu da direita Página Lista de todos os utentes existentes para o médico-->

    <div class="white_box2 box-align-left">

        <div class="perfil-row">

            <img src="imagens/draw_patient.svg" alt="patientsPage" class="img-fill-form"/>
            <h3 class="utente_title">Lista de Utentes</h3>
            <div class=search_patient>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Nome do utente"
                           aria-label="Search">
                    <button class="btn-search" type="submit">Pesquisar</button>
                </form>

            </div>
        </div>


        <div class="row">
            <!-- For -->
            <c:forEach var="patient" items="${patients}">

                <div class="card_list_patient patient_data">
                    <div class="user_photo w-50">
                        <img src="uploaded_images/${patient.getPhotoURL()}"
                             alt="Foto de ${patient.getFirstAndLastName()}">
                    </div>
                    <h1 class="patient_name">${patient.getFirstAndLastName()}</h1>
                    <i class="fas fa-birthday-cake ">
                        <span class="patient_birthday">${patient.getBirthdayStr()}</span></i>
                    <i class="fas fa-phone-square">
                        <span class="patient_age">${patient.getPhone()}</span></i>

                        <button type="button" class="btn-blue btn-w80"> Consultar Perfil
                        </button>
                    </p>
                </div>

            </c:forEach>

        </div>
    </div>

</div>
</body>

</html>