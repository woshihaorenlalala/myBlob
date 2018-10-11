package com.blob.module.common.sys.service;

import com.blob.module.common.sys.entity.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by cc on 2018/10/8.
 */
public class CrudService<D /*extends CrudRepository<T, Integer>*/, T extends DataEntity<T>>  extends BaseService{

    //持久层对象
    @Autowired
    protected D dao;

    /**
     * 根据Id获取一条数据
     * @param id
     * @return
     */
   /* public T get(int id){
        return dao.getOne(id);
    }*/

    /**
     * 真删除一条记录
     * @param entity
     */
    /*public void delete(T entity){
        dao.delete(entity);
    }*/
}
