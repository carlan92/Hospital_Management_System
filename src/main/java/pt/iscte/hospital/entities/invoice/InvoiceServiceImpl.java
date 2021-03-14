package pt.iscte.hospital.entities.invoice;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class InvoiceServiceImpl implements InvoiceService {
    public static final long COMPANY_NIF = 565486995;
    public static final String BASE_URL = "https://serro.pt";
    public static final String CREATE_URL = "/invoices/%s/create";      // %s company_nif
    public static final String GET_URL = "/invoices/%s/get/%s";         // %s company_nif, %s invoice_id
    public static final String INFO_URL = "/invoices/%s/info/%s";       // %s company nif, %s invoice_id
    public static final String PAY_URL = "/invoices/%s/pay/%s";         // %s company nif, %s invoice_id
    public static final String LIST_URL = "/invoices/%s/list";          // %s company nif

    public static void main(String[] args) {
        InvoiceFilter filter = new InvoiceFilter();
        System.out.println(filter.toString());
        filter.setSearch("José");

        getList(filter);
        payInvoice("1e8de1e8-68fc-435f-9e87-c780de42212ee1");
    }

    public static void exp() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));

        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // create body
        JSONObject invoiceRequest = new JSONObject();
        invoiceRequest.put("name", "José Serro");
        invoiceRequest.put("email", "email@exemplo.pt");
        invoiceRequest.put("nif", "123456789");
        invoiceRequest.put("duedate", df.format(new Date()));
        invoiceRequest.put("value", "170");

        // request url
        String requestUrl = "https://serro.pt/invoices/565486995/create";

        // request
        InvoiceResponse response = restTemplate.postForObject(requestUrl, new HttpEntity<>(invoiceRequest.toString(), headers), InvoiceResponse.class);
        if (response == null || response.getStatus().equals("error")) {
            //TODO fazer qualquer coisa com o erro
            return;
        }
        System.out.println(response);

        Invoice invoice = response.getInvoice();
        System.out.println(invoice);
        //TODO fazer qualquer coisa com o invoice

    }

    // Criar factura
    // /invoices/:company_nif/create


    // Vizualizar factura
    // /invoices/:company_nif/get/:invoice_id


    // Informação da Fatura
    // /invoices/:company_nif/info/:invoice_id


    // Pagar Fatura
    // /invoices/:company_nif/pay/:invoice_id
    public static void payInvoice(String invoiceId) {
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
        } catch (HttpClientErrorException e){
            System.out.println(e.getStatusCode().value());
            System.out.println(e.getMessage());
        }

        if (response == null || response.getStatus().equals("error")) {
            //TODO fazer qualquer coisa com o erro

            return;
        }
        System.out.println(response);


        System.out.println(response.getStatus());

        //TODO fazer qualquer coisa com o invoice

    }


    // Listar Faturas
    // /invoices/:company_nif/list
    public static List<Invoice> getList(InvoiceFilter invoiceFilter) {
        // create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String filters = invoiceFilter.filtros();

        // request url
        String requestUrl = BASE_URL + String.format(LIST_URL, COMPANY_NIF) + filters;

        // request
        InvoiceListResponse response = restTemplate.getForObject(requestUrl, InvoiceListResponse.class);

        if (response == null || response.getStatus().equals("error")) {
            //TODO fazer qualquer coisa com o erro
            return new ArrayList<>();
        }
        System.out.println(response);

        //TODO fazer qualquer coisa com o invoice
        return response.getInvoices();
    }

}
