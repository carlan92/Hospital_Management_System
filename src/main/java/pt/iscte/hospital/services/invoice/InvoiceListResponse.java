package pt.iscte.hospital.services.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class InvoiceListResponse {
    private String status;
    private List<InvoiceApi> invoices;

    //getters e setters

}
