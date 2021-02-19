<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Centro Hospitalar UPskill</title>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous" />

    <script src="https://kit.fontawesome.com/6afe83edf7.js" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="style.css" />
    <link rel="icon" href="favicon.ico" type="image/x-icon">

</head>

<body>
    <div class="container">

        <div class="sidenav">
            <!-- menu da esquerda -->

            <img src="imagens\noun_centro_hospitalar_logo.svg" alt="logo" class="logo" />

            <div class="welcome_box">
                <p id="bem-vindo"> Bem-vindo</p>
            </div>

            <div class="but-login">
                <button type="button" class="btn-green btn-login"> Login </button>
            </div>

            <div class="sidenav_row">
                <p id="acessos_rapidos">Acessos Rápidos</p>
                <button type="button" class="botao_acessos">
                    <img src="imagens/noun_information.svg" /> Informações gerais
                </button>
                <button type="button" class="botao_acessos">
                    <img src="imagens/noun_calendar.svg" /> Calendário de vagas
                </button>
                <button type="button" class="botao_acessos">
                    <img src="imagens/noun_phone.svg" /> Contactos
                </button>
            </div>

            <div class="sidenav_row log_out_box2">
                <img src="imagens/noun_upskill.png" alt="" id="upskill_logo2" />
                <hr />
            </div>

        </div>


        <div class="main">
            <!--menu da direita-->

            <div class="row first_row">

                <div class="col-4">
                    <img src="imagens/noun_icon_01.svg" alt="" class="icon1" />
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

                <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">

                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="imagens/noun_news2.png" class="d-block w-100" alt="..." />
                        </div>
                        <div class="carousel-item">
                            <img src="imagens/noun_newssns.png" class="d-block w-100" alt="..." />
                        </div>
                        <div class="carousel-item">
                            <img src="'imagens/noun_news2.png'" class="d-block w-100" alt="..." />
                        </div>
                    </div>

                    <button class="carousel-control-prev seta" type="button" data-bs-target="#carouselExampleControls"
                        data-bs-slide="prev">
                        <i class="fas fa-less-than simbolo_seta"></i>
                    </button>

                    <button class="carousel-control-next seta" type="button" data-bs-target="#carouselExampleControls"
                        data-bs-slide="next">
                        <i class="fas fa-greater-than simbolo_seta"></i>
                    </button>

                </div>

            </div>
        </div>
    </div>
</body>

</html>