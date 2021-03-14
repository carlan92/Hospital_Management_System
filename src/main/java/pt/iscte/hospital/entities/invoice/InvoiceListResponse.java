package pt.iscte.hospital.entities.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class InvoiceListResponse {
    private String status;
    private List<Invoice> invoices;

    //getters e setters

}
