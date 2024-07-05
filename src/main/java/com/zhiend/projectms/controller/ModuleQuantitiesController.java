package com.zhiend.projectms.controller;


import com.zhiend.projectms.dto.ModuleQuantitiesDTO;
import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IModuleQuantitiesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "模块化数量管理")
public class ModuleQuantitiesController {
    @Autowired
    private IModuleQuantitiesService moduleQuantitiesService;

    @ApiOperation("根据project_id获取模块化数量信息")
    @GetMapping("/{projectId}")
    public Result<?> getModuleQuantities(@PathVariable Long projectId) {
        return Result.success(moduleQuantitiesService.getModuleQuantities(projectId));
    }

    @ApiOperation("添加模块化数量信息")
    @PostMapping("/add")
    public Result<?> add(@RequestBody ModuleQuantitiesDTO moduleQuantitiesDTO) {
        // 检查项目id是否已存在
        if (moduleQuantitiesService.isProjectIdExists(moduleQuantitiesDTO.getProjectId())) {
            return Result.error("项目模块化数量已存在，不能重复添加");
        }

        // 执行添加操作
        moduleQuantitiesService.addStatus(moduleQuantitiesDTO);
        return Result.success("项目模块化数量添加成功");
    }

    @ApiOperation("更新模块化数量信息")
    @PutMapping("/{id}")
    public Result<?> update(@PathVariable Long id, @RequestBody ModuleQuantitiesDTO moduleQuantitiesDTO) {
        // 管理员操作
        // 实现更新研制状态与进展信息的逻辑
        try {
            moduleQuantitiesService.updateProject(id, moduleQuantitiesDTO);
            return Result.success("项目状态信息更新成功");
        } catch (Exception e) {
            return Result.error("项目状态信息更新失败：" + e.getMessage());
        }
    }

    @ApiOperation("删除模块化数量信息")
    @DeleteMapping("/{id}")
    @Transactional
    public Result<?> delete(@PathVariable Long id) {
        // 管理员操作
        // 实现删除项目状态信息的逻辑
        try {
            moduleQuantitiesService.removeById(id);
            return Result.success("项目模块化信息删除成功");
        } catch (Exception e) {
            return Result.error("项目模块化信息删除失败：" + e.getMessage());
        }
    }
}
