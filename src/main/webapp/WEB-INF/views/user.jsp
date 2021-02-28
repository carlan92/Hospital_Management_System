<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="components/head.jsp" %>
</head>

<body>
<%@ include file="components/sidenav-main.jsp" %>

    <div class="main">
        <div class="white_box box-align-left">



            <div class="perfil-main-col">
                <div class="perfil-row">
                <div class="cell-row cell-align-center">
                    <div class="user-type">
                        <p id="user_name">${user.getName()}</p>
                        <p id="user_category">${user.getAccount()}</p>
                    </div>
                </div>

                <div class="cell-row">
                    <div class="user_photo">
                        <img src="/uploaded_images/${user.getPhotoURL()}" alt="foto do utilizador" />
                    </div>
                </div>
            </div>




            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="cell-row">Sexo</div>
                    <div class="cell-row">${user.getSex()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Data de nascimento</div>
                    <div class="cell-row"><fmt:formatDate pattern="dd/MM/yyyy" value="${user.getBirthday()}"/></div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">Morada</div>
                    <div class="cell-row">${user.getAddress()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Código Postal</div>
                    <div class="cell-row">${user.getPostCode()}</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Localidade</div>
                    <div class="cell-row">${user.getCity()}</div>
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
                        <form action="/change_data" method="get">
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