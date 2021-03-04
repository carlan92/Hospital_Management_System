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
                            <img src="imagens/pub_1.png" class="d-block w-100" alt="First slide" />
                        </div>
                        <div class="carousel-item">
                            <img src="imagens/pub_2.png" class="d-block w-100" alt="Second slide" />
                        </div>
                        <div class="carousel-item">
                            <img src="imagens/pub_3.png" class="d-block w-100" alt="Third slide" />
                        </div>
                        <div class="carousel-item ">
                            <img src="imagens/pub_4.png" class="d-block w-100" alt="Fourth slide" />
                        </div>
                        <div class="carousel-item">
                            <img src="imagens/pub_5.png" class="d-block w-100" alt="Fifth slide" />
                        </div>
                        <div class="carousel-item">
                            <img src="imagens/pub_6.png" class="d-block w-100" alt="Sixth slide" />
                        </div>
                        <div class="carousel-item">
                            <img src="imagens/pub_7.png" class="d-block w-100" alt="Seventh slide" />
                        </div>
                        <div class="carousel-item">
                            <img src="imagens/pub_8.png" class="d-block w-100" alt="Eighth slide" />
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