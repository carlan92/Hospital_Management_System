package pt.iscte.hospital.entities.states;

public enum InvoiceState {
    PAGA(1, "Paga"),
    NAO_FACTURADA(2, "Não paga");


    // Attributes
    private final int stateNr;
    private final String description;

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

    public static String searchState(int stateNr) {
        for (InvoiceState invoiceState : InvoiceState.values()) {
            if (invoiceState.getStateNr() == stateNr) {
                return invoiceState.description;
            }
        }
        return null;
    }
}
