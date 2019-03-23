package com.uhb.car.services;

import com.uhb.car.entity.ClaimSettlementEntity;
import org.springframework.data.domain.Page;

/**
 * @Dome interface:对理赔信息进行CRUD IClaimSettlementService
 * @Author: LJW
 * @Date: 2019/3/23 13:06
 * @Version 1.0
 */
public interface IClaimSettlementService {
    /**
     * 添加一条理赔信息
     *
     * @param claimSettlement
     * @return ClaimSettlementEntity
     */
    ClaimSettlementEntity saveByClaimSettlementEntity(ClaimSettlementEntity claimSettlement);

    /**
     * 根据理赔信息Id删除
     *
     * @param claimSettlementId
     */
    void deleteByClaimSettlementId(Integer claimSettlementId);

    /**
     * 修改一条理赔信息
     *
     * @param claimSettlement
     * @return ClaimSettlementEntity
     */
    ClaimSettlementEntity updateByClaimSettlementEntity(ClaimSettlementEntity claimSettlement);

    /**
     * 分页查询理赔信息
     *
     * @param pageSize
     * @param pageNumber
     * @return Page<ClaimSettlementEntity>
     */
    Page<ClaimSettlementEntity> findAllByClaimSettlementEntityPaging(Integer pageSize, Integer pageNumber);

    /**
     * 动态分页查询理赔信息
     *
     * @param claimSettlement
     * @param pageSize
     * @param pageNumber
     * @return Page<ClaimSettlementEntity>
     */
    Page<ClaimSettlementEntity> findAllByClaimSettlementEntityDynamic(ClaimSettlementEntity claimSettlement, Integer pageSize, Integer pageNumber);

}
