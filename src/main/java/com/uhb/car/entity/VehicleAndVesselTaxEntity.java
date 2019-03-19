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
    private int vehicleVesselTaxId;
    private int displacementId;
    private int price;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
//可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name = "displacement_id")//设置VehicleAndVesselTax表中的关联字段
    private DisplacementEntity displacement;

    @Id
    @Column(name = "vehicle_and_vessel_tax_id")
    public int getVehicleVesselTaxId() {
        return vehicleVesselTaxId;
    }

    public void setVehicleVesselTaxId(int vehicleVesselTaxId) {
        this.vehicleVesselTaxId = vehicleVesselTaxId;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VehicleAndVesselTaxEntity that = (VehicleAndVesselTaxEntity) o;
        return vehicleVesselTaxId == that.vehicleVesselTaxId &&
                displacementId == that.displacementId &&
                price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleVesselTaxId, displacementId, price);
    }
}
