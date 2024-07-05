package com.zhiend.projectms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhiend.projectms.dto.LogDTO;
import com.zhiend.projectms.entity.Log;
import com.zhiend.projectms.mapper.LogMapper;
import com.zhiend.projectms.service.ILogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 项目状态日志表 服务实现类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-05
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {

    @Override
    public void addLog(LogDTO logDTO) {
        Log log = new Log();
        BeanUtils.copyProperties(logDTO, log);
        log.setCurrentStatus(logDTO.getCurrentStatus());
        log.setCompletionThisWeek(logDTO.getCompletionThisWeek());
        this.save(log);
    }


    @Override
    @Transactional
    public void deleteLogByProjectId(Long projectId) {
        QueryWrapper<Log> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", projectId);
        this.remove(queryWrapper);
    }

    @Override
    public List<Log> getLogByProjectId(Long projectId) {
        QueryWrapper<Log> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", projectId);
        return this.list(queryWrapper);
    }

}
