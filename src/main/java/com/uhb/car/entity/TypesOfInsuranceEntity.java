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
@Table(name = "types_of_insurance", schema = "vehicle", catalog = "")
public class TypesOfInsuranceEntity {
    private int typesOfInsuranceId;
    private String insuranceName;
    private Integer sumInsured;
    private Integer price;

    @Id
    @Column(name = "types_of_insurance_id")
    public int getTypesOfInsuranceId() {
        return typesOfInsuranceId;
    }

    public void setTypesOfInsuranceId(int typesOfInsuranceId) {
        this.typesOfInsuranceId = typesOfInsuranceId;
    }

    @Basic
    @Column(name = "Insurance_name")
    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    @Basic
    @Column(name = "sum_insured")
    public Integer getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(Integer sumInsured) {
        this.sumInsured = sumInsured;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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
        TypesOfInsuranceEntity that = (TypesOfInsuranceEntity) o;
        return typesOfInsuranceId == that.typesOfInsuranceId &&
                Objects.equals(insuranceName, that.insuranceName) &&
                Objects.equals(sumInsured, that.sumInsured) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typesOfInsuranceId, insuranceName, sumInsured, price);
    }
}
