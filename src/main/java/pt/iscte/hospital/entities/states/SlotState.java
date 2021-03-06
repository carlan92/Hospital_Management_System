package pt.iscte.hospital.entities.states;

public enum SlotState {
    DISPONIVEL(true, "Disponível"),
    INDISPONIVEL(false, "Indisponível");

    // Attributes
    private boolean isAvailable;
    private String description;

    // Constructor
    SlotState(boolean isAvailable, String description) {
        this.isAvailable = isAvailable;
        this.description = description;
    }

    // Methods
    public boolean isAvailable() {
        return isAvailable;
    }

    public String getDescription() {
        return description;
    }
}
