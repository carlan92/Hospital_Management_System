package pt.iscte.hospital.services.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class InvoiceItem {
    // Attributes
    private String description;
    private double value;

    // Constructor
    public InvoiceItem(){}

    public InvoiceItem(String description, double value) {
        this.description = description;
        this.value = value;
    }

    // Methods
    // Getters e Setters made by Lombok
}
