package pt.iscte.hospital.services.invoice;

import pt.iscte.hospital.entities.Appointment;
import pt.iscte.hospital.entities.Invoice;
import pt.iscte.hospital.exceptions.PaymentException;

import java.time.LocalDateTime;
import java.util.List;

public interface InvoiceService {
    void createInvoice(Appointment appointment);

    void payInvoice(Appointment appointment) throws PaymentException;

    // Connection to Invoice API
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
    InvoiceApi createInvoiceAPI(String name,
                                    String email,
                                    long nif,
                                    LocalDateTime dueDate,
                                    Double value,
                                    List<InvoiceItem> invoiceItems);

    /**
     * Visualizar factura <br>
     * /invoices/:company_nif/get/:invoice_id
     *
     * @param invoiceId Invoice ID from the Invoice API.
     * @return String with the Invoice page at the Invoice API.
     */
    String getInvoiceUrlAPI(String invoiceId);

    /**
     * Informação da Fatura <br>
     * /invoices/:company_nif/info/:invoice_id
     */
    InvoiceApi getInvoiceInfoAPI(String invoiceId);

    /**
     * Pagar Fatura <br>
     * /invoices/:company_nif/pay/:invoice_id
     *
     * @param invoiceId Invoice ID from the Invoice API.
     * @return true if payment register is successful, false otherwise.
     */
    boolean payInvoiceAPI(String invoiceId);

    /**
     * Listar Faturas <br>
     * /invoices/:company_nif/list
     *
     * @param invoiceFilter Filter to apply to the API search.
     * @return Returns a list filtered.
     */
    List<InvoiceApi> getListAPI(InvoiceFilter invoiceFilter);

    Invoice findByInvoiceId (Long invoiceId);
}
