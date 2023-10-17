package br.com.admtariff.dto;

import lombok.Data;

@Data
public class AdmAdditionalRecordDTO {
    private double lowerLimit;
    private double upperLimit;
    private double price;
}
