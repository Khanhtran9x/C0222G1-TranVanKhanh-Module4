package com.medical.repository;

import com.medical.model.MedicalDeclaration;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalDeclarationRepository implements IMedicalDeclarationRepository{
    private static MedicalDeclaration medicalDeclaration;
    private static String[] dateOfBirth;
    private static String[] nation;
    private static String[] transportationInformation;
    private static String[] day;
    private static String[] month;
    private static String[] year;

    static {
        dateOfBirth = new String[]{"1990", "1991", "1992", "1993", "1994", "1995"};
        nation = new String[]{"Việt Nam", "Hoa Kỳ", "Trung Quốc", "Nga"};
        transportationInformation = new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác"};
        day = new String[]{"01", "05", "15", "20", "25", "30"};
        month = new String[]{"01", "02", "03", "05", "07", "12"};
        year = new String[]{"2020", "2021", "2022", "2023"};
    }

    @Override
    public void saveDeclaration(MedicalDeclaration obj) {
        medicalDeclaration = obj;
    }

    @Override
    public MedicalDeclaration getDeclaration() {
        return medicalDeclaration;
    }

    @Override
    public String[] getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String[] getDay() {
        return day;
    }

    @Override
    public String[] getMonth() {
        return month;
    }

    @Override
    public String[] getYear() {
        return year;
    }

    @Override
    public String[] getNation() {
        return nation;
    }

    @Override
    public String[] getTransportationInformation() {
        return transportationInformation;
    }
}
