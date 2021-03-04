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

                                    <tr>
                                        <td>16/12/2020</td>
                                        <td>10:00</td>
                                        <td>Cardiologia</td>
                                        <td> Dr. Alberto</td>
                                        <td><a href="#">Clicar aqui</a></td>
                                    </tr>

                                    <tr>
                                        <td>21/12/2020</td>
                                        <td>10:15</td>
                                        <td>Cardiologia</td>
                                        <td> Dr. Joaquim</td>
                                        <td><a href="#">Clicar aqui</a></td>
                                    </tr>

                                    <tr>
                                        <td>20/01/2021</td>
                                        <td>12:00</td>
                                        <td>Cardiologia</td>
                                        <td> Dr. Alberto</td>
                                        <td><a href="#">Clicar aqui</a></td>
                                    </tr>

                                    <tr>
                                        <td>20/02/2021</td>
                                        <td>10:00</td>
                                        <td>Cardiologia</td>
                                        <td> Dra. Alba</td>
                                        <td><a href="#">Clicar aqui</a></td>
                                    </tr>

                                </tbody>
                            </table>

                        </section>


                    </div>
                </div>
            </div>
    </body>

    </html>