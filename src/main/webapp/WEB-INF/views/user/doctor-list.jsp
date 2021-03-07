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

    <div class="white_box2 box-align-left">

        <div class="perfil-row">

            <img src="/imagens/draw_patient.svg" alt="doctorsPage" class="img-fill-form"/>
            <h3 class="utente_title">Lista de Médicos</h3>

            <form action="/search-doctors" method="post" class="form-inline">
                <div class="search_patient search_doc">
                    <div class="add-pat">
                        <a class="btn btn-outline-secondary btn-add" href="/receptionist/add-doctor"
                           type="submit">Adicionar novo médico</a>
                    </div>


                    <input class="form-control mr-sm-2" value="${search_name}" name="name" type="search"
                           placeholder="Nome do médico" aria-label="Search">
                    <button class="btn-search" type="submit">Pesquisar</button>

                    <div class="choose_spec">
                        <select id="speciality_id" class="form-control" name="speciality">
                            <option value="" <c:if test="${empty search_speciality}">
                                selected
                            </c:if>>
                                Especialidade (Todas)
                            </option>
                            <!-- For -->
                            <c:forEach var="speciality" items="${specialities}">
                                <option value="${speciality.getName()}" <c:if
                                        test="${search_speciality.equals(speciality.getName())}">
                                    selected
                                </c:if>>
                                        ${speciality.getName()}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </form>


            <div class="add-pat">
                <a class="btn btn-outline-secondary btn-add" href="/receptionist/add-speciality"
                   type="submit">Adicionar nova especialidade
                </a>
            </div>
        </div>
    </div>


    <div class="row">
        <!-- For -->
        <c:forEach var="doctor" items="${doctors}">

            <div class="card_list_doctor patient_data">
                <div class="user_photo w-50">
                    <img src="/uploaded_images/${doctor.getPhotoURL()}" alt="avatar">
                </div>
                <h1 class="patient_name">${doctor.getFirstAndLastName()}</h1>
                <p class="spec_title">Especialidade:</p>
                <p class="spec_name">${doctor.getSpeciality().getName()} </p>
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