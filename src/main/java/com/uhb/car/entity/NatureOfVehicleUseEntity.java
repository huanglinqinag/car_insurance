package com.uhb.car.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @ClassName:
 * @Author: hlq
 * @Date: 2019/3/8 12:14
 * @Version 1.0
 */
@Entity
@Table(name = "nature_of_vehicle_use", schema = "vehicle", catalog = "")
public class NatureOfVehicleUseEntity {
    private int natureOfVehicleUseId;
    private String natureName;

    @Id
    @Column(name = "nature_of_vehicle_use_id")
    public int getNatureOfVehicleUseId() {
        return natureOfVehicleUseId;
    }

    public void setNatureOfVehicleUseId(int natureOfVehicleUseId) {
        this.natureOfVehicleUseId = natureOfVehicleUseId;
    }

    @Basic
    @Column(name = "nature_name")
    public String getNatureName() {
        return natureName;
    }

    public void setNatureName(String natureName) {
        this.natureName = natureName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NatureOfVehicleUseEntity that = (NatureOfVehicleUseEntity) o;
        return natureOfVehicleUseId == that.natureOfVehicleUseId &&
                Objects.equals(natureName, that.natureName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(natureOfVehicleUseId, natureName);
    }
}
