package com.zhiend.projectms.controller;


import com.zhiend.projectms.dto.RiskTrackingDTO;
import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IRiskTrackingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 风险跟踪与解决表 前端控制器
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@RestController
@RequestMapping("/risk-tracking")
public class RiskTrackingController {
    @Autowired
    private IRiskTrackingService riskTrackingService;

    @ApiOperation("根据projectId获取项目风险跟踪")
    @GetMapping("/{projectId}")
    public Result<?> getRegistrationProgress(@PathVariable Long projectId) {
        return Result.success(riskTrackingService.getProjectMilestones(projectId));
    }

    @ApiOperation("添加项目风险跟踪")
    @PostMapping("/add")
    public Result<?> add(@RequestBody RiskTrackingDTO RiskTrackingDTO) {
        // 检查项目id是否已存在
        if (riskTrackingService.isProjectIdExists(RiskTrackingDTO.getProjectId())) {
            return Result.error("项目风险跟踪已存在，不能重复添加");
        }

        // 执行添加操作
        riskTrackingService.add(RiskTrackingDTO);
        return Result.success("项目风险跟踪添加成功");
    }

    @ApiOperation("更新项目风险跟踪")
    @PutMapping("/{id}")
    public Result<?> update(@PathVariable Long id, @RequestBody RiskTrackingDTO RiskTrackingDTO) {
        // 管理员操作
        try {
            riskTrackingService.updateProject(id, RiskTrackingDTO);
            return Result.success("项目风险跟踪更新成功");
        } catch (Exception e) {
            return Result.error("项目风险跟踪更新失败：" + e.getMessage());
        }
    }

    @ApiOperation("删除项目风险跟踪")
    @DeleteMapping("/{id}")
    @Transactional
    public Result<?> delete(@PathVariable Long id) {
        // 管理员操作
        try {
            riskTrackingService.removeById(id);
            return Result.success("项目风险跟踪删除成功");
        } catch (Exception e) {
            return Result.error("项目风险跟踪删除失败：" + e.getMessage());
        }
    }
}
