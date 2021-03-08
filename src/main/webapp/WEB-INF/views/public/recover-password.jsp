<!DOCTYPE html>
<html lang="en">
<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../components/head.jsp" %>
</head>
<body>
<%@ include file="../components/sidenav-login.jsp" %>
<div class="main">
    <div class="white_box box-align-left">

        <div class="perfil-row">
            <img src="/imagens/draw_forgotpassword.svg" class="img-fill-form" alt="Logo">
            <h3 class="title_next_appt">Recuperar Palavra-passe</h3>
        </div>

        <div class="main-col">
            <form class="recoverPass-form" action="/public/recover-password" method="post">
                <div class="input-row">
                    <input class="form-input input1" type="text" name="username" id="user_name_id"
                           required placeholder="*Introduza o seu username" value="${username}">
                    <input class="form-input input1" type="text" name="email" id="email_id"
                           required placeholder="*Introduza o seu email" value="${email}">
                </div>

                <div class="input-row">
                    <input class="form-input pass1" type="password" name="password1" id="password_id1"
                           required placeholder="*Nova palavra-passe">
                    <input class="form-input pass1" type="password" name="password2" id="password_id2"
                           required placeholder="*Repetir palavra-passe">
                </div>

                <div class="input-row">
                    <button type="submit" class="btn-green">Guardar alterações e iniciar sessão</button>
                </div>
                <span style="color: red">${errorMessage}</span>
            </form>

            <div class="footerPass">
                <span class="suggestion">Sugestões de palavras-passe seguras: </span>
                <ul>
                    <li class="suggestion2">
                        Utilize, pelo menos, 8 carateres. Uma combinação de números e letras é a melhor solução.
                    </li>
                    <li class="suggestion2">
                        Não utilize a mesma palavra-passe para várias contas online.
                    </li>
                </ul>
            </div>

        </div>
    </div>
</div>

</body>
</html>