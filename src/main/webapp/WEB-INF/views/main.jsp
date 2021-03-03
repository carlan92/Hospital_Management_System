<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="components/head.jsp" %>
</head>

<body>
<%@ include file="components/sidenav-main.jsp" %>

<div class="main">
    <!--menu da direita-->
    <div class="row first_row">
        <div class="col-4">
            <img src="imagens/noun_icon_01.svg" alt="" class="icon1"/>
        </div>
        <div class="col-8 intro">
            <h1>CUIDE DE SI E DOS SEUS.</h1>
            <p id="texto-intro">
                O Centro Hospitalar UPskill inspira-se nos seus clientes para
                estar na vanguarda na proteção das famílias. Estamos mais
                inovadores na prestação de cuidados de saúde, mais próximos e mais
                ágeis.
            </p>
        </div>
    </div>

    <div id="vista_geral">
        VISTA GERAL
    </div>

    <div class="row middle-row">
        <div class="card_box">
            <div class="card">
                <div class="card-body">
                    <img src="imagens/noun_wait.svg" class="wait_list" alt="..."/>
                    <h5 class="utentes"><span id="num_utentes">4</span> UTENTES</h5>
                    <p class="linha_1">A AGUARDAR CONSULTAS</p>
                    <p class="linha_2">
                        <span id=num_atrasados>2</span> utentes estão atrasados
                    </p>
                    <a href="#" class="btn btn-button">VER LISTA DE ESPERA</a>
                </div>
                <div class="horizontal-border"></div>
            </div>
        </div>


        <div class="card_box">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">CHECK-IN</h5>
                    <p class="card-text">
                        Introduza o numero de consulta
                    </p>
                    <input type="text" id="num_consulta" placeholder="Nº de Consulta">
                    <a href="#" class="btn btn-button btn-2">EFETUAR CHECKIN > </a>
                </div>
                <div class="horizontal-border"></div>
            </div>
        </div>
    </div>

    <div class="row last-row">

        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">

            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="imagens/pub_1.png" class="d-block w-100" alt="First slide"/>
                </div>
                <div class="carousel-item">
                    <img src="imagens/pub_2.png" class="d-block w-100" alt="Second slide"/>
                </div>
                <div class="carousel-item">
                    <img src="imagens/pub_3.png" class="d-block w-100" alt="Third slide"/>
                </div>
                <div class="carousel-item ">
                    <img src="imagens/pub_4.png" class="d-block w-100" alt="Fourth slide"/>
                </div>
                <div class="carousel-item">
                    <img src="imagens/pub_5.png" class="d-block w-100" alt="Fifth slide"/>
                </div>
                <div class="carousel-item">
                    <img src="imagens/pub_6.png" class="d-block w-100" alt="Sixth slide"/>
                </div>
                <div class="carousel-item">
                    <img src="imagens/pub_7.png" class="d-block w-100" alt="Seventh slide"/>
                </div>
                <div class="carousel-item">
                    <img src="imagens/pub_8.png" class="d-block w-100" alt="Eighth slide"/>
                </div>
            </div>

            <a class="carousel-control-prev seta" href="#carouselExampleControls" role="button" data-slide="prev">
                <i class="fas fa-less-than simbolo_seta"></i>
            </a>

            <a class="carousel-control-next seta" href="#carouselExampleControls" role="button" data-slide="next">
                <i class="fas fa-greater-than simbolo_seta"></i>
            </a>

        </div>
    </div>
</div>

<script> $('.carousel').carousel()
</script>

</body>

</html>