<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body>
<%@ include file="../components/sidenav-main.jsp" %>

<div class="main">
    <div class="white_box box-align-left">

        <div class="perfil-main-col">
            <div class="perfil-row">
                <div class="perfil-row">
                    <img src="imagens\fill_form.svg" alt="fill form" class="img-fill-form"/>
                </div>

                <div class="perfil-row">
                    <h3 class="registo">Alterar Registo</h3>
                </div>
            </div>
        </div>

        <form class="registry-form" action="/user/change-profile-data" method="post" enctype="multipart/form-data">

            <div class="perfil-main-col">

                <div class="perfil-row">
                    <div class="cell-row cell-morada">
                        <label for="nome_id">Nome Completo *</label>
                        <input id="nome_id" type="text" class="form-input" name="name" required
                               placeholder="O seu nome completo" value="${user.getName()}"/>
                        <p class="msg-error">${errorMsgName}</p>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <label for="sexo_id">Sexo *</label>
                        <select id="sexo_id" class="form-input" name="sex" required value="${user.getSex()}">
                            <option value="Masculino" <c:if test="${user.getSex().equals('Masculino')}"> selected
                            </c:if>>
                                Masculino
                            </option>

                            <option value="Feminino" <c:if test="${user.getSex().equals('Feminino')}"> selected
                            </c:if>>
                                Feminino
                            </option>
                        </select>
                        <p class="msg-error">${errorMsgSex}</p>
                    </div>
                    <div class="cell-row">
                        <label for="dataDeNascimento_id">Data de Nascimento *</label>
                        <input id="dataDeNascimento_id" type="date" class="form-input" name="birthday" required
                               value="${user.getBirthdayStr()}">
                        <p class="msg-error">${errorMsgBirthday}</p>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row cell-morada">
                        <label for="morada_id">Morada</label>
                        <input id="morada_id" type="text" class="form-input" name="address"
                               placeholder="A sua morada" value="${user.getAddress()}"/>
                        <p class="msg-error">${errorMsgAddress}</p>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <label for="codigoPostal_id">Código Postal</label>
                        <input id="codigoPostal_id" type="text" pattern="\d{4}([ -]\d{3})?" class="form-input"
                               name="postCode" placeholder="O seu código postal" value="${user.getPostCode()}"/>
                        <p class="msg-error">${errorMsgPostCode}</p>
                    </div>

                    <div class="cell-row">
                        <label for="localidade_id">Localidade *</label>
                        <input id="localidade_id" type="text" class="form-input" name="city" required
                               placeholder="A sua localidade" value="${user.getCity()}"/>
                        <p class="msg-error">${errorMsgCity}</p>
                    </div>
                </div>

                <div class="perfil-row">


                    <div class="cell-row">
                        <label for="nacionalidade_id">Nacionalidade *</label>
                        <select id="nacionalidade_id" class="form-input" name="nationality" required
                                value="${user.getNationality()}">

                            <!-- For -->
                            <c:forEach var="nationality" items="${nationalities}">
                                <option value="${nationality.getName()}" <c:if
                                        test="${nationality.getName().equals(user.getNationality())}"> selected</c:if>>
                                        ${nationality.getName()}
                                </option>
                            </c:forEach>

                        </select>
                        <p class="msg-error">${errorMsgNationality}</p>
                    </div>

                    <div class="cell-row">
                        <label for="telemovel_id">Telemóvel *</label>
                        <input id="telemovel_id" type="text"
                               pattern="^9[1236][0-9]{7}$|^2[3-9][1-9][0-9]{6}$|^2[12][0-9]{7}$" class="form-input"
                               name="phone" required placeholder="O seu número de telemóvel"
                               value="${user.getPhone()}"/>
                        <p class="msg-error">${errorMsgPhone}</p>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <label for="documento_id">Documento de Identificação *</label>
                        <select id="documento_id" class="form-input" name="documentType" required
                                value="${user.getDocumentType()}">

                            <option value="Bilhete de Identidade" <c:if
                                    test="${user.getDocumentType().equals('Bilhete de Identidade')}"> selected</c:if>>
                                Bilhete de Identidade
                            </option>
                            <option value="Cartão de Cidadão" <c:if
                                    test="${user.getDocumentType().equals('Cartão de Cidadão')}"> selected</c:if>>
                                Cartão de Cidadão
                            </option>
                            <option value="Passaporte" <c:if test="${user.getDocumentType().equals('Passaporte')}">
                                selected</c:if>>
                                Passaporte
                            </option>

                        </select>
                        <p class="msg-error">${errorMsgDocumentType}</p>
                    </div>
                    <div class="cell-row">
                        <label for="nrDocumento_id">Nº do Documento *</label>
                        <input id="nrDocumento_id" type="text" class="form-input" name="documentNumber" required
                               placeholder="Nº do documento selecionado" value="${user.getDocumentNumber()}"/>
                        <p class="msg-error">${errorMsgDocumentNumber}</p>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <label for="foto_perfil_id">Foto de perfil</label>
                    </div>
                    <div class="cell-row">
                        <input id="foto_perfil_id" type="file" name="file" accept="image/jpeg, image/png"/>
                        <p class="msg-error">${errorMsgPhotoUpload}</p>
                    </div>
                </div>


                <div class="perfil-row">
                    <div class="cell-row">
                        <label for="nif_id">NIF *</label>
                        <input id="nif_id" type="text" class="form-input" name="nif" required placeholder="NIF"
                               value="${user.getNif()}"/>
                        <p class="msg-error">${errorMsgNif}</p>
                    </div>
                    <div class="cell-row">
                        <label for="nrUtente_id">Nº de Utente</label>
                        <input id="nrUtente_id" type="text" class="form-input" name="patientNumber"
                               placeholder="Nº de Utente" value="${user.getPatientNumber()}"/>
                        <p class="msg-error">${errorMsgPatientNumber}</p>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <c:if test="${user.getAccount().equals('Médico')}">
                            <label for="nrCedulaProfissional_id">Nº Cédula Profissional</label>
                            <input id="nrCedulaProfissional_id" type="text" class="form-input" name="licenseNumber"
                                   placeholder="Nº Cédula Profissional" value="${user.getLicenseNumber()}"/>
                            <p class="msg-error">${errorMsgLicenseNumber}</p>
                        </c:if>

                    </div>

                    <div class="cell-row">
                        <c:if test="${user.getAccount().equals('Médico')}">
                            <label for="speciality_id">Especialidade</label>
                            <input id="speciality_id" type="text" class="form-input" name="speciality"
                                   placeholder="Especialidade" value="${user.getSpeciality().getName()}"/>
                            <p class="msg-error">${errorMsgLicenseNumber}</p>
                        </c:if>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row cell-morada">
                        <p class="nota">* campos de preenchimento obrigatório</p>
                    </div>
                </div>


                <div class="perfil-row">
                    <div class="cell-row cell-morada">
                        <button type="submit" class="btn btn-blue">Alterar Dados</button>
                    </div>

                </div>

            </div>

        </form>

    </div>
</div>
</body>

</html>