package com.zhiend.projectms.controller;


import com.zhiend.projectms.dto.LogDTO;
import com.zhiend.projectms.entity.Log;
import com.zhiend.projectms.result.Result;
import com.zhiend.projectms.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class LogController {

    @Autowired
    private ILogService logService;

    //日志记录
    @PostMapping("/add")
    public Result<?> addLog(LogDTO logDTO) {
        logService.addLog(logDTO);
        return Result.success();
    }

    //根据projectid查看日志
    @GetMapping("/{projectId}")
    public Result<Log> getLogByProjectId(@PathVariable Long projectId) {
        Log log =  logService.getLogByProjectId(projectId);
        return Result.success(log);
    }

}
