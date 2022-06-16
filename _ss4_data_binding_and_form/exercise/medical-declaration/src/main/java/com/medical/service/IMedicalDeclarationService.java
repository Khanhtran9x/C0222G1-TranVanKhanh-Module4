package com.medical.service;

import com.medical.model.MedicalDeclaration;

public interface IMedicalDeclarationService {
    void saveDeclaration(MedicalDeclaration medicalDeclaration);
    MedicalDeclaration getDeclaration();
    String[] getDateOfBirth();
    String[] getDay();
    String[] getMonth();
    String[] getYear();
    String[] getNation();
    String[] getTransportationInformation();
}
