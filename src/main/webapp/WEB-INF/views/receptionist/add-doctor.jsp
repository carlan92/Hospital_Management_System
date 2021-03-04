<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body>
<%@ include file="../components/sidenav-main.jsp" %>

<div class="main">
    <!--menu da direita-->
    <div class="white_box box-align-left">
        <div class="perfil-main-col">
            <div class="perfil-row">
                <div class="perfil-row">
                    <img src="/imagens/draw_add_user.svg" alt="fill form" class="img-fill-form"/>
                </div>

                <div class="perfil-row">
                    <h3 class="registo">Adicionar Médico</h3>
                </div>
            </div>
        </div>


        <form class="registration-form" action="/add-doctor" method="post">
            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="cell-row cell-morada">
                        <input id="user_name_id" type="text" class="form-input" name="user_name" required
                               placeholder="Nome do Médico" value=""/>
                        <p class="msg-error">${errorMsgName}</p>

                        <input id="especialidade_id" type="text" class="form-input" name="speciality" required
                               placeholder="Especialidade" value=""/>
                        <p class="msg-error">${errorMsgName}</p>
                    </div>
                </div>
            </div>
        </form>
        <button type="submit" class="btn btn-blue">Adicionar Médico</button>

    </div>
</div>
</body>
</html>