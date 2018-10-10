package com.blob.module.module.blob.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blob.module.module.blob.dao.TBlobDao;
import com.blob.module.module.blob.entity.TBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2018-10-10
 */
@Service
public class TBlobService {

    @Autowired
    private TBlobDao tBlobDao;

    public Page<TBlob> findList(String title){
        return tBlobDao.findList(title);
    }
}
