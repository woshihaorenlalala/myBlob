package com.blob.module.common.sys.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blob.module.common.sys.entity.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cc on 2018/10/8.
 */
public class CrudService<D extends JpaRepository<T, Integer>, T extends DataEntity<T>>  extends BaseService{

    //持久层对象
    @Autowired
    protected D dao;

    /**
     * 根据Id获取一条数据
     * @param id
     * @return
     */
    public T get(int id){
        return dao.getOne(id);
    }

}
