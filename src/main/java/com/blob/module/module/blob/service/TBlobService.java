package com.blob.module.module.blob.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blob.module.common.sys.service.CrudService;
import com.blob.module.module.blob.dao.TBlobDao;
import com.blob.module.module.blob.entity.TBlob;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Blob;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cc
 * @since 2018-10-10
 */
@Service
public class TBlobService extends CrudService<TBlobDao, TBlob>{

    @Autowired
    private TBlobDao tBlobDao;

    public Page<TBlob> findList(String title){
        return tBlobDao.findList(title);
    }

    /**
     * 新增/修改文章
     * @param id
     * @param tilte
     * @param content
     * @return
     */
    public int save(Integer id, String tilte, String content){
        if(null != id && 0 != id){
            TBlob tBlob = new TBlob();
            tBlob.preUpdate();
            tBlob.setId(id);
            tBlob.setContent(content);
            tBlob.setTitle(tilte);
            return tBlobDao.update(tBlob);
        }else{
            TBlob tBlob = new TBlob();
            tBlob.preInsert();
            tBlob.setId(id);
            tBlob.setContent(content);
            tBlob.setTitle(tilte);
            return tBlobDao.insert(tBlob);
        }
    }

    /**
     * 删除文章,个人博客一般不会删除
     * @param id
     * @return
     */
    public int deleteById(int id){
        return tBlobDao.deleteById(id);
    }
}
