package com.uhb.car.entity;

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
@Table(name = "claim_settlement", schema = "vehicle", catalog = "")
public class ClaimSettlementEntity {
    private int claimSettlementId;
    private String name;
    private String thirdPartyInformation;
    private int vehicleId;
    private Integer compulsoryId;
    private Integer typesOfInsuranceId;
    private Date time;
    private String site;
    private String cause;
    private String driver;
    private String phone;
    private VehicleInformationEntity vehicleInformationEntity;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", insertable = false, updatable = false)
    public VehicleInformationEntity getVehicleInformationEntity() {
        return vehicleInformationEntity;
    }

    public void setVehicleInformationEntity(VehicleInformationEntity vehicleInformationEntity) {
        this.vehicleInformationEntity = vehicleInformationEntity;
    }

    @Id
    @Column(name = "claim_settlement_id")
    public int getClaimSettlementId() {
        return claimSettlementId;
    }

    public void setClaimSettlementId(int claimSettlementId) {
        this.claimSettlementId = claimSettlementId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Third_party_information")
    public String getThirdPartyInformation() {
        return thirdPartyInformation;
    }

    public void setThirdPartyInformation(String thirdPartyInformation) {
        this.thirdPartyInformation = thirdPartyInformation;
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
    @Column(name = "compulsory_id")
    public Integer getCompulsoryId() {
        return compulsoryId;
    }

    public void setCompulsoryId(Integer compulsoryId) {
        this.compulsoryId = compulsoryId;
    }

    @Basic
    @Column(name = "types_of_insurance_id")
    public Integer getTypesOfInsuranceId() {
        return typesOfInsuranceId;
    }

    public void setTypesOfInsuranceId(Integer typesOfInsuranceId) {
        this.typesOfInsuranceId = typesOfInsuranceId;
    }

    @Basic
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "site")
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Basic
    @Column(name = "cause")
    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Basic
    @Column(name = "driver")
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClaimSettlementEntity that = (ClaimSettlementEntity) o;
        return claimSettlementId == that.claimSettlementId &&
                vehicleId == that.vehicleId &&
                Objects.equals(name, that.name) &&
                Objects.equals(thirdPartyInformation, that.thirdPartyInformation) &&
                Objects.equals(compulsoryId, that.compulsoryId) &&
                Objects.equals(typesOfInsuranceId, that.typesOfInsuranceId) &&
                Objects.equals(time, that.time) &&
                Objects.equals(site, that.site) &&
                Objects.equals(cause, that.cause) &&
                Objects.equals(driver, that.driver) &&
                Objects.equals(phone, that.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(claimSettlementId, name, thirdPartyInformation, vehicleId, compulsoryId, typesOfInsuranceId, time, site, cause, driver, phone);
    }
}
