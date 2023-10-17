package br.com.admtariff.dto;

import lombok.Data;

@Data
public class AdmTariffTableDTO {
    private double lowerLimit;
    private double upperLimit;
    private double price;
}