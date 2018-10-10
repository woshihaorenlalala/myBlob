package com.blob.module.module.blob.dao;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blob.module.module.blob.entity.TBlob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cc
 * @since 2018-10-10
 */
@Repository
public interface TBlobDao extends JpaRepository<TBlob, Integer> {

    Page<TBlob> findList(String title);

}
