package com.uhb.car.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName:
 * @Author: hlq
 * @Date: 2019/3/8 12:15
 * @Version 1.0
 */
@Entity
@Table(name = "vehicle_information", schema = "vehicle", catalog = "")
public class VehicleInformationEntity {
    private int vehicleId;
    private String licensePlateNumber;
    private String vin;
    private String engineNumber;
    private int vehicleTypeId;
    private int natureOfVehicleUseId;
    private String dateOfInitialRegistration;
    private int energyTypeId;
    private String picture;
    private int displacementId;
    private int seating;
    private VehicleTypeEntity vehicleTypeEntity;
    private NatureOfVehicleUseEntity natureOfVehicleUseEntity;

    @ManyToOne
    @JoinColumn(name = "nature_of_vehicle_use_id", insertable = false, updatable = false)
    public NatureOfVehicleUseEntity getNatureOfVehicleUseEntity() {
        return natureOfVehicleUseEntity;
    }

    public void setNatureOfVehicleUseEntity(NatureOfVehicleUseEntity natureOfVehicleUseEntity) {
        this.natureOfVehicleUseEntity = natureOfVehicleUseEntity;
    }

    @ManyToOne
    @JoinColumn(name = "vehicle_type_id", insertable = false, updatable = false)
    public VehicleTypeEntity getVehicleTypeEntity() {
        return vehicleTypeEntity;
    }

    public void setVehicleTypeEntity(VehicleTypeEntity vehicleTypeEntity) {
        this.vehicleTypeEntity = vehicleTypeEntity;
    }

    @Id
    @Column(name = "vehicle_id")
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "license_plate_number")
    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    @Basic
    @Column(name = "vin")
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Basic
    @Column(name = "engine_number")
    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    @Basic
    @Column(name = "vehicle_type_id")
    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    @Basic
    @Column(name = "nature_of_vehicle_use_id")
    public int getNatureOfVehicleUseId() {
        return natureOfVehicleUseId;
    }

    public void setNatureOfVehicleUseId(int natureOfVehicleUseId) {
        this.natureOfVehicleUseId = natureOfVehicleUseId;
    }

    @Basic
    @Column(name = "date_of_initial_registration")
    public String getDateOfInitialRegistration() {
        return dateOfInitialRegistration;
    }

    public void setDateOfInitialRegistration(String dateOfInitialRegistration) {
        this.dateOfInitialRegistration = dateOfInitialRegistration;
    }

    @Basic
    @Column(name = "energy_type_id")
    public int getEnergyTypeId() {
        return energyTypeId;
    }

    public void setEnergyTypeId(int energyTypeId) {
        this.energyTypeId = energyTypeId;
    }

    @Basic
    @Column(name = "picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "displacement_id")
    public int getDisplacementId() {
        return displacementId;
    }

    public void setDisplacementId(int displacementId) {
        this.displacementId = displacementId;
    }

    @Basic
    @Column(name = "seating")
    public int getSeating() {
        return seating;
    }

    public void setSeating(int seating) {
        this.seating = seating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleInformationEntity that = (VehicleInformationEntity) o;
        return vehicleId == that.vehicleId &&
                vehicleTypeId == that.vehicleTypeId &&
                natureOfVehicleUseId == that.natureOfVehicleUseId &&
                energyTypeId == that.energyTypeId &&
                displacementId == that.displacementId &&
                seating == that.seating &&
                Objects.equals(licensePlateNumber, that.licensePlateNumber) &&
                Objects.equals(vin, that.vin) &&
                Objects.equals(engineNumber, that.engineNumber) &&
                Objects.equals(dateOfInitialRegistration, that.dateOfInitialRegistration) &&
                Objects.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, licensePlateNumber, vin, engineNumber, vehicleTypeId, natureOfVehicleUseId, dateOfInitialRegistration, energyTypeId, picture, displacementId, seating);
    }
}
