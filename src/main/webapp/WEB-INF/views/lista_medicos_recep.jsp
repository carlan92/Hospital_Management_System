<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="components/head.jsp" %>

</head>

<body>
<%@ include file="components/sidenav-main.jsp" %>


<div class="main">
    <!--menu da direita-->

    <div class="white_box2 box-align-left">

        <div class="perfil-row">

            <img src="imagens/draw_patient.svg" alt="doctorsPage" class="img-fill-form"/>
            <h3 class="utente_title">Lista de Médicos</h3>
            <div class="search_patient search_doc">
                <div class="add-pat">
                    <a class="btn btn-outline-secondary btn-add" href="add-doctor" type="submit">Adicionar novo médico</a>
                </div>

                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Nome do médico"
                           aria-label="Search">
                    <button class="btn-search" type="submit">Pesquisar</button>
                </form>
                <div class="choose_spec">
                    <select id="speciality_id" class="form-control" name="speciality">
                        <option value="" disabled selected>Pesquisar por Especialidade</option>
                        <!-- For -->
                        <c:forEach var="speciality" items="${specialities}">
                            <option value="${speciality}.getName()">${speciality.getName()}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="add-pat">
                    <a class="btn btn-outline-secondary btn-add" href="add-speciality" type="submit">Adicionar nova especialidade
                    </a>
                </div>
            </div>
        </div>


        <div class="row">
            <!-- For -->
            <c:forEach var="doctor" items="${doctors}">

                <div class="card_list_doctor patient_data">
                    <div class="user_photo w-50">
                        <img src="uploaded_images/${doctor.getPhotoURL()}" alt="avatar">
                    </div>
                    <h1 class="patient_name">${doctor.getFirstAndLastName()}</h1>
                    <p class="spec_title">Especialidade:</p>
                    <!-- CORRIGI JA NAO É LISTA É APENAS 1 ESPECIALIDADE -->
                    <p class="spec_name">${doctor.getSpecialities()} </p>
                    <p>
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