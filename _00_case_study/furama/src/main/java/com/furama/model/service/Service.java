package com.furama.model.service;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;
    private String serviceCode;
    private String serviceName;
    @Column(columnDefinition = "INT")
    private String serviceArea;
    @Column(columnDefinition = "DOUBLE")
    private String serviceCost;
    @Column(columnDefinition = "INT")
    private String serviceMaxPeople;
    private String serviceStandardRoom;
    private String descriptionOtherConvenience;
    @Column(columnDefinition = "DOUBLE")
    private String servicePoolArea;
    @Column(columnDefinition = "INT")
    private String serviceNumberOfFloors;

    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="rent_type_id ", nullable=false)
    private RentType rentType;

    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="service_type_id", nullable=false)
    private ServiceType serviceType;

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getServiceStandardRoom() {
        return serviceStandardRoom;
    }

    public void setServiceStandardRoom(String serviceStandardRoom) {
        this.serviceStandardRoom = serviceStandardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getServicePoolArea() {
        return servicePoolArea;
    }

    public void setServicePoolArea(String servicePoolArea) {
        this.servicePoolArea = servicePoolArea;
    }

    public String getServiceNumberOfFloors() {
        return serviceNumberOfFloors;
    }

    public void setServiceNumberOfFloors(String serviceNumberOfFloors) {
        this.serviceNumberOfFloors = serviceNumberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
