<!DOCTYPE html>
<html lang="en">

<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="components/head.jsp" %>
</head>

<body>
    <%@ include file="components/sidenav-login.jsp" %>
    <div class="main">
        <div class="white_box box-align-left">
            <img class="logo_small" src="/imagens/noun_centro_hospitalar_logo.svg" alt="Logo do centro hospitalar">
            <div class="main-col">
                
                <form class="login-form" action="/login" method="post">
                    <div class="input-row">
                        <input class="form-input" type="text" name="username" id="username_id" placeholder="Username">
                    </div>

                    <div class="input-row">
                        <input class="form-input" type="password" name="password" id="password_id" placeholder="Palavra-passe">
                    </div>

                    <div class="input-row">
                        <button type="submit" class="btn-green">Entrar</button>
                    </div>
                </form>
                <span style="color: red">${errorMessage}</span>
                <div>
                    <a class="login-a" href="/registration">Efectuar registo </a>
                </div>

                <div>
                    <a class="login-a" href="/recoverPass">Recuperar palavra-passe</a>
                </div>
            </div>
        </div>
    </div>

</body>

</html>