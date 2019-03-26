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
@Table(name = "energy_type", schema = "vehicle", catalog = "")
public class EnergyTypeEntity {
    private int energyTypeId;
    private String energyTypeName;

    @Id
    @Column(name = "energy_type_id")
    public int getEnergyTypeId() {
        return energyTypeId;
    }

    public void setEnergyTypeId(int energyTypeId) {
        this.energyTypeId = energyTypeId;
    }

    @Basic
    @Column(name = "energy_type_name")
    public String getEnergyTypeName() {
        return energyTypeName;
    }

    public void setEnergyTypeName(String energyTypeName) {
        this.energyTypeName = energyTypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EnergyTypeEntity that = (EnergyTypeEntity) o;
        return energyTypeId == that.energyTypeId &&
                Objects.equals(energyTypeName, that.energyTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(energyTypeId, energyTypeName);
    }
}
