<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Centro Hospitalar UPskill</title>

        <link rel="stylesheet" href="style.css" />

</head>

<body>

    <div class="container">

        <%@ include file="sidenavtemp.jsp" %>

        <div class="main">
            <div class="white_box">

                <img src="imagens\noun_centro_hospitalar_logo.svg" alt="logo" class="logo_small" />
                <h3 class="registo">
                    Registo de Utente
                </h3>
                <form class="registration-form" action="/temp" method="post" enctype="multipart/form-data">

                    <div class="perfil-main-col">

                        <div class="perfil-row">
                            <div class="cell-row">
                                <label for="foto_perfil_id">Foto de perfil</label>
                                <input type="file" name="file" accept="image/jpeg, image/png" />
                                <span>${errorMsgPhotoUpload}</span>
                            </div>
                        </div>

                    </div>
                    <button type="submit" class="btn btn-blue">Criar Conta</button>
                    <img src="/uploaded_images/001.jpg" width="20%" height="20%" />
                </form>


            </div>
        </div>
    </div>
</body>

</html>