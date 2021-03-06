<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body>

    <c:choose>
        <c:when test="${user_logged.getAccount().equals('Utente')}">
            <%@ include file="../components/sidenav-utente.jsp" %>
        </c:when>
        <c:when test="${user_logged.getAccount().equals('Recepcionista')}">
            <%@ include file="../components/sidenav-receptionist.jsp" %>
        </c:when>
        <c:when test="${user_logged.getAccount().equals('Médico')}">
            <%@ include file="../components/sidenav-medico.jsp" %>
        </c:when>
        <c:otherwise>
            <%@ include file="../components/sidenav-login.jsp" %>
        </c:otherwise>
    </c:choose>

    <div class="main">
      <!--menu da direita-->
      <div class="row first_row">
        <div class="col-4">
          <img src="/imagens/noun_contact.svg" alt="" class="icon1" />
        </div>
        <div class="col-8 intro">
          <h1>Contactos</h1>
          <p id="texto-intro">
            Selecione a sua localização e obtenha os contactos para poder falar connosco!
          </p>
        </div>
      </div>
      
      <div class="row middle-row">

        <div class="contactbox">
                
           <div class="contactbox1"> Selecione o centro Hospitalar UPskill mais perto da sua localização:</div>
         
           <div class="contactbox2">
        <select onchange="showAnswer(this.value)">
          <option value="ANH">Centro Hospitalar UPskill de Angra do Heroismo</option> 
          <option value="AVR">Centro Hospitalar UPskill de Aveiro</option>
          <option value="BJA">Clínica UPskill de Beja</option>
          <option value="BRG">Centro Hospitalar UPskill de Braga</option>
          <option value="CLD">Clínica UPskill das Caldas da Rainha</option>
          <option value="CTB">Centro Hospitalar UPskill de Castelo Branco</option>
          <option value="CMB">Centro Hospitalar UPskill de Coimbra</option>
          <option value="EVR">Centro Hospitalar UPskill de Évora</option>
          <option value="FAR">Centro Hospitalar UPskill de Faro</option>
          <option value="FIG">Clínica UPskill da Figueira da Foz</option>
          <option value="FNC">Centro Hospitalar UPskill do Funchal</option>
          <option value="GRD">Centro Hospitalar UPskill da Guarda</option>
          <option value="LRA">Centro Hospitalar UPskill de Leiria</option>
          <option value="LSB">Centro Hospitalar UPskill de Lisboa</option>
          <option value="MFR">Clínica UPskill de Mafra</option>
          <option value="NZR">Clínica UPskill da Nazaré</option>
          <option value="ODV">Clínica UPskill de Odivelas</option>
          <option value="PNI">Clínica UPskill de Peniche</option>
          <option value="PBL">Clínica UPskill de Pombal</option>
          <option value="PTM">Clínica UPskill de Portimão</option>
          <option value="PRT">Centro Hospitalar UPskill do Porto</option>
          <option value="RMR">Clínica UPskill de Rio Maior</option>
          <option value="STR">Centro Hospitalar UPskill de Santarém</option>
          <option value="STB">Clínica UPskill de Setúbal</option>
          <option value="SNT">Clínica UPskill de Sintra</option>
          <option value="TVD">Clínica UPskill de Torres Vedras</option>
          <option value="VNF">Clínica UPskill de Vila Nova de Famalicão</option>
          <option value="VIS">Centro Hospitalar UPskill de Viseu</option>


        </select>
      </div>
        <hr>
        
        <div id="answer">
           
        <script type="text/javascript">
                function showAnswer(id) {
          document.getElementById('answer').innerHTML = answers[id];
        }
        
        var answers = {
          ANH: 'Telefone: 295 123 123 | Email: geral.angra@hospital.upskill.pt',
          AVR: 'Telefone: 234 123 123 | Email: geral.aveiro@hospital.upskill.pt',
          BJA: 'Telefone: 284 123 123 | Email: geral.beja@hospital.upskill.pt',
          BRG: 'Telefone: 253 123 123 | Email: geral.braga@hospital.upskill.pt',
          CLD: 'Telefone: 262 123 123 | Email: geral.caldasrainha@hospital.upskill.pt',
          CTB: 'Telefone: 272 123 123 | Email: geral.castelobranco@hospital.upskill.pt',
          CMB: 'Telefone: 239 123 123 | Email: geral.coimbra@hospital.upskill.pt',
          EVR: 'Telefone: 266 123 123 | Email: geral.evora@hospital.upskill.pt',
          FAR: 'Telefone: 289 123 123 | Email: geral.faro@hospital.upskill.pt',
          FIG: 'Telefone: 233 123 123 | Email: geral.figueira@hospital.upskill.pt',
          FNC: 'Telefone: 291 123 123 | Email: geral.funchal@hospital.upskill.pt',
          GRD: 'Telefone: 271 123 123 | Email: geral.guarda@hospital.upskill.pt',
          LRA: 'Telefone: 244 123 123 | Email: geral.leiria@hospital.upskill.pt',
          LSB: 'Telefone: 21 123 123 1 | Email: geral.lisboa@hospital.upskill.pt',
          MFR: 'Telefone: 261 123 123 | Email: geral.mafra@hospital.upskill.pt',
          NZR: 'Telefone: 262 123 124 | Email: geral.nazare@hospital.upskill.pt',
          ODV: 'Telefone: 21 123 123 2 | Email: geral.odivelas@hospital.upskill.pt',
          PNI: 'Telefone: 262 123 125 | Email: geral.peniche@hospital.upskill.pt',
          PBL: 'Telefone: 236 123 123 | Email: geral.pombal@hospital.upskill.pt',
          PTM: 'Telefone: 282 123 123 | Email: geral.portimao@hospital.upskill.pt',
          PRT: 'Telefone: 22 123 123 1 | Email: geral.porto@hospital.upskill.pt',
          RMR: 'Telefone: 243 123 123 | Email: geral.riomaior@hospital.upskill.pt',
          STR: 'Telefone: 243 123 124 | Email: geral.santarem@hospital.upskill.pt',
          STB: 'Telefone: 265 123 123 | Email: geral.setubal@hospital.upskill.pt',
          SNT: 'Telefone: 21 123 123 3 | Email: geral.sintra@hospital.upskill.pt',
          TVD: 'Telefone: 261 123 124 | Email: geral.torresvedras@hospital.upskill.pt',
          VNF: 'Telefone: 252 123 123 | Email: geral.famalicao@hospital.upskill.pt',
          VIS: 'Telefone: 232 123 123 | Email: geral.viseu@hospital.upskill.pt'
         };
            </script>
      </div>
      </div>
      </div>
    </div>
</body>

</html>