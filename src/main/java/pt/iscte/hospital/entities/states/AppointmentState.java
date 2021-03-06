package pt.iscte.hospital.entities.states;

public enum AppointmentState {
    MARCADA(1, "Marcada"),
    DESMARCADA_PELO_UTENTE(2, "Desmarcada pelo Utente"),
    DESMARCADA_PELO_MEDICO(3, "Desmarcada pelo Médico"),
    REALIZADA(4, "Realizada"),
    NAO_REALIZADA(5, "Não realizada");

    // Attributes
    private int stateNr;
    private String description;

    // Constructor
    AppointmentState(int stateNr, String description) {
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
