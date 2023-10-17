package br.com.admtariff.exception;

public class DependencyException extends RuntimeException {
    public DependencyException(String message) {
        super(message);
    }
}