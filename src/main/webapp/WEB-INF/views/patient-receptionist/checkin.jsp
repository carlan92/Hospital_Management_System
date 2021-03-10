<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <%@ include file="../components/head.jsp" %>
    </head>

    <body>

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
                    <img src="/imagens/draw_checking.svg" alt="patientsPage" class="img-fill-form" />
                    <h3 class="consultas_title">Check in</h3>
                </div>

                <div class="row">
                <c:if test="user_logged.getAccount().equals('Recepcionista')}">
                    <div class=search_options>
                        <form action="${userTypeURL}" method="post">
                            <div class="middle-row">
                                <div class="search-container">



                                        <input type="text" class="form-input sm" placeholder="Nome do Utente"
                                            name="patientName">


                                        <select id="speciality_id" class="form-input sm" name="specialityName">
                                            <option value="" disabled selected>Especialidade</option>
                                            <!-- For -->
                                            <c:forEach var="speciality" items="${specialities}">
                                                <option value="${speciality.getName()}">${speciality.getName()}</option>
                                            </c:forEach>
                                        </select>
                                        <input type="text" class="form-input sm" placeholder="Nome do Médico"
                                            name="doctorName">


                                    <button class="btn-search2" type="submit">Pesquisar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    </c:if>
                </div>


                <div class="row">

                    <section class="content-area middle-row">
                        <table class="table">

                            <thead>
                                <tr>
                                    <th>Data</th>
                                    <th>Hora</th>
                                    <c:if test="${user_logged.getAccount().equals('Recepcionista')}">
                                        <th>Utente</th>
                                    </c:if>
                                    <th>Especialidade</th>
                                    <th>Médico</th>
                                    <th>Check in</th>
                                </tr>
                            </thead>
                            <tbody>

                                <!-- For -->
                                <c:forEach var="appointment" items="${appointments}">
                                    <tr>
                                        <td>${appointment.getSlot().getDateStr()}</td>
                                        <td>${appointment.getSlot().getTimeBegin()}</td>
                                        <c:if test="${user_logged.getAccount().equals('Recepcionista')}">
                                            <td>${appointment.getPatient().getName()}</td>
                                        </c:if>

                                        <td>${appointment.getSlot().getDoctor().getSpeciality().getName()}</td>
                                        <td>${appointment.getSlot().getDoctor().getTitleAndName()}</td>


                                        <td>
                                            <c:choose>
                                                <c:when test="${!appointment.getHasChecked()}">
                                                    <a href=${String.format(checkInLink, appointment.getAppointmentId())}>Check in</a>
                                                </c:when>
                                                <c:otherwise>
                                                    Feito
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
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