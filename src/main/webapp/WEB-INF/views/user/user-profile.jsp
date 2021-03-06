<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body>
    <c:choose>
        <c:when test="${user_logged.getAccount().equals('Utente')}">
            <%@ include file="../components/sidenav-utente.jsp" %>
        </c:when>
        <c:when test="${user_logged.getAccount().equals('Recepcionista')}">
            <%@ include file="../components/sidenav-receptionist.jsp" %>
        </c:when>
        <c:when test="${user_logged.getAccount().equals('Médico')}">
            <%@ include file="../components/sidenav-medico.jsp" %>
        </c:when>
        <c:otherwise>
            <%@ include file="../components/sidenav-login.jsp" %>
        </c:otherwise>
    </c:choose>

<div class="main">
    <div class="white_box box-align-left">


        <div class="perfil-main-col">
            <div class="perfil-row">
                <div class="cell-row cell-align-center">
                    <div class="user-type">
                        <p id="user_name">${user_logged.getFirstAndLastName()}</p>
                        <p id="user_category">${user_logged.getAccount()}</p>
                    </div>
                </div>

                <div class="cell-row">
                    <div class="user_photo">
                        <img src="/uploaded_images/${user_logged.getPhotoURL()}" alt="foto do utilizador"/>
                    </div>
                </div>
            </div>


            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="cell-row">Nome Completo</div>
                    <div class="cell-row">${user_logged.getName()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Sexo</div>
                    <div class="cell-row">${user_logged.getSex()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Data de nascimento</div>
                    <div class="cell-row"><fmt:formatDate pattern="dd/MM/yyyy"
                                                          value="${user_logged.getBirthday()}"/></div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">Morada</div>
                    <div class="cell-row">${user_logged.getAddress()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Código Postal</div>
                    <div class="cell-row">${user_logged.getPostCode()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Localidade</div>
                    <div class="cell-row">${user_logged.getCity()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Nacionalidade</div>
                    <div class="cell-row">${user_logged.getNationality()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Documento de identificação</div>
                    <div class="cell-row">${user_logged.getDocumentType()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Nº do documento</div>
                    <div class="cell-row">${user_logged.getDocumentNumber()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">NIF</div>
                    <div class="cell-row">${user_logged.getNif()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Nº de Utente</div>
                    <div class="cell-row"> ${user_logged.getPatientNumber()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Telemóvel</div>
                    <div class="cell-row">${user_logged.getPhone()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">E-mail</div>
                    <div class="cell-row">${user_logged.getEmail()}</div>
                </div>

                <div class="perfil-row"><c:if test="${user_logged.getAccount().equals('Médico')}">
                    <div class="cell-row">Nº Cédula Profissional</div>
                    <div class="cell-row">${user_logged.getLicenseNumber()}</c:if>
                    </div>
                </div>
                <div class="perfil-row"><c:if test="${user_logged.getAccount().equals('Médico')}">
                    <div class="cell-row">Especialidade</div>
                    <div class="cell-row">${user_logged.getSpeciality().getName()}</c:if>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <form action="/user/change-profile-data" method="get">
                            <button class="btn-blue btn-w65">Alterar Registo</button>
                        </form>
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
</div>
</body>
</html>