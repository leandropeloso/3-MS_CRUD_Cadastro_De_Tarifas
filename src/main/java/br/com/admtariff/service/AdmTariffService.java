package br.com.admtariff.service;

import br.com.admtariff.entity.AdmTariffEntity;
import br.com.admtariff.exception.AdmTariffNotFoundException;
import br.com.admtariff.exception.ConflictException;
import br.com.admtariff.exception.DependencyException;
import br.com.admtariff.exception.ValidationException;
import br.com.admtariff.repository.AdmTariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdmTariffService {
    private final AdmTariffRepository tariffRepository;

    @Autowired
    public AdmTariffService(AdmTariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    public AdmTariffEntity createAdmTariff(AdmTariffEntity tariff) {
        if (tariffIsValid(tariff)) {
            if (tariffExists(tariff)) {
                throw new ConflictException("A tarifa com critérios semelhantes já existe.");
            }
            return tariffRepository.save(tariff);
        } else {
            throw new ValidationException("Dados da tarifa inválidos.");
        }
    }

    public List<AdmTariffEntity> getAllAdmTariffs() {
        Iterable<AdmTariffEntity> tariffsIterable = tariffRepository.findAll();
        List<AdmTariffEntity> tariffs = new ArrayList<>();
        tariffsIterable.forEach(tariffs::add);
        return tariffs;
    }

    public AdmTariffEntity getAdmTariffById(Long id) {
        return tariffRepository.findById(id)
                .orElseThrow(() -> new AdmTariffNotFoundException("Tarifa não encontrada com o ID: " + id));
    }

    public void deleteAdmTariff(Long id) {
        AdmTariffEntity tariff = getAdmTariffById(id);
        if (tariffHasDependencies(tariff)) {
            throw new DependencyException("A tarifa possui dependências e não pode ser excluída.");
        }
        tariffRepository.deleteById(id);
    }

    private boolean tariffIsValid(AdmTariffEntity tariff) {
        return true;
    }

    private boolean tariffExists(AdmTariffEntity tariff) {
        return false;
    }

    private boolean tariffHasDependencies(AdmTariffEntity tariff) {
        return false;
    }
}