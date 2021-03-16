package pt.iscte.hospital.entities.states;

public enum AppointmentState {
    MARCADA(1, "Marcada"),
    EM_CURSO(2, "Consulta em curso"),
    DESMARCADA_PELO_UTENTE(3, "Desmarcada pelo Utente"),
    DESMARCADA_PELO_MEDICO(4, "Desmarcada pelo Médico"),
    REALIZADA(5, "Realizada"),
    NAO_REALIZADA(6, "Faltou à Consulta");

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

    public static String searchState(int stateNr){
        for (AppointmentState appointmentState:AppointmentState.values()) {
            if(appointmentState.getStateNr()==stateNr){
                return appointmentState.description;
            }
        }
        return null;
    }
}
