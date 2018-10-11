package com.blob.module.module.blob.dao;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blob.module.module.blob.entity.TBlob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Blob;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2018-10-10
 */
@Component
@Mapper
public interface TBlobDao /*extends CrudRepository<TBlob, Integer>*/ {

    Page<TBlob> findList(@Param(value = "title")String title);

    int update(TBlob tBlob);

    int insert(TBlob tBlob);

    int updateShow(TBlob tBlob);

    int deleteById(int id);

}
