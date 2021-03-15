<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body>
<%@ include file="../components/sidenav-login.jsp" %>

<div class="main">
    <!--menu da direita-->

    <div class="row first_row">

        <div class="col-4">
            <img src="/imagens/noun_icon_01.svg" alt="" class="icon1"/>
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


    <div class="row middle-row2">

        <div class="col-3">
            <div class="card_box2">
                <div class="card2">
                    <div class="card-body2">
                        <h2>
                            <span>25</span>
                        </h2>
                        <h3>Hospitais e clínicas</h3>
                        <p> Em Portugal Continental e na Região Autónoma da Madeira</p>
                    </div>
                </div>
            </div>
        </div>


        <div class="col-3">
            <div class="card_box2">
                <div class="card2">
                    <div class="card-body2">
                        <h2>
                            <span>103</span>
                        </h2>
                        <h3>Serviços clínicos</h3>
                        <p>Para uma oferta abrangente e integral de cuidados</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-3">
            <div class="card_box2">
                <div class="card2">
                    <div class="card-body2">
                        <h2>
                            <span>3302</span>
                        </h2>
                        <h3>Médicos
                        </h3>
                        <p> E muitos outros profissionais de saúde para cuidar de si</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-3">
            <div class="card_box2">
                <div class="card2">
                    <div class="card-body2">
                        <h2>
                            <span>207</span>
                        </h2>
                        <h3>Acordos
                        </h3>
                        <p>Com seguradoras, sistemas de saúde e outras organizações</p>
                    </div>
                </div>
            </div>
        </div>

    </div>


    <div class="row last-row">

        <%@ include file="../components/carousel.jsp" %>

    </div>
</div>

</body>

</html>