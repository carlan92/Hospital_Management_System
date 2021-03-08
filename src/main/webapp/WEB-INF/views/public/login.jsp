<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <img src="/imagens/draw_login.svg" class="img-fill-form" alt="Logo">
                <h3 class="title_next_appt">Iniciar sessão</h3>
            </div>

            <div class="main-col">
                <form class="login-form" action="/public/login" method="post">
                    <div class="input-row">
                        <input class="form-input" type="text" name="username" id="username_id" placeholder="Username">
                    </div>

                    <div class="input-row">
                        <input class="form-input" type="password" name="password" id="password_id" placeholder="Palavra-passe">
                    </div>

                    <div class="input-row">
                        <button type="submit" name="submit" class="btn-green">Entrar</button>
                    </div>
                </form>
                <c:if test="${param.error != null}">
                	<span style="color: red">Username/Palavra-passe inválidos</span>
                </c:if>

                <div>
                    <a class="login-a" href="/public/registration">Efectuar registo </a>
                </div>

                <div>
                    <a class="login-a" href="/public/recover-password">Recuperar palavra-passe</a>
                </div>
            </div>
        </div>
    </div>

</body>

</html>