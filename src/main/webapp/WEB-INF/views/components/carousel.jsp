<head>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
</head>

<div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">

    <div class="carousel-inner">
        <div class="carousel-item active" data-interval="10000">
            <img src="/imagens/pub_1.png" class="d-block w-100" alt="First slide"/>
        </div>
        <div class="carousel-item">
            <img src="/imagens/pub_2.png" class="d-block w-100" alt="Second slide"/>
        </div>
        <div class="carousel-item">
            <img src="/imagens/pub_3.png" class="d-block w-100" alt="Third slide"/>
        </div>
        <div class="carousel-item ">
            <img src="/imagens/pub_4.png" class="d-block w-100" alt="Fourth slide"/>
        </div>
        <div class="carousel-item">
            <img src="/imagens/pub_5.png" class="d-block w-100" alt="Fifth slide"/>
        </div>
        <div class="carousel-item">
            <img src="/imagens/pub_6.png" class="d-block w-100" alt="Sixth slide"/>
        </div>
        <div class="carousel-item">
            <img src="/imagens/pub_7.png" class="d-block w-100" alt="Seventh slide"/>
        </div>
        <div class="carousel-item">
            <img src="/imagens/pub_8.png" class="d-block w-100" alt="Eighth slide"/>
        </div>
    </div>

    <a class="carousel-control-prev seta" href="#carouselExampleInterval" role="button" data-slide="prev">
        <i class="fas fa-less-than simbolo_seta"></i>
    </a>

    <a class="carousel-control-next seta" href="#carouselExampleInterval" role="button" data-slide="next">
        <i class="fas fa-greater-than simbolo_seta"></i>
    </a>

</div>
<script>

    $('.carousel').carousel();
</script>