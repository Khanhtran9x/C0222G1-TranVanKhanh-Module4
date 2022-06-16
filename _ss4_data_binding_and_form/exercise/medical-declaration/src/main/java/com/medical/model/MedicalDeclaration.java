package com.medical.model;

public class MedicalDeclaration {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String nation;
    private String idCard;
    private String transportationInformation;
    private String transportationCode;
    private String seatCode;
    private String startDay;
    private String startMonth;
    private String startYear;
    private String endDay;
    private String endMonth;
    private String endYear;
    private String visitablePlaces;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String name, String dateOfBirth, String gender, String nation, String idCard,
                              String transportationInformation, String transportationCode, String seatCode,
                              String startDay, String startMonth, String startYear, String endDay,
                              String endMonth, String endYear, String visitablePlaces) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nation = nation;
        this.idCard = idCard;
        this.transportationInformation = transportationInformation;
        this.transportationCode = transportationCode;
        this.seatCode = seatCode;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.startYear = startYear;
        this.endDay = endDay;
        this.endMonth = endMonth;
        this.endYear = endYear;
        this.visitablePlaces = visitablePlaces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTransportationInformation() {
        return transportationInformation;
    }

    public void setTransportationInformation(String transportationInformation) {
        this.transportationInformation = transportationInformation;
    }

    public String getTransportationCode() {
        return transportationCode;
    }

    public void setTransportationCode(String transportationCode) {
        this.transportationCode = transportationCode;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getVisitablePlaces() {
        return visitablePlaces;
    }

    public void setVisitablePlaces(String visitablePlaces) {
        this.visitablePlaces = visitablePlaces;
    }
}
