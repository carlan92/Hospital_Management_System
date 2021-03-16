<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<c:if test="${user_logged.getAccount().equals('Médico')}">
    <a href="/doctor/messages" class="botao_acessos">
</c:if>
<c:if test="${user_logged.getAccount().equals('Recepcionista')}">
    <a href="/receptionist/messages" class="botao_acessos">
</c:if>
<c:if test="${user_logged.getAccount().equals('Utente')}">
    <a href="/patient/messages" class="botao_acessos">
</c:if>
<img src="/imagens/message/mail.svg" class="sidenav-icon"/>Mensagens
<img src="/imagens/message/mail-alert.svg" class="sidenav-icon"/>Mensagens
</a>