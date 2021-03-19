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
                <img src="/imagens/draw_wait-calendar.svg" alt="patientsPage" class="img-fill-form" />
                <h3 class="consultas_title">Em espera para consulta</h3>
            </div>

            <div class="row">
                <div class=search_options>
                    <form action="${userTypeURL}" method="post">
                        <div class="middle-row">
                            <div class="search-container">

                                <c:if test="${user_logged.getAccount().equals('Recepcionista')}">
                                    <input type="text" class="form-input sm" placeholder="Nome do Utente"
                                        name="patientName">
                                </c:if>

                                <select id="speciality_id" class="form-input sm" name="specialityName">
                                    <option value="" disabled selected>Especialidade</option>
                                    <!-- For -->
                                    <c:forEach var="speciality" items="${specialities}">
                                        <option value="${speciality.getName()}">${speciality.getName()}</option>
                                    </c:forEach>
                                </select>
                                <input type="text" class="form-input sm" placeholder="Nome do Médico" name="doctorName">

                                <button class="btn-search2" type="submit">Pesquisar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <div class="row">

                <section class="content-area middle-row">
                    <table class="table">

                        <thead>
                            <tr class="appointment-table-title">
                                <th>Posição na Lista</th>
                                <th>Data do Pedido</th>
                                <c:if test="${user_logged.getAccount().equals('Recepcionista')}">
                                    <th>Utente</th>
                                </c:if>
                                <th>Especialidade</th>
                                <th>Médico</th>
                                <th><i class="fas fa-ellipsis-h"></i></th>
                            </tr>
                        </thead>
                        <tbody>

                            <!-- For -->
                            <c:forEach var="patientWaitingAppointment" items="${patientWaitingAppointments}">
                                <tr class="appointment-table-details">
                                    <td>${patientWaitingAppointment.getPosition()}</td>

                                    <td>${patientWaitingAppointment.getDateTimeStr()}</td>

                                    <c:if test="${user_logged.getAccount().equals('Recepcionista')}">
                                        <td>${patientWaitingAppointment.getPatient().getFirstAndLastName()}</td>
                                    </c:if>
                                    <td>${patientWaitingAppointment.getDoctor().getSpeciality().getName()}</td>
                                    <td> ${patientWaitingAppointment.getDoctor().getFirstAndLastName()}</td>

                                    <c:if test="${user_logged.getAccount().equals('Utente')}">
                                    <td><a href="/patient/waitingAppointment/${patientWaitingAppointment.getPatientWaitingAppointmentId()}/cancel">Cancelar</a></td>
                                    </c:if>
                                    <c:if test="${user_logged.getAccount().equals('Recepcionista')}">
                                    <td><a href="/receptionist/make-extraAppointment/${patientWaitingAppointment.getPatient().getUserId()}/${patientWaitingAppointment.getPatientWaitingAppointmentId()}">Atribuir Vaga</a></td>
                                    </c:if>
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