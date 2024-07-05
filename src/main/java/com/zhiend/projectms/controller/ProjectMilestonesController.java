package com.zhiend.projectms.controller;


import com.zhiend.projectms.dto.ProjectMilestonesDTO;
import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IProjectMilestonesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "项目节点管理")
public class ProjectMilestonesController {
    @Autowired
    private IProjectMilestonesService projectMilestonesService;

    @ApiOperation("根据projectId获取项目节点")
    @GetMapping("/{projectId}")
    public Result<?> getProjectMilestones(@PathVariable Long projectId) {
        return Result.success(projectMilestonesService.getProjectMilestones(projectId));
    }

    @ApiOperation("添加项目节点")
    @PostMapping("/add")
    public Result<?> add(@RequestBody ProjectMilestonesDTO ProjectMilestonesDTO) {
        // 检查项目id是否已存在
        if (projectMilestonesService.isProjectIdExists(ProjectMilestonesDTO.getProjectId())) {
            return Result.error("项目节点已存在，不能重复添加");
        }

        // 执行添加操作
        projectMilestonesService.addProjectMilestones(ProjectMilestonesDTO);
        return Result.success("项目节点添加成功");
    }

    @ApiOperation("更新项目节点")
    @PutMapping("/{id}")
    public Result<?> update(@PathVariable Long id, @RequestBody ProjectMilestonesDTO ProjectMilestonesDTO) {
        // 管理员操作
        try {
            projectMilestonesService.updateProject(id, ProjectMilestonesDTO);
            return Result.success("项目节点更新成功");
        } catch (Exception e) {
            return Result.error("项目节点更新失败：" + e.getMessage());
        }
    }

    @ApiOperation("删除项目节点")
    @DeleteMapping("/{id}")
    @Transactional
    public Result<?> delete(@PathVariable Long id) {
        // 管理员操作
        // 实现删除项目状态信息的逻辑
        try {
            projectMilestonesService.removeById(id);
            return Result.success("项目节点删除成功");
        } catch (Exception e) {
            return Result.error("项目节点删除失败：" + e.getMessage());
        }
    }
}
