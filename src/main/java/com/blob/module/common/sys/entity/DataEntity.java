package com.blob.module.common.sys.entity;

import org.springframework.data.domain.Page;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cc on 2018/6/15.
 */
@MappedSuperclass   //MappedSuperclass注解用来jpa生成子类表的时候也会将父类属性生成
public class DataEntity<T> extends BaseEntity<T> {

    private static final long serialVersionUID = 1L;

    //修改时间
    protected Date updateTime;
    //创建时间
    protected Date createTime;
    //是否删除
    protected int delflag;

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert(){
        this.updateTime = new Date();
        this.createTime = this.updateTime;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate(){
    //    User user = UserUtils.getUser();
        this.updateTime = new Date();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }

}
