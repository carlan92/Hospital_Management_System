package pt.iscte.hospital.services;

public enum ErrorMessage {
    // User validation message error
    ERROR_MESSAGE_NAME("Nome inválido"),
    ERROR_MESSAGE_SEX("Escolha uma opção válida"),
    ERROR_MESSAGE_BIRTHDAY("Data inválida"),
    ERROR_MESSAGE_ADDRESS("Endereço inválido"),
    ERROR_MESSAGE_POST_CODE("Código postal inválido"),
    ERROR_MESSAGE_CITY("Nome de cidade inválida"),
    ERROR_MESSAGE_NATIONALITY("Escolha uma opção válida"),
    ERROR_MESSAGE_DOCUMENT_TYPE("Escolha uma opção válida"),
    ERROR_MESSAGE_DOCUMENT_NUMBER2("Numero de documento já existe"),
    ERROR_MESSAGE_DOCUMENT_NUMBER("Número de documento inválido"),
    ERROR_MESSAGE_NIF("NIF inválido"),
    ERROR_MESSAGE_NIF2("NIF já existe"),
    ERROR_MESSAGE_PATIENT_NUMBER2("Numero de utente já existe"),
    ERROR_MESSAGE_PATIENT_NUMBER("Número de utente inválido"),
    ERROR_MESSAGE_PHONE("Número de telemóvel inválido"),
    ERROR_MESSAGE_PASSWORD("Password inválida"),
    ERROR_MESSAGE_PASSWORD2("Password não coincide"),
    ERROR_MESSAGE_EMAIL("Este endereço já se encontra em utilização"),
    ERROR_MESSAGE_EMAIL2("Email inválido"),
    ERROR_MESSAGE_USERNAME("Username já existe"),
    ERROR_MESSAGE_ACCOUNT("Tipo de conta inválida"),
    ERROR_MESSAGE_LICENSE_NUMBER("Numéro de cédula profissional inválido"),
    ERROR_MESSAGE_SPECIALITY("Nome de especialidade inválido"),

    // Photo Image validation message error
    PHOTO_UPLOAD("Erro ao fazer upload da imagem"),
    IMAGE_TYPE("Formato da imagem inválido. Usar jpg ou png."),
    IMAGE_SIZE("Tamanho máximo permitido para a foto é de %d MB"), // %d placehoder for an integer or long number

    // Specialty  validation message error
    SPECIALITY_NAME("Já existe essa especialidade"),
    SPECIALITY_PRICE("Valor inválido"),
    SPECIALITY_LENGTH("Nome de especialidade demasiado curto");

    // Attributes
    private final String errorMsg;

    // Constructor
    ErrorMessage(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    // Methods
    public String getErrorMsg() {
        return errorMsg;
    }
}
