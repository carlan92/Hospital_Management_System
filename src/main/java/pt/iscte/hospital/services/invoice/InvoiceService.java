package pt.iscte.hospital.services.invoice;

import java.time.LocalDateTime;
import java.util.List;

public interface InvoiceService {
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
    public InvoiceApi createInvoice(String name,
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
    public String getInvoiceUrl(String invoiceId);

    /**
     * Informação da Fatura <br>
     * /invoices/:company_nif/info/:invoice_id
     */
    InvoiceApi getInvoiceInfo(String invoiceId);

    /**
     * Pagar Fatura <br>
     * /invoices/:company_nif/pay/:invoice_id
     *
     * @param invoiceId Invoice ID from the Invoice API.
     * @return true if payment register is successful, false otherwise.
     */
    boolean payInvoice(String invoiceId);

    /**
     * Listar Faturas <br>
     * /invoices/:company_nif/list
     *
     * @param invoiceFilter Filter to apply to the API search.
     * @return Returns a list filtered.
     */
    List<InvoiceApi> getList(InvoiceFilter invoiceFilter);
}
