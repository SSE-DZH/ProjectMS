package com.zhiend.projectms.controller;


import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IDevelopmentStatusService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DevelopmentStatusController {
    @Autowired
    private IDevelopmentStatusService developmentStatusService;

    @ApiOperation("获取研制状态与进展信息")
    @GetMapping("/{id}")
    public Result<?> getDevelopmentStatus(@PathVariable Long id) {
        // 普通用户查看功能
        // 实现根据 id 获取研制状态与进展信息的逻辑
        // developmentStatusService.getById(id);
        return Result.success("Get development status by id: " + id);
    }

    @ApiOperation("添加研制状态与进展信息")
    @PostMapping("/add")
    public Result<?> addDevelopmentStatus(@RequestBody DevelopmentStatusDTO statusDTO) {
        // 管理员操作
        // 实现添加研制状态与进展信息的逻辑
        return Result.success("Add development status successfully");
    }

    @ApiOperation("更新研制状态与进展信息")
    @PutMapping("/{id}")
    public Result<?> updateDevelopmentStatus(@PathVariable Long id, @RequestBody DevelopmentStatusDTO statusDTO) {
        // 管理员操作
        // 实现更新研制状态与进展信息的逻辑
        return Result.success("Update development status successfully");
    }

    @ApiOperation("删除研制状态与进展信息")
    @DeleteMapping("/{id}")
    public Result<?> deleteDevelopmentStatus(@PathVariable Long id) {
        // 管理员操作
        // 实现删除研制状态与进展信息的逻辑
        return Result.success("Delete development status successfully");
    }
}
