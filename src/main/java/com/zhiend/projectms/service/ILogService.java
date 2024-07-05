package com.zhiend.projectms.service;

import com.zhiend.projectms.dto.LogDTO;
import com.zhiend.projectms.entity.Log;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 项目状态日志表 服务类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-05
 */
public interface ILogService extends IService<Log> {

    void addLog(LogDTO logDTO);

    Log getLogByProjectId(Long projectId);

    //根据projectid删除
    void deleteLogByProjectId(Long projectId);
}
