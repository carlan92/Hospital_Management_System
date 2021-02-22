<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <title>Centro Hospitalar UPskill</title>
</head>

<body>
    <div class="main">
        <div class="white_box">
            <img class="logo_small" src="/imagens/noun_centro_hospitalar_logo.svg" alt="Logo do centro hospitalar">
            <div class="main-col">
                
                <form class="login-form" action="/login" method="post">
                    <div class="input-row">
                        <input class="form-input" type="text" name="user_email" id="user_email_id" placeholder="Username">
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
                    <a class="login-a" href="/registry">Efectuar registo </a>
                </div>

                <div>
                    <a class="login-a" href="/recoverPass">Recuperar palavra-passe</a>
                </div>
            </div>
        </div>
    </div>

</body>

</html>