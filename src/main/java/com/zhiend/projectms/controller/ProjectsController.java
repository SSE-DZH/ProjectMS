package com.zhiend.projectms.controller;


import com.zhiend.projectms.dto.ProjectsDTO;
import com.zhiend.projectms.entity.Admin;
import com.zhiend.projectms.entity.Projects;
import com.zhiend.projectms.page.BackPage;
import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IProjectsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
@Api(tags = "项目信息管理")
public class ProjectsController {
    @Autowired
    private IProjectsService projectsService;

    @ApiOperation("根据id获取项目信息")
    @GetMapping("/{id}")
    public Result<?> getProject(@PathVariable Long id) {
        // 普通用户查看功能
        // 实现根据 id 获取项目信息的逻辑
        // projectsService.getById(id);
//        return Result.success("Get project by id: " + id);
        return Result.success(projectsService.getById(id));
    }

    //分页查询
    @ApiOperation("获取所有项目分页信息")
    @GetMapping("/all")
    public Result<BackPage<Projects>> getAllProjects(@RequestParam("pageNo") Long pageNo, @RequestParam("pageSize") Long pageSize) {
        return Result.success(projectsService.listByBackPage(pageNo, pageSize));
    }

    //获取所有项目名字，不需要分页
    @ApiOperation("获取所有项目名称")
    @GetMapping("/all/name")
    public Result<ArrayList<String>> getAllProjectNames() {
        return Result.success(projectsService.getAllProjectNames());
    }

    @ApiOperation("添加项目信息")
    @PostMapping("/add")
    public Result<?> addProject(@RequestBody ProjectsDTO projectsDTO) {
        // 检查项目名称是否已存在
        if (projectsService.isProjectNameExists(projectsDTO.getProductName())) {
            return Result.error("项目名称已存在，不能重复添加");
        }

        // 执行添加操作
        projectsService.addProject(projectsDTO);
        return Result.success("项目信息添加成功");
    }

    @ApiOperation("更新项目信息")
    @PutMapping("/{id}")
    public Result<?> updateProject(@PathVariable Long id, @RequestBody ProjectsDTO projectsDTO) {
        try {
            projectsService.updateProject(id, projectsDTO);
            return Result.success("项目信息更新成功");
        } catch (Exception e) {
            return Result.error("项目信息更新失败：" + e.getMessage());
        }
    }

    @ApiOperation("删除项目")
    @DeleteMapping("/{id}")
    @Transactional
    public Result<?> deleteAdmin(@PathVariable Long id) {
        boolean removed = projectsService.removeAllById(id);
        if (!removed) {
            return Result.error("项目信息没有发现");
        }
        return Result.success("项目信息删除成功！");
    }
}
