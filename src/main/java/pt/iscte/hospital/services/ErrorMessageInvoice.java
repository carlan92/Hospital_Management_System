package pt.iscte.hospital.services;

public enum ErrorMessageInvoice {
    ERROR_CREATE_400("Erro de validação."),
    ERROR_CREATE_404("Não foi possível encontrar informação com o NIF da empresa."),
    ERROR_GET_404("Não foi possível encontrar a factura."),
    ERROR_INFO_400("Não foi possível encontrar a factura."),
    ERROR_PAY_404("Não foi possível encontrar a factura."),
    ERROR_PAY_409("A factura já se encontra paga."),
    ERROR_LIST_404("Não foi possível encontrar informação com o NIF da empresa.");

    private final String msgError;

    ErrorMessageInvoice(String msgError) {
        this.msgError = msgError;
    }

    public String getMsgError() {
        return msgError;
    }

}
