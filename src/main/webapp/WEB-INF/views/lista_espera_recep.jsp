<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="components/head.jsp" %>
</head>

<body>
<%@ include file="components/sidenav-main.jsp" %>

<div class="main">
    <!--menu da direita-->

    <div class="white_box2 box-align-left">

        <div class="perfil-row">
            <img src="imagens/draw_checking.svg" alt="patientsPage" class="img-fill-form"/>
            <h3 class="consultas_title">Lista de espera para consulta </h3>
        </div>

        <div class="row">
            <div class=search_options>

                <form>
                    <div class="middle-row">
                        <div class="search-container">
                            <input id="data_id" type="date" class="form-input sm" placeholder="Data"
                                   name="data">
                            <input type="text" class="form-input sm" placeholder="Nome do Utente">
                            <select id="speciality_id" class="form-input sm" name="speciality">
                                <option value="" disabled selected>Especialidade</option>
                                <option value="1">Todas</option>
                                <option value="2">Cardiologia</option>
                                <option value="3">Osteopatia</option>
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
                        <th>Utente</th>
                        <th>Hora</th>
                        <th>Especialidade</th>
                        <th>Médico</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>20/12/2020</td>
                        <td>Alice Costa</td>
                        <td>10:00</td>
                        <td>Cardiologia</td>
                        <td> Dr. Alberto</td>
                    </tr>

                    <tr>
                        <td>20/12/2020</td>
                        <td>Ana Costa</td>
                        <td>10:15</td>
                        <td>Cardiologia</td>
                        <td> Dr. Alberto</td>
                    </tr>

                    <tr>
                        <td>20/12/2020</td>
                        <td>Bruno Costa</td>
                        <td>10:30</td>
                        <td>Cardiologia</td>
                        <td> Dr. Alberto</td>
                    </tr>
                    </tbody>
                </table>
            </section>

        </div>
    </div>
</div>
</body>
</html>