package pt.iscte.hospital.entities.invoice;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InvoiceResponse {
    private String status;
    private InvoiceApi invoice;

    //getters e setters

}
