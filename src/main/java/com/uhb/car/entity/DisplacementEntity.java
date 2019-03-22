package com.uhb.car.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName:
 * @Author: hlq
 * @Date: 2019/3/8 12:14
 * @Version 1.0
 */
@Entity
@Table(name = "displacement", schema = "vehicle", catalog = "")
public class DisplacementEntity {
    private int displacementId;
    private String displacementSize;
    @Id
    @Column(name = "displacement_id")
    public int getDisplacementId() {
        return displacementId;
    }

    public void setDisplacementId(int displacementId) {
        this.displacementId = displacementId;
    }

    @Basic
    @Column(name = "displacement_size")
    public String getDisplacementSize() {
        return displacementSize;
    }

    public void setDisplacementSize(String displacementSize) {
        this.displacementSize = displacementSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DisplacementEntity that = (DisplacementEntity) o;
        return displacementId == that.displacementId &&
                displacementSize == that.displacementSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(displacementId, displacementSize);
    }
}
