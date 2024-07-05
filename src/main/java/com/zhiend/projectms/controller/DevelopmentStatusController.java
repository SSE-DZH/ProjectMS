package com.zhiend.projectms.controller;


import com.zhiend.projectms.dto.DevelopmentStatusDTO;
import com.zhiend.projectms.entity.Admin;
import com.zhiend.projectms.entity.DevelopmentStatus;
import com.zhiend.projectms.page.BackPage;
import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IDevelopmentStatusService;
import com.zhiend.projectms.service.IProjectsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 研制状态与进展表 前端控制器
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@RestController
@RequestMapping("/development-status")
@Api(tags = "研制状态与进展管理")
public class DevelopmentStatusController {
    @Autowired
    private IDevelopmentStatusService developmentStatusService;

    @Autowired
    private IProjectsService projectsService;

    //分页查询
    @ApiOperation("获取所有研制状态与进展分页信息")
    @GetMapping("/all")
    public Result<BackPage<DevelopmentStatus>> getAllDevelopmentStatus(@RequestParam("pageNo") Long pageNo, @RequestParam("pageSize") Long pageSize) {
        // 普通用户查看功能
        // 实现分页查询所有研制状态与进展信息的逻辑
        // developmentStatusService.page(pageNo, pageSize);
        BackPage<DevelopmentStatus> list = developmentStatusService.listByBackPage(pageNo, pageSize);
        return Result.success(list);
    }

    @ApiOperation("根据项目id获取项目进展状态信息")
    @GetMapping("/{projectId}")
    public Result<?> getDevelopmentStatusByProjectId(@PathVariable Long projectId) {
        // 普通用户查看功能
        // 实现根据项目 id 获取项目进展状态信息的逻辑
        // developmentStatusService.getById(id);
        DevelopmentStatus developmentStatus = developmentStatusService.getByPorjectId(projectId);
        return Result.success(developmentStatus);
    }


    @ApiOperation("根据状态id获取项目详细信息")
    @GetMapping("/{id}")
    public Result<?> getDevelopmentStatus(@PathVariable Long id) {
        // 普通用户查看功能
        // 实现根据 id 获取研制状态与进展信息的逻辑
        // developmentStatusService.getById(id);
        DevelopmentStatus developmentStatus = developmentStatusService.getById(id);
        return Result.success(projectsService.getById(developmentStatus.getProjectId()));
    }

    @ApiOperation("添加研制状态与进展信息")
    @PostMapping("/add")
    public Result<?> addDevelopmentStatus(@RequestBody DevelopmentStatusDTO statusDTO) {
        // 检查项目id是否已存在
        if (developmentStatusService.isProjectIdExists(statusDTO.getProjectId())) {
            return Result.error("项目状态已存在，不能重复添加");
        }

        // 执行添加操作
        developmentStatusService.addStatus(statusDTO);
        return Result.success("项目状态添加成功");
    }

    @ApiOperation("更新研制状态与进展信息")
    @PutMapping("/{id}")
    public Result<?> updateDevelopmentStatus(@PathVariable Long id, @RequestBody DevelopmentStatusDTO statusDTO) {
        // 管理员操作
        // 实现更新研制状态与进展信息的逻辑
        try {
            developmentStatusService.updateProject(id, statusDTO);
            return Result.success("项目状态信息更新成功");
        } catch (Exception e) {
            return Result.error("项目状态信息更新失败：" + e.getMessage());
        }
    }

    @ApiOperation("删除研制状态与进展信息")
    @DeleteMapping("/{id}")
    @Transactional
    public Result<?> deleteDevelopmentStatus(@PathVariable Long id) {
        boolean removed = developmentStatusService.removeById(id);
        if (!removed) {
            return Result.error("Admin not found");
        }
        return Result.success("Admin deleted successfully");
    }
}
