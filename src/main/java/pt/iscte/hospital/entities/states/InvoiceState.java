package pt.iscte.hospital.entities.states;

public enum InvoiceState {
    NAO_FACTURADA(1, "Não facturada"),
    FACTURADA(2, "Facturada"),
    AGUARDA_PAGAMENTO(3, "A aguardar pagamento"),
    PAGA(4, "Paga");

    // Attributes
    private int stateNr;
    private String description;

    // Constructor
    InvoiceState(int stateNr, String description) {
        this.stateNr = stateNr;
        this.description = description;
    }

    // Methods
    public int getStateNr() {
        return stateNr;
    }

    public String getDescription() {
        return description;
    }
}
