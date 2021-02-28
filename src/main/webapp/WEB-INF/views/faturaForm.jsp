<!DOCTYPE html>
<html lang="en">

<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="components/head.jsp" %>
</head>

<body>

	<%@ include file="components/sidenav-main.jsp" %>

	<div class="main">
		<!--Form da direita-->

		<div class="white_box box-align-left">
			<div class="invoiceimg">
			<img src="imagens\draw_invoice.png" alt="logo" class="invoiceimg"/>
			</div>
			<h3 class="registo">
				Formulário Fatura
			</h3>
			<form class="registry-form" action="/registar" method="get">


				<div class="perfil-main-col">

					<div class="perfil-row">
						<div class="cell-row">
							<label for="nomeUtente_id">Nome</label>
							<input id="nomeUtente_id" type="text" class="form-input" name="nomeUtente" required
								placeholder="Nome do Utente" />
							<p class="msg-error">Nome inválido</p>

						</div>


						<div class="cell-row">
							<label for="nrUtente_id">Nº de Utente</label>
							<input id="nrUtente_id" type="text" class="form-input" name="nrUtente"
								placeholder="Nº de Utente" />
							<p class="msg-error">Número Invalido</p>
						</div>
					</div>

					<div class="perfil-row">

						<div class="cell-row">
							<label for="nifUtente_id">NIF</label>
							<input id="nifUtente_id" type="text" class="form-input" name="nifUtente" required
								placeholder="NIF do Utente" />
							<p class="msg-error">NIF inválido</p>
						</div>


						<div class="cell-row">
							<label for="dataDeFatura_id">Data da Fatura</label>
							<input id="dataDeFatura_id" type="date" class="form-input" name="dataDeFatura" required>
						</div>
					</div>

					<div class="perfil-row">
						<div class="cell-row">
							<label for="morada_id">Morada do Utente</label>
							<input id="morada_id" type="text" class="form-input" name="morada"
								placeholder="Morada do Utente" />
						</div>



						<div class="cell-row">
							<label for="codigoPostal_id">Código Postal do Utente</label>
							<input id="codigoPostal_id" type="text" class="form-input" name="codigoPostal"
								placeholder="Código Postal do Utente" />
						</div>

					</div>

					<div class="perfil-row">
						<div class="cell-row">
							<label for="documento_id">Documento de Identificação</label>
							<select id="documento_id" class="form-input" name="documento" required>
								<option value="escolha uma opção" disabled selected>Escolha uma Opção</option>
								<option value="BI">Bilhete de Identidade</option>
								<option value="CC">Cartão de Cidadão</option>
								<option value="Passaporte">Passaporte</option>
							</select>
						</div>
						<div class="cell-row">
							<label for="nrDocumento_id">Nº do Documento</label>
							<input id="nrDocumento_id" type="text" class="form-input" name="nrDocumento" required
								placeholder="Nº do documento selecionado" />
						</div>
					</div>

					<div class="perfil-row">
						<div class="cell-row cell-morada">
							<label for="especialidade_id">Especialidade</label>
							<select id="especialidade_id" class="big-form-input" name="especialidade" multiple>
								<option value="especialidade" disabled selecte> Especialidade utilizada pelo utente
								</option>
								<option value="AP">Anatomia Patológica</option>
								<option value="AN">Anestesiologia</option>
								<option value="ACV">Angiologia e Cirurgia Vascular</option>
								<option value="CD">Cardiologia</option>
								<option value="CC">Cirurgia Cardíaca</option>
								<option value="CCT">Cirurgia Cardiotorácica</option>
								<option value="CG">Cirurgia Geral</option>
								<option value="CMF">Cirurgia Maxilo-Facial</option>
								<option value="CPD">Cirurgia Pediátrica</option>
								<option value="CPR">Cirurgia Plástica Reco. e Est.</option>
								<option value="CT">Cirurgia Torácica</option>
								<option value="DV">Dermato-Venereologia</option>
								<option value="DI">Doenças Infecciosas</option>
								<option value="EN">Endocrinologia e Nutrição</option>
								<option value="EST">Estomatologia</option>
								<option value="FC">Farmacologia Clínica</option>
								<option value="GTL"> Gastrenterologia</option>
								<option value="GM">Genética Médica</option>
								<option value="GO">Ginecologia/Obstetrícia</option>
								<option value="HC">Hematologia Clínica</option>
								<option value="IA">Imunoalergologia</option>
								<option value="IH">Imunohemoterapia</option>
								<option value="MD">Medicina Desportiva</option>
								<option value="MT">Medicina do Trabalho</option>
								<option value="MFR">Medicina Física e de Reabilitação</option>
								<option value="MGF">Medicina Geral e Familiar</option>
								<option value="MI">Medicina Intensiva</option>
								<option value="MIT">Medicina Interna</option>
								<option value="ML">Medicina Legal</option>
								<option value="MN">Medicina Nuclear</option>
								<option value="MT">Medicina Tropical</option>
								<option value="NFL">Nefrologia</option>
								<option value="NC">Neurocirurgia</option>
								<option value="NL">Neurologia</option>
								<option value="NR">Neurorradiologia</option>
								<option value="OFT">Oftalmologia</option>
								<option value="OM">Oncologia Médica</option>
								<option value="OR">Ortopedia</option>
								<option value="OTR">Otorrinolaringologia</option>
								<option value="PC">Patologia Clínica</option>
								<option value="PED">Pediatria</option>
								<option value="PNE">Pneumologia</option>
								<option value="PSI">Psiquiatria</option>
								<option value="PIA">Psiquiatria da Infância e da Adolescência</option>
								<option value="RAD">Radiologia</option>
								<option value="RAO">Radioncologia</option>
								<option value="RMT">Reumatologia</option>
								<option value="SP">Saúde Pública</option>
								<option value="URL">Urologia</option>


							</select>
						</div>

					</div>
					<p class="help-form">Utilize "ctrl" (Windows) ou "command" (Mac) para selecionar várias opções.</p>

					<div class="perfil-row">
						<div class="cell-row cell-morada">
							<label for="serviço_id">Serviço</label>
							<select id="serviço_id" class="big-form-input" name="serviço" multiple>
								<option value="serviço" disabled selected>Serviço utilizado pelo utente</option>
								<option value="AC">Análises Clínicas</option>
								<option value="CIR">Cirurgia</option>
								<option value="CSL">Consulta</option>
								<option value="ED">Exames Diagnóstico</option>
								<option value="INT">Internamento</option>
							</select>
						</div>
					</div>
					<p class="help-form">Utilize "ctrl" (Windows) ou "command" (Mac) para selecionar várias opções.</p>

					<div class="perfil-row">
						<div class="cell-row">
							<label for="valorfat_id">Valor Total</label>
							<input id="valorfat_id" type="text" class="form-input" name="valorfat"
								placeholder="Valor Total da Fatura" />
						</div>
					</div>

					<div class="margin-form">
						<button type="submit" class="btn btn-blue" value="criarConta">Criar Fatura</button>
					</div>

			</form>

		</div>
	</div>

</body>

</html>