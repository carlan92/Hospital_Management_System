package pt.iscte.hospital.entities.states;

public enum InvoiceState {
    PAGA(1, "Paga"),
    NAO_FACTURADA(2, "Não paga");


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
