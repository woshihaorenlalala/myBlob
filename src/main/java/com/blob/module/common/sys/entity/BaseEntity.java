package com.blob.module.common.sys.entity;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by cc on 2018/10/8.
 */
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Page<T> page;

    @Transient
    @JsonIgnore
    public Page<T> getPage() {
        if(page == null){
            page = new Page();
        }
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
    }
}
