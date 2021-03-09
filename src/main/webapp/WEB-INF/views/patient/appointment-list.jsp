<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
            <%@ include file="../components/head.jsp" %>
    </head>

    <body>

        <%@ include file="../components/sidenav-utente.jsp" %>


            <div class="main">
                <!--menu da direita-->

                <div class="white_box2 box-align-left">

                    <div class="perfil-row">
                        <img src="/imagens/draw_checking.svg" alt="patientsPage" class="img-fill-form" />
                        <h3 class="consultas_title">Consultas</h3>
                    </div>

                    <div class="row">
                        <div class=search_options>

                            <form>
                                <div class="middle-row">
                                    <div class="search-container">
                                        <input id="data_id" type="date" class="form-input sm" placeholder="Data"
                                            name="data">
                                        <select id="speciality_id" class="form-input sm" name="speciality">
                                            <option value="" disabled selected>Especialidade</option>
                                            <!-- For -->
                                            <c:forEach var="speciality" items="${specialities}">
                                                <option value="${speciality.getName()}">${speciality.getName()}</option>
                                            </c:forEach>
                                        </select>

                                        <input type="text" class="form-input sm" placeholder="Nome do Médico">

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
                                    <tr>
                                        <th>Data</th>
                                        <th>Hora</th>
                                        <th>Especialidade</th>
                                        <th>Médico</th>
                                        <th>+ detalhes</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <!-- For -->
                                    <c:forEach var="appointment" items="${appointments}">
                                    <tr>
                                        <td>${appointment.getSlot().getDateStr()}</td>
                                        <td>${appointment.getSlot().getTimeBegin()}</td>
                                        <td>${appointment.getSlot().getDoctor().getSpeciality().getName()}</td>
                                        <td>${appointment.getSlot().getDoctor().getTitleAndName()}</td>
                                        <td><a href="#">Clicar aqui</a></td>
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