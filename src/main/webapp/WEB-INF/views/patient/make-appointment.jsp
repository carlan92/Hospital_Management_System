<!DOCTYPE html>
<html lang="en">

<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../components/head.jsp" %>
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


            <form class="registration-form" action="/make-appointment" method="post">
                <div class="perfil-main-col">

                    <div class="perfil-row">
                        <div class="cell-row cell-morada">
                            <label for="especialidade_id">Especialidade</label>
                            <select id="especialidade_id" class="form-input" name="name_speciality" required>
                                <option value="" disabled selected>Escolha a especialidade pretendida</option>
                                <option value="1">Dentista</option>
                                <option value="2">Dermatologia</option>
                                <option value="3">Geral</option>
                            </select>
                            <p class="msg-error">${errorMsgSpeciality}</p>
                        </div>
                    </div>

                    <div class="perfil-row">
                        <div class="cell-row cell-morada">
                            <label for="medico_id">Médico</label>
                            <select id="medico_id" class="form-input" name="name_medico" required>
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
                            <input id="date_id" type="date" class="form-input" name="date" required value="" />
                            <p class="msg-error">${errorMsgDate}</p>
                        </div>
                    </div>

                    <div class="perfil-row">
                        <div class="cell-row cell-morada">
                            <label for="hora_id">Hora</label>
                            <select id="hora_id" type="text" class="form-input" name="hora" required />
                            <option value="" disabled selected>Escolha a hora pretendida</option>
                            <option value="1">09:30</option>
                            <option value="2">10:30</option>
                            <option value="3">11:00</option>
                            </select>
                            <p class="msg-error">${errorMsgHora}</p>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-green">Marcar Consulta</button>
            </form>






        </div>

    </div>

</body>

</html>