package pt.iscte.hospital.security;

public enum Role {
    ROLE_PATIENT("/patient/"),
    ROLE_EMPLOYEE("/employee/"),
    ROLE_DOCTOR("/doctor/"),
    ROLE_RECEPTIONIST("/receptionist/"),
    ROLE_UNIT_RESPONSIBLE("/unitresponsible/");

    private String mainPage;

    Role(String mainPage) {
        this.mainPage = mainPage;
    }

    public String getMainPage() {
        return mainPage;
    }
}
