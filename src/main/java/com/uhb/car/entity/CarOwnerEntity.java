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
@Table(name = "car_owner", schema = "vehicle", catalog = "")
public class CarOwnerEntity {
    private int carOwnerId;
    private String theOwnerName;
    private String natrueOfTheOwner;
    private int idTypeId;
    private String idNumber;
    private String relation;
    private String picture;

    @Id
    @Column(name = "car_owner_id")
    public int getCarOwnerId() {
        return carOwnerId;
    }

    public void setCarOwnerId(int carOwnerId) {
        this.carOwnerId = carOwnerId;
    }

    @Basic
    @Column(name = "the_owner_name")
    public String getTheOwnerName() {
        return theOwnerName;
    }

    public void setTheOwnerName(String theOwnerName) {
        this.theOwnerName = theOwnerName;
    }

    @Basic
    @Column(name = "natrue_of_the_owner")
    public String getNatrueOfTheOwner() {
        return natrueOfTheOwner;
    }

    public void setNatrueOfTheOwner(String natrueOfTheOwner) {
        this.natrueOfTheOwner = natrueOfTheOwner;
    }

    @Basic
    @Column(name = "id_type_id")
    public int getIdTypeId() {
        return idTypeId;
    }

    public void setIdTypeId(int idTypeId) {
        this.idTypeId = idTypeId;
    }

    @Basic
    @Column(name = "id_number")
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    @Basic
    @Column(name = "relation")
    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Basic
    @Column(name = "picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarOwnerEntity that = (CarOwnerEntity) o;
        return carOwnerId == that.carOwnerId &&
                idTypeId == that.idTypeId &&
                Objects.equals(theOwnerName, that.theOwnerName) &&
                Objects.equals(natrueOfTheOwner, that.natrueOfTheOwner) &&
                Objects.equals(idNumber, that.idNumber) &&
                Objects.equals(relation, that.relation) &&
                Objects.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carOwnerId, theOwnerName, natrueOfTheOwner, idTypeId, idNumber, relation, picture);
    }
}
