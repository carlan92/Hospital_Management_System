<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
    <link rel="stylesheet" href="/message.css"/>
</head>

<body>

<c:if test="${user_logged.getAccount().equals('Médico')}">
    <%@ include file="../components/sidenav-medico.jsp" %>
</c:if>
<c:if test="${user_logged.getAccount().equals('Recepcionista')}">
    <%@ include file="../components/sidenav-receptionist.jsp" %>
</c:if>
<c:if test="${user_logged.getAccount().equals('Utente')}">
    <%@ include file="../components/sidenav-utente.jsp" %>
</c:if>


<div class="main">
    <!--menu da direita-->

    <div class="white_box2 box-align-left">

        <div class="perfil-row">
            <img src="../imagens/draw_checking.svg" alt="patientsPage" class="img-fill-form"/>
            <h3 class="consultas_title">Mensagens</h3>
        </div>

        <div class="row">
            <div class=search_options>
                <form action="${userTypeURL}" method="post">
                    <div class="middle-row">
                        <div class="search-container">

                            <input id="data_id" type="date" class="form-input sm" placeholder="Data" name="date">

                            <div class="msg-state-choice">
                                <label for="msg-open">
                                    <img src="../imagens/message/mail-open.svg" class="mail-icon" alt="apagar"/>
                                </label>
                                <input id="msg-open" type="checkbox" name="msgState" value="open">
                            </div>

                                <div class="msg-state-choice">
                                <label for="msg-open">
                                    <img src="../imagens/message/mail-close.svg" class="mail-icon" alt="apagar"/>
                                </label>
                                <input id="msg-close" type="checkbox" name="msgState" value="close">
                            </div>

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
                    <tr class="appointment-table-title">
                        <th>Lido?</th>
                        <th>Data</th>
                        <th>Assunto</th>
                        <th>Mensagem</th>
                        <th>Apagar</th>
                    </tr>
                    </thead>
                    <tbody>

                    <!-- For -->
                    <tr class="appointment-table-details">
                        <td><img src="../imagens/message/mail-open.svg" class="mail-icon" alt="apagar"/>
                            <img src="../imagens/message/mail-close.svg" class="mail-icon" alt="apagar"/></td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                        <td><img src="../imagens/message/recycle-bin.svg" class="mail-icon" alt="apagar"/></td>
                    </tr>
                    <c:forEach var="message" items="${messages}">
                        <tr class="appointment-table-details">
                            <td>${message.isReadMsg()}</td>
                            <td>${message.getDateStr()}</td>
                            <td>${message.getSubject()}</td>
                            <td>${message.getMessage()}</td>
                            <td><img src="../imagens/message/recycle-bin.svg" alt="apagar"/></td>
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