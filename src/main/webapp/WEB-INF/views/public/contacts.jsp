<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body>

    <c:choose>
        <c:when test="${user_logged.getAccount().equals('Utente')}">
            <%@ include file="../components/sidenav-utente.jsp" %>
        </c:when>
        <c:when test="${user_logged.getAccount().equals('Recepcionista')}">
            <%@ include file="../components/sidenav-receptionist.jsp" %>
        </c:when>
        <c:when test="${user_logged.getAccount().equals('Médico')}">
            <%@ include file="../components/sidenav-medico.jsp" %>
        </c:when>
        <c:otherwise>
            <%@ include file="../components/sidenav-login.jsp" %>
        </c:otherwise>
    </c:choose>

    <div class="main">
        <!--menu da direita-->
        <div class="row first_row">
            <div class="col-4">
                <img src="/imagens/noun_contact.svg" alt="" class="icon1" />
            </div>
            <div class="col-8 intro">
                <h3 class="title_next_appt">Contactos</h3>
            </div>
        </div>



        <div class="row">
            <div class="col-md-4">
                <div class="contact-info">
                    <div class="contact-info-item">
                        <div class="contact-info-icon">
                            <i class="fas fa-map-marked"></i>
                        </div>
                        <div class="contact-info-text">
                            <h2>Morada</h2>
                            <span>R. Retiro dos Pacatos 50 Edifício Startup, 2635-224 Rio de Mouro (Sintra) </span>
                            <span>Lisboa , Portugal</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="contact-info">
                    <div class="contact-info-item">
                        <div class="contact-info-icon">
                            <i class="fas fa-envelope"></i>
                        </div>
                        <div class="contact-info-text">
                            <h2> E-mail</h2>
                            <span> geral@hospital.upskill.pt </span>
                            <span> 211 123 123</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="contact-info">
                    <div class="contact-info-item">
                        <div class="contact-info-icon">
                            <i class="fas fa-clock"></i>
                        </div>
                        <div class="contact-info-text">
                            <h2>Horário de funcionamento</h2>
                            <span>Seg - Dom 08:00 - 17.00</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">

            <div class="local-map">
                <div class="contact-page-map">
                    <iframe
                            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3110.531213057455!2d-9.33411158486233!3d38.774454879589804!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd1ecfd0a05e1a79%3A0x80d6a364aa1a39c1!2sStartUp%20Sintra!5e0!3m2!1spt-BR!2spt!4v1615518514179!5m2!1spt-BR!2spt"
                            width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
                </div>
            </div>
        </div>
    </div>
</body>

</html>