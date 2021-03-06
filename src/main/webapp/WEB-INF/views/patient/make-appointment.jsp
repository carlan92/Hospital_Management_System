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
                            <div class="cell-row cell-morada">
                                <label for="date_id">Data</label>
                                <input id="date_id" type="date" class="form-input" name="date" value="" />
                                <p class="msg-error">${errorMsgDate}</p>
                            </div>
                        </div>

                        <div class="perfil-row">
                            <div class="cell-row cell-morada">
                                <label for="hora_id">Hora</label>
                                <select id="hora_id" type="text" class="form-input" name="hora">
                                    <option value="" disabled selected>Escolha a hora pretendida</option>
                                    <option value="1">09:30</option>
                                    <option value="2">10:30</option>
                                    <option value="3">11:00</option>
                                </select>
                                <p class="msg-error">${errorMsgHora}</p>
                            </div>
                        </div>
                    </div>
                    <div class="perfil-row">
                        <div class="cell-row">
                            <button type="submit" class="btn btn-green">Marcar Consulta</button>
                        </div>
                        <div class="cell-row">
                            <button type="submit" class="btn btn-blue" formaction="/patient">Actualizar</button>
                        </div>
                    </div>
                </form>






            </div>

        </div>

</body>

</html>