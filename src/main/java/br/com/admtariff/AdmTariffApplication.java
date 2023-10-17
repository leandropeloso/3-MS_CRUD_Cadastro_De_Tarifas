package br.com.admtariff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.ecommit.azurecommonslib", "br.com.admtariff"})
public class AdmTariffApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdmTariffApplication.class, args);
    }
}
