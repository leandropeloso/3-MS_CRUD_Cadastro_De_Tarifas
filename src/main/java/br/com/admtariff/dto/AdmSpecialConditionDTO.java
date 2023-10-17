package br.com.admtariff.dto;

import lombok.Data;

@Data
public class AdmSpecialConditionDTO {
    private double lowerLimit;
    private double upperLimit;
    private double percentageAbove;
    private double price;
}
