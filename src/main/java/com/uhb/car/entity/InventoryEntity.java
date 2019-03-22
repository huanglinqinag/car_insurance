package com.uhb.car.entity;

import com.uhb.car.services.imp.VehicleAndVesselTaxServiceImpl;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @ClassName:
 * @Author: hlq
 * @Date: 2019/3/8 12:14
 * @Version 1.0
 */
@Entity
@Table(name = "inventory", schema = "vehicle", catalog = "")
public class InventoryEntity {
    private int inventoryId;
    private int insuranceNumber;
    private String typesName;
    private int vehicleId;
    private int carOwnerId;
    private int premium;
    private int vehicleAndVesselTaxId;
    private Date effectiveDate;
    private int amountPayable;
    private Date startingTime;
    private Date finalProtectionTime;
    private VehicleInformationEntity vehicleInformationEntity;
    private VehicleAndVesselTaxEntity vehicleAndVesselTaxEntity;
    private CarOwnerEntity carOwnerEntity;

    @ManyToOne
    @JoinColumn(name = "car_owner_id", insertable = false, updatable = false)
    public CarOwnerEntity getCarOwnerEntity() {
        return carOwnerEntity;
    }

    public void setCarOwnerEntity(CarOwnerEntity carOwnerEntity) {
        this.carOwnerEntity = carOwnerEntity;
    }

    @ManyToOne
    @JoinColumn(name = "vehicle_and_vessel_tax_id", insertable = false, updatable = false)
    public VehicleAndVesselTaxEntity getVehicleAndVesselTaxEntity() {
        return vehicleAndVesselTaxEntity;
    }

    public void setVehicleAndVesselTaxEntity(VehicleAndVesselTaxEntity vehicleAndVesselTaxEntity) {
        this.vehicleAndVesselTaxEntity = vehicleAndVesselTaxEntity;
    }

    @ManyToOne
    @JoinColumn(name = "vehicle_id", insertable = false, updatable = false)
    public VehicleInformationEntity getVehicleInformationEntity() {
        return vehicleInformationEntity;
    }

    public void setVehicleInformationEntity(VehicleInformationEntity vehicleInformationEntity) {
        this.vehicleInformationEntity = vehicleInformationEntity;
    }

    @Id
    @Column(name = "inventory_id")
    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    @Basic
    @Column(name = "insurance_number")
    public int getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(int insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    @Basic
    @Column(name = "Typesname")
    public String getTypesName() {
        return typesName;
    }

    public void setTypesName(String typesName) {
        this.typesName = typesName;
    }

    @Basic
    @Column(name = "vehicle_id")
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "car_owner_id")
    public int getCarOwnerId() {
        return carOwnerId;
    }

    public void setCarOwnerId(int carOwnerId) {
        this.carOwnerId = carOwnerId;
    }

    @Basic
    @Column(name = "premium")
    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    @Basic
    @Column(name = "vehicle_and_vessel_tax_id")
    public int getVehicleAndVesselTaxId() {
        return vehicleAndVesselTaxId;
    }

    public void setVehicleAndVesselTaxId(int vehicleAndVesselTaxId) {
        this.vehicleAndVesselTaxId = vehicleAndVesselTaxId;
    }

    @Basic
    @Column(name = "effective_date")
    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Basic
    @Column(name = "amount_payable")
    public int getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(int amountPayable) {
        this.amountPayable = amountPayable;
    }

    @Basic
    @Column(name = "starting_time")
    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    @Basic
    @Column(name = "final_protection_time")
    public Date getFinalProtectionTime() {
        return finalProtectionTime;
    }

    public void setFinalProtectionTime(Date finalProtectionTime) {
        this.finalProtectionTime = finalProtectionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InventoryEntity that = (InventoryEntity) o;
        return inventoryId == that.inventoryId &&
                insuranceNumber == that.insuranceNumber &&
                typesName == that.typesName &&
                vehicleId == that.vehicleId &&
                carOwnerId == that.carOwnerId &&
                premium == that.premium &&
                vehicleAndVesselTaxId == that.vehicleAndVesselTaxId &&
                amountPayable == that.amountPayable &&
                Objects.equals(effectiveDate, that.effectiveDate) &&
                Objects.equals(startingTime, that.startingTime) &&
                Objects.equals(finalProtectionTime, that.finalProtectionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, insuranceNumber, typesName, vehicleId, carOwnerId, premium, vehicleAndVesselTaxId, effectiveDate, amountPayable, startingTime, finalProtectionTime);
    }
}
