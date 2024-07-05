package com.zhiend.projectms.controller;


import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IProjectMilestonesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 项目节点完成情况表 前端控制器
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@RestController
@RequestMapping("/project-milestones")
public class ProjectMilestonesController {
    @Autowired
    private IProjectMilestonesService projectMilestonesService;

    @ApiOperation("获取项目节点完成情况信息")
    @GetMapping("/{id}")
    public Result<?> getProjectMilestones(@PathVariable Long id) {
        // 普通用户查看功能
        // 实现根据 id 获取项目节点完成情况信息的逻辑
        // projectMilestonesService.getById(id);
        return Result.success("Get project milestones by id: " + id);
    }
}
