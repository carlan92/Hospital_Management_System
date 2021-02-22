<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="main">
        <div class="white_box vista_perfil">
            
            <img class="logo_small" src="/imagens/noun_centro_hospitalar_logo.svg" alt="Logo do centro hospitalar">
            <div class="user-type">
                <p id="user_name">${user.getName()} (${user.getUsername()})</p>
                <p id="user_category">${user.getAccount()}</p>
            </div>
            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="cell-row">Sexo</div>
                    <div class="cell-row">${user.getSex()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Data de nascimento</div>
                    <div class="cell-row">${user.getBirthday()}</div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">Morada</div>
                    <div class="cell-row">${user.getAddress()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Código Postal</div>
                    <div class="cell-row">${user.getPostalCode()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Localidade</div>
                    <div class="cell-row">${user.getLocality()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Nacionalidade</div>
                    <div class="cell-row">${user.getNationality()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Documento de identificação</div>
                    <div class="cell-row">${user.getDocumentType()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Nº do documento</div>
                    <div class="cell-row">${user.getDocumentNumber()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">NIF</div>
                    <div class="cell-row">${user.getNif()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Nº de Utente</div>
                    <div class="cell-row"> ${user.getPatientNumber()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Telemóvel</div>
                    <div class="cell-row">${user.getPhone()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">E-mail</div>
                    <div class="cell-row">${user.getEmail()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">
                        <form action="/alterar_registo" method="get">
                            <button class="btn-blue btn-w65">Alterar Registo</button>
                        </form>
                    </div>
                    <div class="cell-row">
                        <form action="/userToMain" method="get">
                            <button class="btn-green btn-w65">Página Principal</button>
                        </form>
                    </div>
                </div>
            </div>
        </>
    </div>

</body>

</html>