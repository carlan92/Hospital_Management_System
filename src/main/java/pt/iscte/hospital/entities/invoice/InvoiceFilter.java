package pt.iscte.hospital.entities.invoice;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
public class InvoiceFilter {
    private Long nif;                   // long            Filtrar por NIF do cliente
    private String status;              // <paid|unpaid> | Filtrar por status da fatura
    private LocalDate issuedBefore;     // Date<ISO8601> | Filtrar por data de emissão
    private LocalDate issuedAfter;      // Date<ISO8601> | Filtrar por data de emissão
    private LocalDate paidBefore;       // Date<ISO8601> | Filtrar por data de pagamento
    private LocalDate paidAfter;        // Date<ISO8601> | Filtrar por data de pagamento
    private LocalDate dueBefore;        // Date<ISO8601> | Filtrar por data de vencimento
    private LocalDate dueAfter;         // Date<ISO8601> | Filtrar por data de vencimento
    private String search;              // String        | Filtrar por texto nas descrições, nome, etc...

    public String filtros() {
        String filter = "?";

        if (nif != null) {
            filter += "nif=" + nif + "&";
        }
        if (status != null) {
            filter += "status=" + status;
        }
        if (issuedBefore != null) {
            filter += "issuedBefore=" + issuedBefore.toString() + "&";
        }
        if (issuedAfter != null) {
            filter += "issuedAfter=" + issuedAfter.toString() + "&";
        }
        if (paidBefore != null) {
            filter += "paidBefore=" + paidBefore.toString() + "&";
        }
        if (paidAfter != null) {
            filter += "paidAfter=" + paidAfter.toString() + "&";
        }
        if (dueBefore != null) {
            filter += "dueBefore=" + dueBefore.toString() + "&";
        }
        if (dueAfter != null) {
            filter += "dueAfter=" + dueAfter.toString() + "&";
        }
        if (search != null) {
            filter += "search=" + search;
        }
        return filter;
    }
}
