<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ include file="../components/head.jsp" %>
        <script type="text/javascript">
        function populate_doctor(speciality_id, doctor_id){
            var speciality_element = document.getElementById(speciality_id);
            var speciality_doctor = document.getElementById(doctor_id);

            speciality_doctor.innerHTML = "";
            
        }
        </script>
</head>

<body>
    <%@ include file="../components/sidenav-main.jsp" %>
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


                <form class="registration-form" action="/patient/make-appointment" method="post">
                    <div class="perfil-main-col">

                        <div class="perfil-row">
                            <div class="cell-row">
                                <label for="especialidade_id">Especialidade</label>
                                <select id="especialidade_id" class="form-input" name="name_speciality" onchange="populate_doctor('especialidade_id', 'medico_id')">
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
                            <div class="cell-row">
                                <button type="submit" class="btn btn-blue" formaction="/patient/make-appointment/update-doctor">Actualizar</button>
                            </div>


                        </div>

                        <div class="perfil-row">
                            <div class="cell-row cell-morada">
                                <label for="medico_id">Médico</label>
                                <select id="medico_id" class="form-input" name="name_medico">
                                    <option value="" disabled selected>Escolha o médico pretendido</option>
                                    <option value="1">João Pestana</option>
                                    <option value="2">Catarina Nogueira</option>
                                    <option value="3">Marco Teixeira</option>

                               




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