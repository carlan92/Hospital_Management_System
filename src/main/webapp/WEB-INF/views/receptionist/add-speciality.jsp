<!DOCTYPE html>
<html lang="en">

<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="../components/head.jsp" %>
</head>

<body>
    <%@ include file="../components/sidenav-receptionist.jsp" %>

    <div class="main">
        <!--menu da direita-->
        <div class="white_box box-align-left">
            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="perfil-row">
                        <img src="/imagens/draw_text_field.svg" alt="fill form" class="img-fill-form" />
                    </div>

                    <div class="perfil-row">
                        <h3 class="registo">Adicionar Especialidade</h3>
                    </div>
                </div>
            </div>


            <form class="registration-form" action="/receptionist/add-speciality" method="post">
                <div class="perfil-main-col">
                    <div class="perfil-row">
                        <div class="cell-row cell-morada">
                            <label for="especialidade_id">Especialidade</label>
                            <input id="especialidade_id" type="text" class="form-input" name="name_speciality" required
                                placeholder="Nome da Especialidade" value="" />
                            <p class="msg-error">${errorMsgSpeciality}</p>
                            </br>
                            <label for="price">Preço (€)</label>
                            <input id="price" type="text" class="form-input" name= "price" required
                                   placeholder="Valor" value="" />
                            <p class="msg-error">${errorMsgSpeciality}</p>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-blue">Criar Especialidade</button>
            </form>






        </div>

    </div>

</body>

</html>