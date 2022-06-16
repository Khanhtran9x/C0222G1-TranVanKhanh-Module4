package com.medical.repository;

import com.medical.model.MedicalDeclaration;

public interface IMedicalDeclarationRepository {
    void saveDeclaration(MedicalDeclaration medicalDeclaration);
    MedicalDeclaration getDeclaration();
    String[] getDateOfBirth();
    String[] getDay();
    String[] getMonth();
    String[] getYear();
    String[] getNation();
    String[] getTransportationInformation();
}
