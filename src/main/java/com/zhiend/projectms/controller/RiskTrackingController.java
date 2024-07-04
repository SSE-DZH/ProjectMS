package com.zhiend.projectms.controller;


import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.IRiskTrackingService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation("获取风险跟踪与解决信息")
    @GetMapping("/{id}")
    public Result<?> getRiskTracking(@PathVariable Long id) {
        // 普通用户查看功能
        // 实现根据 id 获取风险跟踪与解决信息的逻辑
        // riskTrackingService.getById(id);
        return Result.success("Get risk tracking by id: " + id);
    }
}
