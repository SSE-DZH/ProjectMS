package com.zhiend.projectms.controller;


import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IProjectsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 项目表 前端控制器
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@RestController
@RequestMapping("/projects")
public class ProjectsController {
    @Autowired
    private IProjectsService projectsService;

    @ApiOperation("获取项目信息")
    @GetMapping("/{id}")
    public Result<?> getProject(@PathVariable Long id) {
        // 普通用户查看功能
        // 实现根据 id 获取项目信息的逻辑
        // projectsService.getById(id);
        return Result.success("Get project by id: " + id);
    }
}
