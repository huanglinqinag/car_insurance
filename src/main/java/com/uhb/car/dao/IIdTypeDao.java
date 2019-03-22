package com.uhb.car.dao;

import com.uhb.car.entity.IdTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Dome interface:IIdTypeDao
 * @Author: LJW
 * @Date: 2019/3/22 09:10
 * @Version 1.0
 */
public interface IIdTypeDao extends JpaRepository<IdTypeEntity, Integer>, CrudRepository<IdTypeEntity, Integer>, PagingAndSortingRepository<IdTypeEntity, Integer>, JpaSpecificationExecutor<IdTypeEntity> {
    /**
     * 添加一条证件信息
     *
     * @param idType
     * @return IdTypeEntity
     */
    @Override
    IdTypeEntity save(IdTypeEntity idType);

    /**
     * 根据证件Id删除
     *
     * @param idTypeId
     */
    void deleteId(Integer idTypeId);

    /**
     * 分页查询
     *
     * @param pageSize
     * @param pageNumber
     * @return Page<IdTypeEntity>
     */
    Page<IdTypeEntity> findAll(Integer pageSize, Integer pageNumber);

}
