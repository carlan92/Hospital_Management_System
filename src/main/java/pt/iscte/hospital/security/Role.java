package pt.iscte.hospital.security;

public enum Role {
    ROLE_PATIENT("/patient/main"),
    ROLE_EMPLOYEE("/employee/main"),
    ROLE_DOCTOR("/doctor/main"),
    ROLE_RECEPTIONIST("/receptionist/main"),
    ROLE_UNIT_RESPONSIBLE("/unitresponsible/main");

    private String mainPage;

    Role(String mainPage) {
        this.mainPage = mainPage;
    }

    public String getMainPage() {
        return mainPage;
    }
}
