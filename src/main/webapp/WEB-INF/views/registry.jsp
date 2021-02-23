<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Centro Hospitalar UPskill</title>

    <link rel="stylesheet" href="style.css"/>

</head>

<body>
<div class="main">
    <div class="white_box">

        <img src="imagens\noun_centro_hospitalar_logo.svg" alt="logo" class="logo_small"/>
        <h3 class="registo">
            Registo de Utente
        </h3>
        <form class="registry-form" action="/registryToLogin" method="post" enctype="multipart/form-data">

            <div class="perfil-main-col">

                <div class="perfil-row">
                    <div class="cell-row cell-morada">
                        <label for="nome_id">Nome Completo *</label>
                        <input id="nome_id" type="text" class="form-input" name="name" required
                               placeholder="O seu nome completo" value=""/>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <label for="sexo_id">Sexo *</label>
                        <select id="sexo_id" class="form-input" name="sex" required>
                            <option value="" disabled selected>Escolha uma Opção</option>
                            <option value="Masculino">Masculino</option>
                            <option value="Feminino">Feminino</option>
                        </select>
                    </div>
                    <div class="cell-row">
                        <label for="dataDeNascimento_id">Data de Nascimento *</label>
                        <input id="dataDeNascimento_id" type="date" class="form-input" name="birthday"
                               required>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row cell-morada">
                        <label for="morada_id">Morada</label>
                        <input id="morada_id" type="text" class="form-input" name="address"
                               placeholder="A sua morada"/>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <label for="codigoPostal_id">Código Postal</label>
                        <input id="codigoPostal_id" type="text" class="form-input" name="postCode"
                               placeholder="O seu código postal"/>
                    </div>

                    <div class="cell-row">
                        <label for="localidade_id">Localidade *</label>
                        <input id="localidade_id" type="text" class="form-input" name="city" required
                               placeholder="A sua localidade"/>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <label for="conta_id">Tipo de Utilizador *</label>
                        <select id="conta_id" class="form-input" name="account" required>
                            <option value="" disabled selected>Escolha uma Opção</option>
                            <option value="Utente">Utente</option>
                            <option value="Funcionário">Funcionário</option>
                        </select>
                    </div>

                    <div class="cell-row">
                        <label for="nacionalidade_id">Nacionalidade *</label>
                        <select id="nacionalidade_id" class="form-input" name="nationality" required>
                            <option value="nacionalidade" disabled selected>A sua nacionalidade</option>
                            <option value="Portuguesa">Portuguesa</option>
                            <option value="Afegã">Afegã</option>
                            <option value="Albanesa">Albanesa</option>
                            <option value="Alemâ">Alemã</option>
                            <option value="Americana">Americana</option>
                            <option value="Andorrana">Andorrana</option>
                            <option value="Angolana">Angolana</option>
                            <option value="Antigua/Barbudiana">Antígua/Barbudiana</option>
                            <option value="Apátrida">Apátrida</option>
                            <option value="Árabe-emiradense">Árabe-emiradense</option>
                            <option value="Argelina">Argelina</option>
                            <option value="Argentina">Argentina</option>
                            <option value="Arménia">Arménia</option>
                            <option value="Australiana">Australiana</option>
                            <option value="Austríaca">Austríaca</option>
                            <option value="Azerbaijana">Azerbaijana/Azeri</option>
                            <option value="Bangladense">Bangladense</option>
                            <option value="Barbadiana">Barbadiana</option>
                            <option value="Barenita">Barenita</option>
                            <option value="Belga">Belga</option>
                            <option value="Belizenha">Belizenha</option>
                            <option value="Beninemse">Beninemse</option>
                            <option value="Bielorussa">Bielorussa</option>
                            <option value="Boliviana">Boliviana</option>
                            <option value="Bósnia">Bósnia</option>
                            <option value="Botsuanense">Botsuanense</option>
                            <option value="Brasileira">Brasileira</option>
                            <option value="Britânica">Britânica</option>
                            <option value="Bruneína">Bruneína</option>
                            <option value="Bulgara">Bulgara</option>
                            <option value="Burquinense">Burquinense</option>
                            <option value="Burundesa">Burundesa</option>
                            <option value="Butanesa">Butanesa</option>
                            <option value="Cabo-verdiana">Cabo-verdiana</option>
                            <option value="Camaronesa">Camaronesa</option>
                            <option value="Cambojana">Cambojana</option>
                            <option value="Canadiana">Canadiana</option>
                            <option value="Catariana">Catariana</option>
                            <option value="Cazaquistanesa">Cazaquistanesa</option>
                            <option value="Centro-africana">Centro-africana</option>
                            <option value="Chadiana">Chadiana</option>
                            <option value="Checa">Checa</option>
                            <option value="Chilena">Chilena</option>
                            <option value="Chinesa">Chinesa</option>
                            <option value="Cipriota">Cipriota</option>
                            <option value="Colombiana">Colombiana</option>
                            <option value="Comorense">Comorense</option>
                            <option value="Congolesa (Repíblica do Congo)">Congolesa (República do Congo)</option>
                            <option value="Congolesa (Rep. Democ. Congo)">Congolesa (Rep. Democ. Congo)</option>
                            <option value="Costa-riquenha">Costa-riquenha</option>
                            <option value="Croata">Croata</option>
                            <option value="Cubana">Cubana</option>
                            <option value="Desconhecida">Desconhecida</option>
                            <option value="Dinamarquesa">Dinamarquesa</option>
                            <option value="Djibutiana">Djibutiana</option>
                            <option value="Dominicana">Dominicana</option>
                            <option value="Dominiquense">Dominiquense</option>
                            <option value="Egípcia">Egípcia</option>
                            <option value="Equatoriana">Equatoriana</option>
                            <option value="Eritreia">Eritreia</option>
                            <option value="Eslovaca">Eslovaca</option>
                            <option value="Eslovena">Eslovena</option>
                            <option value="Espanhola">Espanhola</option>
                            <option value="Estoniana">Estoniana</option>
                            <option value="Etíope">Etíope</option>
                            <option value="Fijiana">Fijiana</option>
                            <option value="Filipina">Filipina</option>
                            <option value="Finlandesa">Finlandesa</option>
                            <option value="Francesa">Francesa</option>
                            <option value="Gabonesa">Gabonesa</option>
                            <option value="Gambiana">Gambiana</option>
                            <option value="Ganesa">Ganesa</option>
                            <option value="Georgiana">Georgiana</option>
                            <option value="Grega">Grega</option>
                            <option value="Grenada">Grenada</option>
                            <option value="Gronelandesa">Gronelandesa</option>
                            <option value="Guatemalense">Guatemalense</option>
                            <option value="Guianesa">Guianesa</option>
                            <option value="Guineense (Conacri)">Guineense (Conacri)</option>
                            <option value="Guineense (Equatorial)">Guineense (Equatorial)</option>
                            <option value="Guineense (Bissau)">Guineense (Bissau)</option>
                            <option value="Haitiana">Haitiana</option>
                            <option value="Neerlandesa/Holandesa">Neerlandesa/Holandesa</option>
                            <option value="Hondurenha">Hondurenha</option>
                            <option value="Húngara">Húngara</option>
                            <option value="Iemenita">Iemenita</option>
                            <option value="Indiana">Indiana</option>
                            <option value="Indonésia">Indonésia</option>
                            <option value="Iraniana">Iraniana</option>
                            <option value="Iraquiana">Iraquiana</option>
                            <option value="Irlandesa">Irlandesa</option>
                            <option value="Islandesa">Islandesa</option>
                            <option value="Israelita">Israelita</option>
                            <option value="Italiana">Italiana</option>
                            <option value="Jamaica">Jamaicana</option>
                            <option value="Japonesa">Japonesa</option>
                            <option value="Jordana">Jordana</option>
                            <option value="Kosovar">Kosovar</option>
                            <option value="Kuwaitiana">Kuwaitiana</option>
                            <option value="Laosiana">Laosiana</option>
                            <option value="Lesotiana">Lesotiana</option>
                            <option value="Letã">Letã</option>
                            <option value="Libanesa">Libanesa</option>
                            <option value="Liberiana">Liberiana</option>
                            <option value="Líbia">Líbia</option>
                            <option value="Liechtensteinense">Liechtensteinense</option>
                            <option value="Lituana">Lituana</option>
                            <option value="Luxemburguesa">Luxemburguesa</option>
                            <option value="Macedónia">Macedónia</option>
                            <option value="Madagascarense">Madagascarense</option>
                            <option value="Malásia">Malásia</option>
                            <option value="Malauiana">Malauiana</option>
                            <option value="Maldívia">Maldívia</option>
                            <option value="Malinesa">Malinesa</option>
                            <option value="Maltesa">Maltesa</option>
                            <option value="Marfinense">Marfinense</option>
                            <option value="Marroquina">Marroquina</option>
                            <option value="Mauriciana">Mauriciana</option>
                            <option value="Mauritana">Mauritana</option>
                            <option value="Mexicana">Mexicana</option>
                            <option value="Mianmarense/Birmã">Mianmarense/Birmã</option>
                            <option value="Moçambicana">Moçambicana</option>
                            <option value="Moldava">Moldava</option>
                            <option value="Monegasco">Monegasco</option>
                            <option value="Mongol">Mongol</option>
                            <option value="Montenegrina">Montenegrina</option>
                            <option value="Namibiana">Namibiana</option>
                            <option value="Nauruana">Nauruana</option>
                            <option value="Neozelandesa">Neozelandesa</option>
                            <option value="Nepalesa">Nepalesa</option>
                            <option value="Nicaraguana">Nicaraguana</option>
                            <option value="Nigeriana">Nigeriana</option>
                            <option value="Nigerina">Nigerina</option>
                            <option value="Norte-coreana">Norte-coreana</option>
                            <option value="Norueguesa">Norueguesa</option>
                            <option value="Omanense">Omanense</option>
                            <option value="Palauense">Palauense</option>
                            <option value="Palestiniana">Palestiniana</option>
                            <option value="Panamenha">Panamenha</option>
                            <option value="Papua">Papua</option>
                            <option value="Paquistanesa">Paquistanesa</option>
                            <option value="Paraguaia">Paraguaia</option>
                            <option value="Peruana">Peruana</option>
                            <option value="Polaca">Polaca</option>
                            <option value="Porto-riquenha">Porto-riquenha</option>
                            <option value="Queniana">Queniana</option>
                            <option value="Quirguistanesa">Quirguistanesa</option>
                            <option value="Quiribatiana">Quiribatiana</option>
                            <option value="Romena">Romena</option>
                            <option value="Ruandesa">Ruandesa</option>
                            <option value="Russa">Russa</option>
                            <option value="Sahari">Sahari</option>
                            <option value="Salvadorenha">Salvadorenha</option>
                            <option value="Samarinesa">Samarinesa</option>
                            <option value="Samoana">Samoana</option>
                            <option value="Santa-lucense">Santa-lucense</option>
                            <option value="Santomense">Santomense</option>
                            <option value="São-cristovense">São-cristovense</option>
                            <option value="São-vicentino">São-vicentino</option>
                            <option value="Saudita">Saudita</option>
                            <option value="Seichelense">Seichelense</option>
                            <option value="Senegalesa">Senegalesa</option>
                            <option value="Serra-leonesa">Serra-leonesa</option>
                            <option value="Sérvia">Sérvia</option>
                            <option value="Singapurana">Singapurana</option>
                            <option value="Síria">Síria</option>
                            <option value="Somali">Somalí</option>
                            <option value="Srilanquesa">Srilanquesa</option>
                            <option value="Suazilandesa">Suazilandesa</option>
                            <option value="Sudanesa">Sudanesa</option>
                            <option value="Sueca">Sueca</option>
                            <option value="Suíça">Suíça</option>
                            <option value="Sul-africana">Sul-africana</option>
                            <option value="Sul-coreana">Sul-coreana</option>
                            <option value="Surinamesa">Surinamesa</option>
                            <option value="Tailandesa">Tailandesa</option>
                            <option value="Taiwanesa">Taiwanesa</option>
                            <option value="Tajiquistanesa">Tajiquistanesa</option>
                            <option value="Tanzaniana">Tanzaniana</option>
                            <option value="Timorense">Timorense</option>
                            <option value="Togolesa">Togolesa</option>
                            <option value="Tonganesa">Tonganesa</option>
                            <option value="Trindade e Tobago">Trindade e Tobago</option>
                            <option value="Tunisina">Tunisina</option>
                            <option value="Turca">Turca</option>
                            <option value="Turquemenistanesa">Turquemenistanesa</option>
                            <option value="Tuvaluana">Tuvaluana</option>
                            <option value="Ucraniana">Ucraniana</option>
                            <option value="Ugandesa">Ugandesa</option>
                            <option value="Uruguaia">Uruguaia</option>
                            <option value="Usbequistanesa">Usbequistanesa</option>
                            <option value="Vanuatuana">Vanuatuana</option>
                            <option value="Venezuelana">Venezuelana</option>
                            <option value="Vietnamita">Vietnamita</option>
                            <option value="Zambiana">Zambiana</option>
                            <option value="Zimbabueana">Zimbabueana</option>
                        </select>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <label for="documento_id">Documento de Identificação *</label>
                        <select id="documento_id" class="form-input" name="documentType" required>
                            <option value="escolha uma opção" disabled selected>Escolha uma Opção</option>
                            <option value="BI">Bilhete de Identidade</option>
                            <option value="CC">Cartão de Cidadão</option>
                            <option value="Passaporte">Passaporte</option>
                        </select>
                    </div>
                    <div class="cell-row">
                        <label for="nrDocumento_id">Nº do Documento *</label>
                        <input id="nrDocumento_id" type="text" class="form-input" name="documentNumber" required
                               placeholder="Nº do documento selecionado"/>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <label for="nif_id">NIF *</label>
                        <input id="nif_id" type="text" class="form-input" name="nif" required placeholder="NIF"/>
                    </div>
                    <div class="cell-row">
                        <label for="nrUtente_id">Nº de Utente</label>
                        <input id="nrUtente_id" type="text" class="form-input" name="patientNumber"
                               placeholder="Nº de Utente"/>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <label for="telemovel_id">Telemóvel *</label>
                        <input id="telemovel_id" type="text" class="form-input" name="phone" required
                               placeholder="O seu número de telemóvel"/>
                    </div>
                    <div class="cell-row">
                        <label for="e-mail_id">E-mail *</label>
                        <input id="e-mail_id" type="text" class="form-input" name="email" required
                               placeholder="O seu e-mail"/>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <label for="username_id">Username *</label>
                        <input id="username_id" type="text" class="form-input" name="username" required
                               placeholder="Introduza o username" value=""/>
                    </div>
                    <div class="cell-row">
                        <label for="foto_perfil_id">Foto de perfil</label>
                        <input type="file" name="file"/>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">
                        <label for="password_id">Palavra-Passe *</label>
                        <input id="password_id" type="password" class="form-input" name="password" required
                               placeholder="Palavra-passe"/>
                    </div>
                    <div class="cell-row">
                        <label for="confirmarPassword_id">Confirmar Palavra-Passe *</label>
                        <input id="confirmarPassword_id" type="password" class="form-input" name="password2"
                               required placeholder="Repetir palavra-passe"/>
                    </div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row cell-morada">
                        <input id="termos_id" type="checkbox" name="termos" required/>
                        <label for="termos_id"> Declaro que aceito os
                            <a href="termsandconditions.html" target="_blank" class="link">termos e
                            condições</a> *</label>
                        <p class="nota">* campos de preenchimento obrigatório</p>
                    </div>
                </div>


            </div>
            <button type="submit" class="btn btn-blue">Criar Conta</button>
        </form>


    </div>
</div>
</body>

</html>