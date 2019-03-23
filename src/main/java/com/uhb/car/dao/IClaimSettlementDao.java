package com.uhb.car.dao;

import com.uhb.car.entity.ClaimSettlementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Dome interface:对理赔信息的CRUD IClaimSettlementDao
 * @Author: LJW
 * @Date: 2019/3/23 13:05
 * @Version 1.0
 */
public interface IClaimSettlementDao extends JpaRepository<ClaimSettlementEntity, Integer>, CrudRepository<ClaimSettlementEntity, Integer>, PagingAndSortingRepository<ClaimSettlementEntity, Integer>, JpaSpecificationExecutor<ClaimSettlementEntity> {
}
