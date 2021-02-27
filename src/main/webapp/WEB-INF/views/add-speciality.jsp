<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Centro Hospitalar UPskill</title>

    <link rel="stylesheet" href="bootstrap.min.4.5.3.css"/>
    <link rel="stylesheet" href="style.css"/>

    <link rel="icon" href="favicon.ico" type="image/x-icon">
</head>

<body>
    <%@ include file="sidenav-main.jsp" %>

    <div class="main">
        <!--menu da direita-->
        <div class="white_box box-align-left">
            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="perfil-row">
                        <img src="imagens/draw_text_field.svg" alt="fill form" class="img-fill-form" />
                    </div>

                    <div class="perfil-row">
                        <h3 class="registo">Adicionar Especialidade</h3>
                    </div>
                </div>
            </div>


            <form class="registration-form" action="/add-speciality" method="post">
                <div class="perfil-main-col">
                    <div class="perfil-row">
                        <div class="cell-row cell-morada">
                            <label for="especialidade_id">Especialidade</label>
                            <input id="especialidade_id" type="text" class="form-input" name="especialidade" required
                                placeholder="Nome da Especialidade" value="" />
                            <p class="msg-error">${errorMsgName}</p>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-blue">Criar Especialidade</button>
            </form>






        </div>

    </div>

</body>

</html>