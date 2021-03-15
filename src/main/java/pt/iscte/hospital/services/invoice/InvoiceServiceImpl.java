package pt.iscte.hospital.services.invoice;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class InvoiceServiceImpl implements InvoiceService {
    // Attributes
    public static final long COMPANY_NIF = 565486995;
    public static final String BASE_URL = "https://serro.pt";
    public static final String CREATE_URL = "/invoices/%s/create";      // %s company_nif
    public static final String GET_URL = "/invoices/%s/get/%s";         // %s company_nif, %s invoice_id
    public static final String INFO_URL = "/invoices/%s/info/%s";       // %s company nif, %s invoice_id
    public static final String PAY_URL = "/invoices/%s/pay/%s";         // %s company nif, %s invoice_id
    public static final String LIST_URL = "/invoices/%s/list";          // %s company nif

    // Methods
    /**
     * Criar factura <br>
     * /invoices/:company_nif/create <br>
     *
     * @param name         Nome do cliente
     * @param email        Email do cliente
     * @param nif          NIF do cliente
     * @param dueDate      Date<ISO8601> Data de Vencimento
     * @param value        Valor em euros total [opcional ou null]
     * @param invoiceItems Lista de itens com {description, value} [opcional ou null]
     */
    @Override
    public InvoiceApi createInvoice(String name,
                                    String email,
                                    long nif,
                                    LocalDateTime dueDate,
                                    Double value,
                                    List<InvoiceItem> invoiceItems) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // create body
        JSONObject invoiceRequest = new JSONObject();
        invoiceRequest.put("name", name);
        invoiceRequest.put("email", email);
        invoiceRequest.put("nif", nif);
        invoiceRequest.put("duedate", df.format(dueDate));
        if (value != null) {
            invoiceRequest.put("value", value);
        } else {
            invoiceRequest.put("items", invoiceItems);
        }

        // request url
        String requestUrl = BASE_URL + String.format(CREATE_URL, COMPANY_NIF);

        // request
        InvoiceResponse response;
        try {
            response = restTemplate.postForObject(
                    requestUrl,
                    new HttpEntity<>(invoiceRequest.toString(), headers),
                    InvoiceResponse.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println(e.getStatusCode().value());
            System.out.println(e.getMessage());
            return null;
        } catch (UnknownHttpStatusCodeException e) {
            return null;
        }

        if (response == null || response.getStatus().equals("error")) {
            return null;
        }

        return response.getInvoice();
    }

    /**
     * Visualizar factura <br>
     * /invoices/:company_nif/get/:invoice_id
     *
     * @param invoiceId Invoice ID from the Invoice API.
     * @return String with the Invoice page at the Invoice API.
     */
    @Override
    public String getInvoiceUrl(String invoiceId) {
        return BASE_URL + String.format(GET_URL, COMPANY_NIF, invoiceId);
    }

    /**
     * Informação da Fatura <br>
     * /invoices/:company_nif/info/:invoice_id
     */
    @Override
    public InvoiceApi getInvoiceInfo(String invoiceId) {
        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // request url
        String requestUrl = BASE_URL + String.format(INFO_URL, COMPANY_NIF, invoiceId);

        // request
        InvoiceResponse response;
        try {
            response = restTemplate.getForObject(requestUrl, InvoiceResponse.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println(e.getStatusCode().value());
            System.out.println(e.getMessage());
            return null;
        } catch (UnknownHttpStatusCodeException e) {
            return null;
        }

        if (response == null || response.getStatus().equals("error")) {
            return null;
        }

        return response.getInvoice();
    }

    /**
     * Pagar Fatura <br>
     * /invoices/:company_nif/pay/:invoice_id
     *
     * @param invoiceId Invoice ID from the Invoice API.
     * @return true if payment register is successful, false otherwise.
     */
    @Override
    public boolean payInvoice(String invoiceId) {
        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // create body

        // request url
        String requestUrl = BASE_URL + String.format(PAY_URL, COMPANY_NIF, invoiceId);

        // request
        InvoiceResponse response = null;
        try {
            response = restTemplate.postForObject(requestUrl, new HttpEntity<>(headers), InvoiceResponse.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println(e.getStatusCode().value());
            System.out.println(e.getMessage());
            return false;
        } catch (UnknownHttpStatusCodeException e) {
            return false;
        }

        if (response == null || response.getStatus().equals("error")) {
            return false;
        }

        return true;
    }

    /**
     * Listar Faturas <br>
     * /invoices/:company_nif/list
     *
     * @param invoiceFilter Filter to apply to the API search.
     * @return Returns a list filtered.
     */
    @Override
    public List<InvoiceApi> getList(InvoiceFilter invoiceFilter) {
        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String filters = invoiceFilter.filtros();

        // request url
        String requestUrl = BASE_URL + String.format(LIST_URL, COMPANY_NIF) + filters;

        // request
        InvoiceListResponse response;
        try {
            response = restTemplate.getForObject(requestUrl, InvoiceListResponse.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println(e.getStatusCode().value());
            System.out.println(e.getMessage());
            return new ArrayList<>();
        } catch (UnknownHttpStatusCodeException e) {
            return null;
        }

        if (response == null || response.getStatus().equals("error")) {
            return null;
        }

        return response.getInvoices();
    }
}
