package com.zhiend.projectms.controller;


import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IModuleQuantitiesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 模块化数量表 前端控制器
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@RestController
@RequestMapping("/module-quantities")
public class ModuleQuantitiesController {
    @Autowired
    private IModuleQuantitiesService moduleQuantitiesService;

    @ApiOperation("获取模块化数量信息")
    @GetMapping("/{id}")
    public Result<?> getModuleQuantities(@PathVariable Long id) {
        // 普通用户查看功能
        // 实现根据 id 获取模块化数量信息的逻辑
        // moduleQuantitiesService.getById(id);
        return Result.success("Get module quantities by id: " + id);
    }
}
