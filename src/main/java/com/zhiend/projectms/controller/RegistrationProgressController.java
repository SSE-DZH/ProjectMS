package com.zhiend.projectms.controller;


import com.zhiend.projectms.dto.RegistrationProgressDTO;
import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IRegistrationProgressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "注册进度管理")
public class RegistrationProgressController {
    @Autowired
    private IRegistrationProgressService registrationProgressService;

    @ApiOperation("根据projectId获取项目注册进度")
    @GetMapping("/{projectId}")
    public Result<?> getRegistrationProgress(@PathVariable Long projectId) {
        return Result.success(registrationProgressService.getProjectMilestones(projectId));
    }

    @ApiOperation("添加项目注册进度")
    @PostMapping("/add")
    public Result<?> add(@RequestBody RegistrationProgressDTO RegistrationProgressDTO) {
        // 检查项目id是否已存在
        if (registrationProgressService.isProjectIdExists(RegistrationProgressDTO.getProjectId())) {
            return Result.error("项目注册进度已存在，不能重复添加");
        }

        // 执行添加操作
        registrationProgressService.add(RegistrationProgressDTO);
        return Result.success("项目注册进度添加成功");
    }

    @ApiOperation("更新项目注册进度")
    @PutMapping("/{id}")
    public Result<?> update(@PathVariable Long id, @RequestBody RegistrationProgressDTO RegistrationProgressDTO) {
        // 管理员操作
        try {
            registrationProgressService.updateProject(id, RegistrationProgressDTO);
            return Result.success("项目注册进度更新成功");
        } catch (Exception e) {
            return Result.error("项目注册进度更新失败：" + e.getMessage());
        }
    }

    @ApiOperation("删除项目注册进度")
    @DeleteMapping("/{id}")
    @Transactional
    public Result<?> delete(@PathVariable Long id) {
        // 管理员操作
        try {
            registrationProgressService.removeById(id);
            return Result.success("项目注册进度删除成功");
        } catch (Exception e) {
            return Result.error("项目注册进度删除失败：" + e.getMessage());
        }
    }
}
