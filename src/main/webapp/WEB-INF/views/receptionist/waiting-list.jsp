<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body>
<%@ include file="../components/sidenav-receptionist.jsp" %>

<div class="main">
    <!--menu da direita-->
    <div class="white_box2 box-align-left">

        <div class="perfil-row">
            <img src="/imagens/waiting.svg" alt="patientsPage" class="img-fill-form"/>
            <h3 class="consultas_title">Lista de espera para consulta </h3>
        </div>

        <div class="row">
            <section class="content-area middle-row">
                <table class="table">
                    <thead>
                    <tr>
                        <th>Data</th>
                        <th>Hora</th>
                        <th>Utente</th>
                        <th>Especialidade</th>
                        <th>Médico</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="appointment" items="${appointments}">
                        <tr class="appointment-table-details">
                            <td>${appointment.getSlot().getDateStr()}</td>
                            <td>${appointment.getSlot().getTimeBegin()}</td>
                            <td>${appointment.getPatient().getName()}</td>
                            <td>${appointment.getSlot().getDoctor().getSpeciality().getName()}</td>
                            <td>${appointment.getSlot().getDoctor().getTitleAndName()}</td>
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