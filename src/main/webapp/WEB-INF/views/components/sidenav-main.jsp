<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<div class="sidenav">
		<!-- menu da esquerda RECEPCIONISTA-->l

		<img src="imagens/noun_centro_hospitalar_logo.svg" alt="logo" class="logo" />

		<div class="welcome_box">
			<div class="perfil-row">
				<div class="col-4 user_photo">
					<img src="imagens/draw_doctor.svg" alt="user_photography" />
				</div>
				<div class="col user_info">
					<p id="welcome">Bem-vindo</p>
					<a id="user_name" href="/user">${user.getFirstAndLastName()}</a>
					<p id="user_category">${user.getAccount()}</p>
				</div>
			</div>
			<div>
				<a type="button" href="/user" class="btn-green btn-w70"> Ver Perfil </a>
			</div>
		</div>

		<div class="panel-scroll">
			<div class="sidenav_row">
				<a href="/main" class="botao_acessos">
					<img src="imagens/noun_home.svg" /> Início
				</a>
				<a href="/lista-utentes" class="botao_acessos">
					<img src="imagens/noun_utentes.svg" /> Utentes
				</a>
				<button type="button" class="">
					<img src="imagens/noun_doctor.svg" /> Médicos
				</button>
				<button type="button" class="">
					<img src="imagens/noun_heart rate.svg" /> Consultas
				</button>
			</div>

			<div class="sidenav_row">
				<p id="acessos_rapidos">Acessos Rápidos</p>
				<button type="button" formaction="main/" formmethod="get" class="botao_acessos">
					<img src="imagens/noun_information.svg" /> Informações gerais
				</button>
				<button type="button" class="botao_acessos">
					<img src="imagens/noun_calendar.svg" /> Calendário de vagas
				</button>
				<button type="button" class="botao_acessos">
					<img src="imagens/noun_phone.svg" /> Contactos
				</button>
			</div>
		</div>

		<div class="sidenav_row log_out_box">
			<img src="imagens/noun_upskill.png" alt="" id="upskill_logo" />
			<hr />
			<form method="get" action="/logout">
				<button type="submit">
					<img src="imagens/noun_logout.svg" /> Terminar Sessão
				</button>
			</form>
		</div>
	</div>