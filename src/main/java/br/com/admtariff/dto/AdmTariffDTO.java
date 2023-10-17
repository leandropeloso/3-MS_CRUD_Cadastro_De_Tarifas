package br.com.admtariff.dto;

import lombok.Data;

import java.util.List;

@Data
public class AdmTariffDTO {
    private String module;
    private String date;
    private List<AdmTariffTableDTO> tables;
    private List<AdmAdditionalRecordDTO> additionalRecords;
    private List<AdmSpecialConditionDTO> specialConditions;
}