package com.medical.service;

import com.medical.model.MedicalDeclaration;
import com.medical.repository.IMedicalDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalDeclarationService implements IMedicalDeclarationService{
    @Autowired
    private IMedicalDeclarationRepository medicalDeclarationRepository;

    @Override
    public void saveDeclaration(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.saveDeclaration(medicalDeclaration);
    }

    @Override
    public MedicalDeclaration getDeclaration() {
        return medicalDeclarationRepository.getDeclaration();
    }

    @Override
    public String[] getDateOfBirth() {
        return medicalDeclarationRepository.getDateOfBirth();
    }

    @Override
    public String[] getDay() {
        return medicalDeclarationRepository.getDay();
    }

    @Override
    public String[] getMonth() {
        return medicalDeclarationRepository.getMonth();
    }

    @Override
    public String[] getYear() {
        return medicalDeclarationRepository.getYear();
    }

    @Override
    public String[] getNation() {
        return medicalDeclarationRepository.getNation();
    }

    @Override
    public String[] getTransportationInformation() {
        return medicalDeclarationRepository.getTransportationInformation();
    }
}
