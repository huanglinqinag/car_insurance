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
    private int displacementSize;
    @OneToMany(mappedBy = "displacement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
    //拥有mappedBy注解的实体类为关系被维护端
    //mappedBy="author"中的author是Article中的author属性
    private List<VehicleAndVesselTaxEntity> articleList;//文章列表

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
    public int getDisplacementSize() {
        return displacementSize;
    }

    public void setDisplacementSize(int displacementSize) {
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
