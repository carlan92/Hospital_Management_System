<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="components/head.jsp" %>
</head>

<body>
<%@ include file="components/sidenav-medico.jsp" %>


<div class="main">
    <!--menu da direita-->
    <div class="row first_row">

        <div class="col-4">
            <img src="imagens/draw_doctor.svg" alt="" class="icon1"/>
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

    <div class="row middle-row ">
        <div class="wait_middle middle">
            <div class="data_appt">
                <span class="text_next_appt">Lista de pacientes em espera para consulta</span>
                <button type="button" class="btn-blue btn-w74">Lista de espera</button>
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
                    <span class="text_next_appt">Consulta a decorrer</span>
                    <p class="text_next_appt2">Ainda não tem consultas a decorrer ou apresentar info:</p>
                </div>
            </div>

            <div class="row">
                <div class="col-5 next_appt_time">
                    <span class="time_box2">10:00</span>
                    <p class="date_box2">Sexta-feira</p>
                    <p class="date_box2">26 Fevereiro 2021</p>
                </div>

                <div class="col-7">
                    <div class="perfil-row">
                        <div class="col user_photo">
                            <img src="imagens/draw_avatar.svg" alt=""/>
                        </div>
                        <div class="col user_info">
                            <span class="patient_name">Alice Antunes</span>
                            <br/>
                            <span class="patient_age">70 anos</span>
                            <br/>
                            <span class="first_appt_ask">Primeira Consulta: <span> Sim</span></span>
                            <p class="first_appt_ask">Check-in: <span> Sim</span></p>
                        </div>
                    </div>

                    <div class="row">
                        <button type="button" class="btn-blue btn-w85"> Ver Perfil
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-4 appt_options">
            <div>
                <div class="but-cancel_appt">
                    <button type="button" class="btn-green btn-w75"> Registo Consulta</button>
                </div>
                <div class="but-end_appt">
                    <button type="button" class="btn-green btn-w75"> Terminar Consulta</button>
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

                <div class="col-5 next_appt_time">
                    <span class="time_box2">10:30</span>
                    <p class="date_box2">Sexta-feira</p>
                    <p class="date_box2">26 Fevereiro 2021</p>
                </div>

                <div class="col-7">
                    <div class="perfil-row">
                        <div class="col user_photo">
                            <img src="imagens/draw_avatar.svg" alt=""/>
                        </div>
                        <div class="col user_info">
                            <span class="patient_name">Beatriz Ângela</span>
                            <br/>
                            <span class="patient_age">35 anos</span>
                            <br/>
                            <span class="first_appt_ask">Primeira Consulta: <span> Não</span></span>
                            <p class="first_appt_ask">Check-in: <span> Não</span></p>
                        </div>
                    </div>

                    <div class="row">
                        <button type="button" class="btn-blue btn-w85"> Ver Perfil
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-4 appt_options">
            <div>
                <div class="but-begin_appt">
                    <button type="button" class="btn-green btn-w75"> Iniciar Consulta</button>
                </div>
                <div class="but-change_appt">
                    <button type="button" class="btn-green btn-w75"> Alterar data</button>
                </div>
                <div class="but-cancel_appt">
                    <button type="button" class="btn-green btn-w75"> Cancelar Consulta</button>
                </div>
                <div class="but-end_appt">
                    <button type="button" class="btn-green btn-w75"> Marcar Falta de presença</button>
                </div>
            </div>
        </div>
    </div>


</div>
</div>
</body>
</html>