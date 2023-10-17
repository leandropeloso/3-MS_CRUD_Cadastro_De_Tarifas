package br.com.admtariff.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class AdmTariffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String module;
    private String date;

    @OneToMany(mappedBy = "tariff", cascade = CascadeType.ALL)
    private List<AdmTariffTableEntity> tables;

    @OneToMany(mappedBy = "tariff", cascade = CascadeType.ALL)
    private List<AdmAdditionalRecordEntity> additionalRecords;

    @OneToMany(mappedBy = "tariff", cascade = CascadeType.ALL)
    private List<AdmSpecialConditionEntity> specialConditions;
}





