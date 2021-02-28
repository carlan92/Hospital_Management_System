<!DOCTYPE html>
<html lang="en">

<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="components/head.jsp" %>
</head>

<body>
<div class="container">
    <%@ include file="components/sidenav-medico.jsp" %>


    <div class="main">
        <!--menu da direita-->
        <div class="row first_row">

            <div class="col-4">
                <img src="imagens/draw_doctor.svg" alt="" class="icon1" />
            </div>

            <div class="col-8 display_time">
                <div class="time_box">
                        <span id="hour">
                            <i class="fas fa-clock"></i>
                            10:00
                        </span>
                </div>
                <div class="date_box">
                        <span id="date">
                            Quarta-feira 25 Fevereiro 2021
                        </span>
                </div>
            </div>
        </div>

        <div class="row middle-row3">

            <div class="col-3">
                <div class="card_box2">
                    <div class="card2">
                        <div class="card-body2">
                            <h2>
                                <span>14</span>
                            </h2>
                            <h3>Pacientes agendados</h3>
                            <i class="far fa-calendar-alt "></i>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-3">
                <div class="card_box2">
                    <div class="card2">
                        <div class="card-body2">
                            <h2>
                                <span>1</span>
                            </h2>
                            <h3>Pacientes confirmados</h3>
                            <i class="fas fa-calendar-check "></i>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-3">
                <div class="card_box2">
                    <div class="card2">
                        <div class="card-body2">
                            <h2>
                                <span>0</span>
                            </h2>
                            <h3>Pacientes atendidos
                                <i class="fas fa-user-check "></i>

                            </h3>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-3">
                <div class="card_box2">
                    <div class="card2">
                        <div class="card-body2">
                            <h2>
                                <span>0</span>
                            </h2>
                            <h3>Pacientes que faltaram
                            </h3>
                            <i class="fas fa-calendar-times "></i>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <div class="row middle-row">

            <div class="col-7 data_appt">
                <div class="row">

                    <div class="col-2 icon3">
                        <i class="fas fa-stethoscope"></i>
                    </div>

                    <div class="col-8 title_next_appt">
                        <span class="text_next_appt">Próxima consulta</span>
                        <p class="text_next_appt2">Consulte a sua próxima consulta e paciente</p>
                    </div>
                </div>

                <div class="row">

                    <div class="col-3 next_appt_time">
                        <span class="time_box2">10:00</span>
                        <p class="date_box2">Sexta-feira</p>
                        <p class="date_box2">26 Fevereiro 2021</p>
                    </div>

                    <div class="col-9">
                        <div class="perfil-row">
                            <div class="col-4 user_photo2">
                                <img src="imagens/draw_doctor.svg" alt="fotografia utente" />
                            </div>
                            <div class="col user_info">
                                <span id="next_patient_name">Alice Antunes</span>
                                <p id="patient_age">Idade: 70 anos</p>
                                <span id="first_appt_ask">Primeira Consulta: SIM </span>
                                <p id="first_appt_ask">Estado da Consulta: CONFIRMADA </p>
                            </div>
                        </div>

                        <div class="row">
                            <button type="button" class="btn-blue btn-w85"> Consultar Perfil Paciente
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-4 appt_options">
                <div>
                    <div class="but-begin_appt">
                        <button type="button" class="btn-green btn-w75"> Iniciar Consulta </button>
                    </div>
                    <div class="but-change_appt">
                        <button type="button" class="btn-green btn-w75"> Alterar data </button>
                    </div>
                    <div class="but-cancel_appt">
                        <button type="button" class="btn-green btn-w75"> Cancelar Consulta </button>
                    </div>
                    <div class="but-end_appt">
                        <button type="button" class="btn-green btn-w75"> Terminar Consulta </button>
                    </div>
                </div>
            </div>
        </div>

        <div class="row middle-row ">
            <div class="col-2">
                <img src="imagens/waiting.svg" alt="" class="icon2" />
            </div>
            <div class="col-6 data_appt">
                <div class="row">
                    <span class="text_next_appt">Lista de pacientes em espera</span>
                </div>
                <div class="row">
                    <button type="button" class="btn-blue btn-w74"> Ver Lista de espera</button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>