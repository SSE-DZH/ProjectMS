package com.zhiend.projectms.controller;


import com.zhiend.projectms.dto.LogDTO;
import com.zhiend.projectms.entity.Log;
import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.ILogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 项目状态日志表 前端控制器
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-05
 */
@RestController
@RequestMapping("/log")
@Api(tags = "项目状态日志管理")
public class LogController {

    @Autowired
    private ILogService logService;

    //日志记录
    @PostMapping("/add")
    @ApiOperation("添加日志记录")
    public Result<?> addLog(LogDTO logDTO) {
        logService.addLog(logDTO);
        return Result.success();
    }

    //根据projectid查看日志
    @GetMapping("/{projectId}")
    @ApiOperation("根据项目id获取日志信息")
    public Result<List<Log>> getLogByProjectId(@PathVariable Long projectId) {
        List<Log> logs =  logService.getLogByProjectId(projectId);
        return Result.success(logs);
    }

}
