package com.blob.module.module.blob.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blob.module.common.sys.entity.Constant;
import com.blob.module.common.sys.entity.HttpResult;
import com.blob.module.module.blob.entity.TBlob;
import com.blob.module.module.blob.service.TBlobService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cc
 * @since 2018-10-10
 */
@RestController
@RequestMapping("/blob")
public class TBlobController {

    @Autowired
    private TBlobService tBlobService;

    /**
     * 查询博客文章列表
     * @param tilte
     * @return
     */
    @RequestMapping(value = {"/","list"})
//    @RequiresPermissions(value = "blob:blob:view")
    public HttpResult findList(String tilte){
        try {
            Page<TBlob> page = tBlobService.findList(tilte);
            return HttpResult.built(Constant.SUCCESS, "查询成功", page);
        }catch (Exception e){
            e.printStackTrace();
            return HttpResult.built(Constant.FAIL, "查询失败", "");
        }
    }
}
