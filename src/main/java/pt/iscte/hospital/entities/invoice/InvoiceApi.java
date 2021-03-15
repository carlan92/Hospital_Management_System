package pt.iscte.hospital.entities.invoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceApi {
    private String id;
    private String name;
    private String email;
    private long nif;
    private LocalDateTime dueDate;
    private LocalDateTime issuedDate;
    private LocalDateTime paidDate;
    private double value;
    private List<InvoiceItem> items;
    private String status;
    private String url;

    // Constructors

    // Methods
    // Getters e Setters made by Lombok
    public int getInvoiceState() {
        if (status.equals("paid")) {
            return 1;
        }
        return 2;
    }

}
