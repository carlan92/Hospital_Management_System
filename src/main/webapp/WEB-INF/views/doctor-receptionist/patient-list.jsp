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

<div class="main">
    <!--menu da direita Página Lista de todos os utentes existentes para o Recepcionista-->

    <div class="white_box2 box-align-left">

        <div class="perfil-row">

            <img src="/imagens/draw_patient.svg" alt="patientsPage" class="img-fill-form"/>
            <h3 class="utente_title">Lista de Utentes</h3>

            <form action="/search-patients" method="post" class="form-inline">
                <div class=search_patient>
                    <input class="form-control mr-sm-2" value="${search_name}" name="name" type="search"
                           placeholder="Nome do utente" aria-label="Search">
                    <button class="btn-search" type="submit">Pesquisar</button>
                </div>
            </form>
        </div>

        <div class="row">
            <!-- For -->
            <c:forEach var="patient" items="${patients}">

                <div class="card_list_patient patient_data">
                    <div class="user_photo w-50">
                        <img src="/uploaded_images/${patient.getPhotoURL()}"
                             alt="Foto de ${patient.getFirstAndLastName()}">
                    </div>
                    <h1 class="patient_name">${patient.getFirstAndLastName()}</h1>
                    <i class="fas fa-birthday-cake ">
                        <span class="patient_birthday">${patient.getBirthdayStr()}</span>
                    </i>
                    <i class="fas fa-phone-square">
                        <span class="patient_age">${patient.getPhone()}</span>
                    </i>
                    <button type="button" class="btn-blue btn-w80"> Consultar Perfil</button>
                </div>

            </c:forEach>
        </div>
    </div>
</div>
</body>

</html>