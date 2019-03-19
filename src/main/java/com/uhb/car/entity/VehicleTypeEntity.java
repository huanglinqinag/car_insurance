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
@Table(name = "vehicle_type", schema = "vehicle", catalog = "")
public class VehicleTypeEntity {
    private int vehicleTypeId;
    private String typeName;

    @Id
    @Column(name = "vehicle_type_id")
    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    @Basic
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VehicleTypeEntity that = (VehicleTypeEntity) o;
        return vehicleTypeId == that.vehicleTypeId &&
                Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleTypeId, typeName);
    }
}
