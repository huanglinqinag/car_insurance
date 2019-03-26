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
@Table(name = "id_type", schema = "vehicle", catalog = "")
public class IdTypeEntity {
    private int idTypeId;
    private String idTypeName;
    private int ownerNature;

    @Id
    @Column(name = "id_type_id")
    public int getIdTypeId() {
        return idTypeId;
    }

    public void setIdTypeId(int idTypeId) {
        this.idTypeId = idTypeId;
    }

    @Basic
    @Column(name = "id_type_name")
    public String getIdTypeName() {
        return idTypeName;
    }

    public void setIdTypeName(String idTypeName) {
        this.idTypeName = idTypeName;
    }

    @Basic
    @Column(name = "owner_nature")
    public int getOwnerNature() {
        return ownerNature;
    }

    public void setOwnerNature(int ownerNature) {
        this.ownerNature = ownerNature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdTypeEntity that = (IdTypeEntity) o;
        return idTypeId == that.idTypeId &&
                ownerNature == that.ownerNature &&
                Objects.equals(idTypeName, that.idTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTypeId, idTypeName, ownerNature);
    }
}
