<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body>

<c:if test="${user_logged.getAccount().equals('Recepcionista')}">
    <%@ include file="../components/sidenav-receptionist.jsp" %>
</c:if>
<c:if test="${user_logged.getAccount().equals('Utente')}">
    <%@ include file="../components/sidenav-utente.jsp" %>
</c:if>

<div class="main">
    <!--Form da direita-->

    <div class="white_box box-align-left">
        <div class="row first_row">
            <div class="col-4">
                <img src="imagens/draw_invoice.png" alt="" class="icon1" />
            </div>
            <div class="col-8 intro">
                <h3 class="title_next_appt">Factura</h3>
            </div>
        </div>

        <div class="invoice-box">
            <table cellpadding="0" cellspacing="0">
                <tr class="top">
                    <td colspan="4">
                        <table>
                            <tr>
                                <td class="title">
                                    <img src="imagens/noun_centro_hospitalar_logo.svg" style="width:70%; max-width:300px;">
                                </td>

                                <td>
                                    Factura # <span>123</span>
                                    <br>
                                    <br>
                                    Emissão: <span>14-03-2021</span>
                                    <br>
                                    Vencimento: <span>14-03-2021</span>
                                    <br>
                                    Pagamento: <span>14-03-2021</span>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>

                <tr class="information">
                    <td colspan="4">
                        <table>
                            <tr>
                                <td>
                                    R. Retiro dos Pacatos 50
                                    <br>
                                    Edifício Startup,
                                    <br>
                                    2635-224 Rio de Mouro
                                </td>

                                <td>
                                    Jorge Rafael
                                    <br>
                                    111122223
                                    <br>
                                    jorge.rafael@exemplo.pt
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>

                <tr class="heading">
                    <td colspan="3">Item</td>
                    <td>Valor (€)</td>
                </tr>

                <tr class="details">
                    <td colspan="3">Serviço</td>
                    <td>50.00</td>
                </tr>

                <tr class="total">
                    <td colspan="3"></td>
                    <td>Total: 50.00€</td>
                </tr>
            </table>
        </div>

    </div>
</div>


</body>

</html>