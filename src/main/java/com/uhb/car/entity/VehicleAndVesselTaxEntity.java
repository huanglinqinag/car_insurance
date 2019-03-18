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
@Table(name = "vehicle_and_vessel_tax", schema = "vehicle", catalog = "")
public class VehicleAndVesselTaxEntity {
    private int vehicleAndVesselTaxId;
    private int displacementId;
    private int price;

    @Id
    @Column(name = "vehicle_and_vessel_tax_id")
    public int getVehicleAndVesselTaxId() {
        return vehicleAndVesselTaxId;
    }

    public void setVehicleAndVesselTaxId(int vehicleAndVesselTaxId) {
        this.vehicleAndVesselTaxId = vehicleAndVesselTaxId;
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
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleAndVesselTaxEntity that = (VehicleAndVesselTaxEntity) o;
        return vehicleAndVesselTaxId == that.vehicleAndVesselTaxId &&
                displacementId == that.displacementId &&
                price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleAndVesselTaxId, displacementId, price);
    }
}
