package br.com.admtariff.exception;

public class AdmTariffNotFoundException extends RuntimeException {
    public AdmTariffNotFoundException(String message) {
        super(message);
    }
}