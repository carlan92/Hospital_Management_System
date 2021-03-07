<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ include file="../components/head.jsp" %>
            <script type="text/javascript">
                function updateForm() {
                    document.appointmentForm.submit();
                }
            </script>
            <link rel="stylesheet" href="/stylecalendar.css" />
</head>

<body>
    <%@ include file="../components/sidenav-utente.jsp" %>
        <div class="main">
            <!--menu da direita-->
            <div class="white_box box-align-left">
                <div class="perfil-main-col">
                    <div class="perfil-row">
                        <div class="perfil-row">
                            <img src="/imagens/draw_medical_research.svg" alt="fill form" class="img-fill-form" />
                        </div>

                        <div class="perfil-row">
                            <h3 class="registo">Marcar Consulta</h3>
                        </div>
                    </div>
                </div>


                <form class="registration-form" action="/patient/make-appointment" name="appointmentForm" method="post">
                    <div class="perfil-main-col">

                        <div class="perfil-row">
                            <div class="cell-row cell-morada">
                                <label for="especialidade_id">Especialidade</label>
                                <select id="especialidade_id" class="form-input" name="specialityName" required
                                    onchange="updateForm()">
                                    <option value="" disabled <c:if test="${empty search_speciality}">
                                        selected
                                        </c:if>>
                                        Escolha a especialidade pretendida
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

                                <p class="msg-error">${errorMsgSpeciality}</p>
                            </div>



                        </div>

                        <div class="perfil-row">
                            <div class="cell-row cell-morada">
                                <label for="medico_id">Médico</label>
                                <select id="medico_id" class="form-input" name="doctorName" onchange="updateForm()">
                                    <option value="" disabled <c:if test="${empty search_doctor}">
                                        selected
                                        </c:if>>
                                        Escolha o médico pretendido
                                    </option>

                                    <c:forEach var="doctor" items="${doctors}">
                                        <option value="${doctor.getName()}" <c:if
                                            test="${search_doctor.equals(doctor.getName())}">
                                            selected
                                            </c:if>>
                                            ${doctor.getFirstAndLastName()}
                                        </option>
                                    </c:forEach>

                                </select>
                                <p class="msg-error">${errorMsgDoctor}</p>
                            </div>
                        </div>

                        <div class="perfil-row">
                            <div class="cell-row">

                                <div class="middle-me">
                                    <div class="calendar">
                                        <div class="day">
                                            <div class="full-day">
                                                <i class="fas fa-less-than month-before"></i> Março <i
                                                    class="fas fa-greater-than month-after"></i>
                                            </div>
                                            <div class="day-week">
                                                2021
                                            </div>
                                        </div>


                                        <div class="grid-days">
                                            <div class="day-cel header">S</div>
                                            <div class="day-cel header">T</div>
                                            <div class="day-cel header">Q</div>
                                            <div class="day-cel header">Q</div>
                                            <div class="day-cel header">S</div>
                                            <div class="day-cel header">S</div>
                                            <div class="day-cel header">D</div>




                                            <!-- For -->
                                            <c:forEach var="day" items="${calendarDays}">
                                                <div class="day-cel aday">
                                                    <input type="radio" class="botao" name="options"
                                                        id="day_${day.getDayId()}" <c:if
                                                        test="${empty day.getDayNumber()}">
                                                    disabled=""

                                                    </c:if>>
                                                    <label for="day_${day.getDayId()}"
                                                        class="">${day.getDayNumber()}</label>
                                                </div>

                                            </c:forEach>

















                                        </div>


                                    </div>
                                </div>



                                <p class="msg-error">${errorMsgDate}</p>
                            </div>

                            <div class="cell-row">
                                <label for="hora_id">Hora</label>
                                <select id="hora_id" type="text" class="form-input" name="hora">
                                    <option value="" disabled selected>Escolha a hora pretendida</option>
                                    <option value="1">09:30</option>
                                    <option value="2">10:30</option>
                                    <option value="3">11:00</option>
                                </select>
                                <p class="msg-error">${errorMsgHora}</p>
                                <br />
                                <button type="submit" class="btn btn-green">Marcar Consulta</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

        </div>

</body>

</html>