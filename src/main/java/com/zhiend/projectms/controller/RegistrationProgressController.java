package com.zhiend.projectms.controller;


import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IRegistrationProgressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 注册进度表 前端控制器
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@RestController
@RequestMapping("/registration-progress")
public class RegistrationProgressController {
    @Autowired
    private IRegistrationProgressService registrationProgressService;

    @ApiOperation("获取注册进度信息")
    @GetMapping("/{id}")
    public Result<?> getRegistrationProgress(@PathVariable Long id) {
        // 普通用户查看功能
        // 实现根据 id 获取注册进度信息的逻辑
        // registrationProgressService.getById(id);
        return Result.success("Get registration progress by id: " + id);
    }
}
