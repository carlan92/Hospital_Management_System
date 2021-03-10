<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
    <script type="text/javascript">
        function updateForm(tipoAccount) {
            //document.appointmentForm.submit();
            console.log(tipoAccount);
            if (tipoAccount === "Médico") {
                document.getElementById("med").classList.remove("hidden");
            } else if (!document.getElementById("med").classList.contains("hidden")) {
                document.getElementById("med").classList.add("hidden");
            }
        }
    </script>
</head>

<body>
    <%@ include file="../components/sidenav-receptionist.jsp" %>

    <div class="main">
        <!--menu da direita-->
        <div class="white_box box-align-left">
            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="perfil-row">
                        <img src="/imagens/draw_add_user.svg" alt="fill form" class="img-fill-form" />
                    </div>

                    <div class="perfil-row">
                        <h3 class="registo">Adicionar Utilizador</h3>
                    </div>
                </div>
            </div>

            <div class="perfil-main-col">
                <div class="perfil-row">
                    <form class="registration-form" action="/registrationToLogin" method="post"
                        enctype="multipart/form-data">

                        <div class="perfil-main-col">

                            <div class="perfil-row">
                                <div class="cell-row cell-morada">
                                    <label for="nome_id">Nome Completo *</label>
                                    <input id="nome_id" type="text" class="form-input" value="${user.getName()}"
                                        name="name" required placeholder="Nome completo" />
                                    <p class="msg-error">${errorMsgName}</p>
                                </div>
                            </div>

                            <div class="perfil-row">
                                <div class="cell-row">
                                    <label for="sexo_id">Sexo *</label>
                                    <select id="sexo_id" class="form-input" name="sex" required
                                        value="${user.getSex()}">
                                        <option value="" disabled <c:if test="${empty user.getSex()}"> selected</c:if>>
                                            Escolha uma Opção
                                        </option>
                                        <option value="Masculino" <c:if test="${user.getSex().equals('Masculino')}">
                                            selected</c:if>>
                                            Masculino
                                        </option>

                                        <option value="Feminino" <c:if test="${user.getSex().equals('Feminino')}">
                                            selected</c:if>>
                                            Feminino
                                        </option>
                                    </select>
                                    <p class="msg-error">${errorMsgSex}</p>
                                </div>

                                <div class="cell-row">
                                    <label for="dataDeNascimento_id">Data de Nascimento *</label>
                                    <input id="dataDeNascimento_id" type="date" class="form-input"
                                        value="${user.getBirthdayStr()}" name="birthday" required>
                                    <p class="msg-error">${errorMsgBirthday}</p>
                                </div>
                            </div>

                            <div class="perfil-row">
                                <div class="cell-row cell-morada">
                                    <label for="morada_id">Morada</label>
                                    <input id="morada_id" type="text" class="form-input" value="${user.getAddress()}"
                                        name="address" placeholder="Morada" />
                                    <p class="msg-error">${errorMsgAddress}</p>
                                </div>
                            </div>

                            <div class="perfil-row">
                                <div class="cell-row">
                                    <label for="codigoPostal_id">Código Postal</label>
                                    <input id="codigoPostal_id" type="text" pattern="[0-9]{4}[-][0-9]{3}"
                                        class="form-input" value="${user.getPostCode()}" name="postCode"
                                        placeholder="Código postal" />
                                    <p class="msg-error">${errorMsgPostCode}</p>
                                </div>

                                <div class="cell-row">
                                    <label for="localidade_id">Localidade *</label>
                                    <input id="localidade_id" type="text" class="form-input" value="${user.getCity()}"
                                        name="city" required placeholder="Localidade" />
                                    <p class="msg-error">${errorMsgCity}</p>
                                </div>
                            </div>

                            <div class="perfil-row">

                                <div class="cell-row">
                                    <label for="nacionalidade_id">Nacionalidade *</label>
                                    <select id="nacionalidade_id" class="form-input" name="nationality" required>
                                        <option value="" disabled <c:if test="${empty nationality}">
                                            selected</c:if>>
                                            Nacionalidade
                                        </option>
                                        <option value="Portuguesa" <c:if
                                            test="${user.getNationality().equals('Portuguesa')}"> selected</c:if>>
                                            Portuguesa
                                        </option>

                                        <!-- For -->
                                        <c:forEach var="nationality" items="${nationalities}">
                                            <c:if test="${!nationality.getName().equals('Portuguesa')}">
                                                <option value="${nationality.getName()}" <c:if
                                                    test="${user.getNationality().equals(nationality.getName())}">
                                                    selected
                                            </c:if>>
                                            ${nationality.getName()}
                                            </option>
                                            </c:if>
                                        </c:forEach>

                                    </select>
                                    <p class="msg-error">${errorMsgNationality}</p>
                                </div>
                                <div class="cell-row">
                                    <label for="telemovel_id">Telemóvel *</label>
                                    <input id="telemovel_id" type="text"
                                        pattern="^9[1236][0-9]{7}$|^2[3-9][1-9][0-9]{6}$|^2[12][0-9]{7}$"
                                        class="form-input" value="${user.getPhone()}" name="phone" required
                                        placeholder="Número de telemóvel" />
                                    <p class="msg-error">${errorMsgPhone}</p>
                                </div>
                            </div>

                            <div class="perfil-row">
                                <div class="cell-row">
                                    <label for="documento_id">Documento de Identificação *</label>
                                    <select id="documento_id" class="form-input" name="documentType" required>
                                        <option value="" disabled <c:if test="${empty user.getDocumentType()}"> selected
                                            </c:if>>
                                            Escolha uma Opção
                                        </option>
                                        <option value="Bilhete de Identidade" <c:if
                                            test="${user.getDocumentType().equals('Bilhete de Identidade')}"> selected
                                            </c:if>>
                                            Bilhete de Identidade
                                        </option>
                                        <option value="Cartão de Cidadão" <c:if
                                            test="${user.getDocumentType().equals('Cartão de Cidadão')}"> selected
                                            </c:if>>
                                            Cartão de Cidadão
                                        </option>
                                        <option value="Passaporte" <c:if
                                            test="${user.getDocumentType().equals('Passaporte')}">
                                            selected</c:if>>
                                            Passaporte
                                        </option>
                                        <p class="msg-error">${errorMsgDocumentType}</p>
                                    </select>
                                </div>
                                <div class="cell-row">
                                    <label for="nrDocumento_id">Nº do Documento *</label>
                                    <input id="nrDocumento_id" type="text" class="form-input" pattern="[0-9]{8}"
                                        value="${user.getDocumentNumber()}" name="documentNumber" required
                                        placeholder="Nº do documento selecionado" />
                                    <p class="msg-error">${errorMsgDocumentNumber}</p>
                                </div>
                            </div>

                            <div class="perfil-row">
                                <div class="cell-row">
                                    <label for="nif_id">NIF *</label>
                                    <input id="nif_id" type="text" pattern="[0-9]{9}" class="form-input"
                                        value="${user.getNif()}" name="nif" required placeholder="NIF" />
                                    <p class="msg-error">${errorMsgNif}</p>
                                </div>
                                <div class="cell-row">
                                    <label for="nrUtente_id">Nº de Utente</label>
                                    <input id="nrUtente_id" type="text" pattern="[0-9]{9}" class="form-input"
                                        value="${user.getPatientNumber()}" name="patientNumber"
                                        placeholder="Nº de Utente" />
                                    <p class="msg-error">${errorMsgPatientNumber}</p>
                                </div>
                            </div>

                            <div class="perfil-row">
                                <div class="cell-row cell-morada">
                                    <label for="e-mail_id">E-mail *</label>
                                    <input id="e-mail_id" type="email" class="form-input" value="${user.getEmail()}"
                                        name="email" required placeholder="E-mail" />
                                    <p class="msg-error">${errorMsgEmail}</p>
                                </div>
                            </div>
                            <div class="perfil-row">
                                <div class="cell-row">
                                    <label for="username_id">Username *</label>
                                    <input id="username_id" type="text" class="form-input" name="username" required
                                        placeholder="Username" value="${user.getUsername()}" />
                                    <p class="msg-error">${errorMsgUsername}</p>
                                </div>
                                <div class="cell-row">
                                    <label for="conta_id">Tipo de Utilizador *</label>
                                    <select id="conta_id" class="form-input" onchange="updateForm(this.value)"
                                        name="account" required>
                                        <option value="" disabled <c:if test="${empty user.getAccount()}"> selected
                                            </c:if>>Escolha uma Opção</option>
                                        <option value="Utente" <c:if test="${user.getAccount().equals('Utente')}">
                                            selected</c:if>>Utente
                                        </option>
                                        <option value="Médico" <c:if
                                            test="${user.getAccount().equals('Médico')}"> selected</c:if>>Médico
                                        </option>
                                        <option value="Recepcionista" <c:if
                                            test="${user.getAccount().equals('Recepcionista')}"> selected</c:if>
                                            >Recepcionista</option>
                                    </select>
                                    <p class="msg-error">${errorMsgAccount}</p>
                                </div>

                            </div>

                            <div class="perfil-row hidden" id="med">
                                <div class="cell-row">
                                    <label for="nrCedulaProfissional_id">Nº Cédula Profissional </label>
                                    <input id="nrCedulaProfissional_id" type="text" class="form-input"
                                        name="licenseNumber" placeholder="Nº Cédula Profissional"
                                        value="${doctor.getLicenseNumber()}" />
                                    <p class="msg-error">${errorMsgLicenseNumber}</p>
                                </div>

                                <div class="cell-row">
                                    <label for="especialidade_id">Especialidade </label>
                                    <select id="especialidade_id" class="form-input" name="specialityName">
                                        <option value="" disabled <c:if test="${empty speciality}">
                                            selected
                                            </c:if>>
                                            Especialidade
                                        </option>
                                        <!-- For -->
                                        <c:forEach var="speciality" items="${specialities}">
                                            <option value="${speciality.getName()}" <c:if
                                                test="${doctor.getSpeciality().getName().equals(speciality.getName())}">
                                                selected
                                                </c:if>>
                                                ${speciality.getName()}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="perfil-row">
                                <div class="cell-row">
                                    <label for="password_id">Palavra-Passe *</label>
                                    <input id="password_id" type="password" class="form-input" minlength="1"
                                        maxlength="15" value="${user.getPassword()}" name="password" required
                                        placeholder="Palavra-passe" />
                                    <p class="msg-error">${errorMsgPassword}</p>
                                </div>
                                <div class="cell-row">
                                    <label for="confirmarPassword_id">Confirmar Palavra-Passe *</label>
                                    <input id="confirmarPassword_id" type="password" class="form-input" minlength="1"
                                        maxlength="15" name="confirmarPassword2" required
                                        placeholder="Repetir palavra-passe" />
                                    <p class="msg-error">${errorMsgPassword2}</p>
                                </div>
                            </div>
                            <div>
                                <p class="nota">Autorização de recolha e tratamento de dados. </p>
                                <p class="nota">O Centro Hospital UPskill é a entidade responsável pela recolha e
                                    tratamento dos dados pessoais dos Utilizadores. </p>

                                <p class="nota">Os dados pessoais recolhidos serão conservados de forma a permitir a sua
                                    identificação apenas durante o período necessário para a prossecução das finalidades
                                    de recolha ou do tratamento posterior, findo o qual os mesmos serão eliminados. </p>

                                <p class="nota">O Utilizador assume que os dados recolhidos foram inseridos pelo respetivo
                                    titular e que a sua inserção foi autorizada pelo mesmo, sendo os mesmos verdadeiros
                                    e exatos.</p>

                                <p class="nota">Assinatura do Utilizador:</p>
                            </div>
                        </div>

                        <div class="perfil-row">
                            <div class="cell-row">
                                <button type="submit" class="btn btn-blue"
                                    onclick="javascript: form.action='/receptionist/imprimir';">Imprimir</button>
                            </div>
                            <div class="cell-row">
                                <button type="submit" class="btn btn-blue"
                                    onclick="javascript: form.action='/receptionist/add-user';">Adicionar
                                    Utilizador</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</body>

</html>