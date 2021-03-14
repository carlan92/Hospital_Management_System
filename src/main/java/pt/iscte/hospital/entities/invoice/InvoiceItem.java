package pt.iscte.hospital.entities.invoice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
