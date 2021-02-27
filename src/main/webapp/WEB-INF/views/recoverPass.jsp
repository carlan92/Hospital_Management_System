<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="bootstrap.min.4.5.3.css"/>
    <link rel="stylesheet" href="style.css">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <title>Recuperar Palavra-passe</title>
</head>
<body>
<%@ include file="sidenav-login.jsp" %>
<div class="main">
    <div class="white_box box-align-left">
        <img class="logo_small" src="/imagens/noun_centro_hospitalar_logo.svg" alt="Logo do centro hospitalar">
        <div class="main-col">

            <form class="recoverPass-form" action="/recoverToLogin" method="post">
                <div class="input-row">
                    <input class="form-input input1" type="text" name="username" id="user_name_id"
                           required placeholder="*Introduza o seu username" value="${username}">
                    <input class="form-input input1" type="text" name="user_nif" id="user_nif_id"
                           required placeholder="*Introduza o seu NIF" value="${user_nif}">
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