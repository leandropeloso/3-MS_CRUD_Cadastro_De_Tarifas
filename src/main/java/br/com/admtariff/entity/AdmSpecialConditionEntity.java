package br.com.admtariff.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class AdmSpecialConditionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double lowerLimit;
    private double upperLimit;
    private double percentageAbove;
    private double price;

    @ManyToOne
    private AdmTariffEntity tariff;
}
