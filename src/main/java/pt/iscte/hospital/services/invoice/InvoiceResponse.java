package pt.iscte.hospital.services.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class InvoiceResponse {
    private String status;
    private InvoiceApi invoice;

    //getters e setters

}
