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

<div class="maininfo">
    <!--menu da direita-->
    <p class="igtitlefont">Informações Gerais</p>
    <div class="divinfo">
        <a href="">
            <div class="containerinfo">
                <img class="imginfo" src="/imagens/info_covid.png" alt="..."/>
                <div class="textinfo-block">
                    <p>Novas informações sobre a Sars-CoV-2</p>
                </div>
                <div class="overlaytextinfo">
                    <div class="textinfo">Ver Mais</div>
                </div>
            </div>
        </a>
    </div>


    <div class="divinfo">
        <a href="">
            <div class="containerinfo">
                <img class="imginfo" src="/imagens/info_vacinacao.png" alt="..."/>
                <div class="textinfo-block">
                    <p>O que acontece no nosso corpo quando somos vacinados?</p>
                </div>
                <div class="overlaytextinfo">
                    <div class="textinfo">Ver Mais</div>
                </div>
            </div>
        </a>
    </div>

    <div class="divinfo">
        <a href="m">
            <div class="containerinfo">
                <img class="imginfo" src="/imagens/info_teleconsulta.png" alt="..."/>
                <div class="textinfo-block">
                    <p>Mais informações sobre Teleconsultas</p>
                </div>
                <div class="overlaytextinfo">
                    <div class="textinfo">Ver Mais</div>
                </div>
            </div>
        </a>
    </div>

    <div class="divinfo">
        <a href="">
            <div class="containerinfo">
                <img class="imginfo" src="/imagens/info_epilepsia.png" alt="..."/>
                <div class="textinfo-block">
                    <p>Epilepsia. O que é?</p>
                </div>
                <div class="overlaytextinfo">
                    <div class="textinfo">Ver Mais</div>
                </div>
            </div>
        </a>
    </div>

</div>


</body>

</html>