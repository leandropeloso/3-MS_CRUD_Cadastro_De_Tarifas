package br.com.admtariff.controller;

import br.com.admtariff.dto.AdmTariffDTO;
import br.com.admtariff.entity.AdmTariffEntity;
import br.com.admtariff.service.AdmTariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admTariffs")
public class AdmTariffController {
    private final AdmTariffService tariffService;

    @Autowired
    public AdmTariffController(AdmTariffService tariffService) {
        this.tariffService = tariffService;
    }

    @PostMapping
    public ResponseEntity<AdmTariffEntity> createAdmTariff(@RequestBody AdmTariffDTO tariffDTO) {
        AdmTariffEntity tariff = convertToEntity(tariffDTO);
        AdmTariffEntity createdTariff = tariffService.createAdmTariff(tariff);
        return new ResponseEntity<>(createdTariff, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AdmTariffEntity>> getAllAdmTariffs() {
        List<AdmTariffEntity> tariffs = tariffService.getAllAdmTariffs();
        return new ResponseEntity<>(tariffs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdmTariffEntity> getAdmTariffById(@PathVariable Long id) {
        AdmTariffEntity tariff = tariffService.getAdmTariffById(id);
        return new ResponseEntity<>(tariff, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmTariff(@PathVariable Long id) {
        tariffService.deleteAdmTariff(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private AdmTariffEntity convertToEntity(AdmTariffDTO tariffDTO) {
        AdmTariffEntity tariff = new AdmTariffEntity();
        tariff.setModule(tariffDTO.getModule());
        tariff.setDate(tariffDTO.getDate());

        return tariff;
    }
}