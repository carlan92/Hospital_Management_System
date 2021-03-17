<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="refresh" content="8" />
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
            <img src="/imagens/draw_call-wait.svg" alt="patientsPage" class="img-fill-form"/>
            <h3 class="consultas_title">Lista de Chamada</h3>
        </div>

        <div class="row">
            <section class="content-area middle-row">
                <table class="table">
                    <thead>
                    <tr class="appointment-table-title">
                        <th>Hora</th>
                        <th>Utente</th>
                        <th>Especialidade</th>
                        <th>Médico</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- For -->
                    <c:forEach var="chamada" items="${listaChamada}">
                        <tr class="appointment-table-details">
                            <td>${chamada.getTimeLatestCallStr()}</td>
                            <td>${chamada.getAppointment().getPatient().getName()}</td>
                            <td>${chamada.getAppointment().getSlot().getDoctor().getSpeciality().getName()}</td>
                            <td>${chamada.getAppointment().getSlot().getDoctor().getTitleAndName()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </section>
        </div>
    </div>
</div>
</body>
</html>