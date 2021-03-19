<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <%@ include file="../components/sidenav-receptionist.jsp" %>
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


            <form class="registration-form"
                action="/receptionist/make-extraAppointment/${userIdStr}/${patientWaitingAppointmentId}"
                name="appointmentForm" method="post">
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
                            <select id="medico_id" class="form-input" name="doctorId" onchange="updateForm()">
                                <option value="" disabled <c:if test="${empty search_doctor}">
                                    selected
                                    </c:if>>
                                    Escolha o médico pretendido
                                </option>

                                <c:forEach var="doctor" items="${doctors}">
                                    <option value="${doctor.getUserId()}" <c:if
                                        test="${search_doctor.equals(doctor.getUserId().toString())}">
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
                                    <div class="day perfil-row">

                                        <div class="month">
                                            <input type="radio" class="month-arrow" name="arrowMonth"
                                                value="${previousMonth}" id="arrow_PrevMonth" onchange="updateForm()"
                                                <c:if test="${previousArrowState == 0}">
                                            disabled=""
                                            </c:if>>
                                            <label for="arrow_PrevMonth" class="">
                                                <i class="fas fa-less-than month-before"></i>
                                            </label>
                                        </div>

                                        ${strMonth} ${year}

                                        <div class="month">
                                            <input type="radio" class="month-arrow" name="arrowMonth"
                                                value="${nextMonth}" id="arrow_NextMonth" onchange="updateForm()" <c:if
                                                test="${nextArrowState == 0}">
                                            disabled=""
                                            </c:if>>
                                            <label for="arrow_NextMonth" class="">
                                                <i class="fas fa-greater-than month-after"></i>
                                            </label>
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
                                                <input type="radio" class="botao cal_${day.getColor()}" name="chosenDay"
                                                    value="${day.getDateStr()}" id="day_${day.getDayId()}"
                                                    onchange="updateForm()" <c:if
                                                    test="${empty day.getDayNumber() || day.getDayNumber() < dayOfToday}">
                                                disabled=""
                                                </c:if>
                                                <c:if test="${day.getDateStr().equals(chosenDay)}">
                                                    checked
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

                            <c:if test="${(hasSlotForDoctorDate==true) and (hasSlotForDoctor==true)}">
                                <label for="hora_id">Hora</label>
                                <select id="hora_id" type="text" class="form-input" name="slotId">
                                    <option value="" disabled selected>Escolha a hora pretendida</option>
                                    <c:forEach var="slot" items="${slots}">
                                        <option value="${slot.getSlotId()}">${slot.getTimeBegin()}</option>
                                    </c:forEach>
                                </select>
                                <p class="msg-error">${errorMsgHora}</p>
                                <br />
                                <button type="submit" class="btn btn-green"
                                    formaction="/receptionist/make-extraAppointment/${userIdStr}/${patientWaitingAppointmentId}/save">Marcar
                                    Consulta</button>
                            </c:if>

                            <c:if test="${(hasSlotForDoctorDate==false) and (hasSelectDoctor==true)}">
                                <label for="timeSlot_id">Criar Vaga Extra</label>
                                <div class="perfil-row">
                                    <div class="cell-row">
                                        <input id="timeBegin_id" type="time" class="form-input"
                                            value="${slot.getTimeBegin()}" name="timeBegin" required />
                                    </div>
                                    <div class="cell-row">
                                        <input id="timeEnd_id" type="time" class="form-input"
                                            value="${slot.getTimeEnd()}" name="timeEnd" required />
                                    </div>
                                </div>
                                <p class="msg-error">${errorMsgSlot}</p>
                                <button type="submit" class="btn btn-blue"
                                    formaction="/receptionist/make-extraAppointment/${userIdStr}/${patientWaitingAppointmentId}/extra">Marcar
                                    Consulta em Vaga Extra</button>
                            </c:if>

                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>

</body>

</html>