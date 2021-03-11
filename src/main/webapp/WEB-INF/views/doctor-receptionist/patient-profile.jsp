<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

    <div class="white_box box-align-left">
            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="cell-row cell-align-center">
                        <div class="user-type">
                            <p id="user_name">${patient.getFirstAndLastName()}</p>
                            <p id="user_category">${patient.getAccount()}</p>
                        </div>
                    </div>

                    <div class="cell-row">
                        <div class="user_photo">
                            <img src="/uploaded_images/${patient.getPhotoURL()}" alt="foto do utilizador"/>
                        </div>
                    </div>
                </div>
            </div>


            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="cell-row">Nome Completo</div>
                    <div class="cell-row">${patient.getName()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Sexo</div>
                    <div class="cell-row">${patient.getSex()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Data de nascimento</div>
                    <div class="cell-row">
                        <fmt:formatDate pattern="dd/MM/yyyy" value="${patient.getBirthday()}"/>
                    </div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Morada</div>
                    <div class="cell-row">${patient.getAddress()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Código Postal</div>
                    <div class="cell-row">${patient.getPostCode()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Localidade</div>
                    <div class="cell-row">${patient.getCity()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Nacionalidade</div>
                    <div class="cell-row">${patient.getNationality()}</div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">Documento de identificação</div>
                    <div class="cell-row">${patient.getDocumentType()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Nº do documento</div>
                    <div class="cell-row">${patient.getDocumentNumber()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">NIF</div>
                    <div class="cell-row">${patient.getNif()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Nº de Utente</div>
                    <div class="cell-row"> ${patient.getPatientNumber()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Telemóvel</div>
                    <div class="cell-row">${patient.getPhone()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">E-mail</div>
                    <div class="cell-row">${patient.getEmail()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">
                        <a href="/doctor-receptionist/patient-list " class="btn-blue btn-w65">Voltar atrás</a>
                    </div>
                    <div class="cell-row">
                        <form action="/userToMain" method="get">
                            <button class="btn-green btn-w65">Página Principal</button>
                        </form>
                    </div>
                </div>
            </div>
    </div>
</div>
</body>

</html>