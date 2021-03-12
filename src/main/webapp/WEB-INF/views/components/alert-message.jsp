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
    <div class="white_box3 box-align-left">
        <div class="perfil-main-col">
            <div class="perfil-row">
                <div class="perfil-row">
                    <img src="${imageURL}" alt="fill form" class="img-fill-form"/>
                    <h3 class="title_next_appt">${message}</h3>
                </div>
            </div>
        </div>


        <div class="perfil-row">
            <div class="cell-back">
                <a href="/" class="btn btn-outline-dark btn-back">Regressar à página inicial</a>
            </div>
        </div>

    </div>


</div>
</body>
</html>