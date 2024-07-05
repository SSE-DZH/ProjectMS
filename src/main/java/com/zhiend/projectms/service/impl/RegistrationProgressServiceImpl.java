package com.zhiend.projectms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhiend.projectms.dto.RegistrationProgressDTO;
import com.zhiend.projectms.entity.ModuleQuantities;
import com.zhiend.projectms.entity.RegistrationProgress;
import com.zhiend.projectms.mapper.RegistrationProgressMapper;
import com.zhiend.projectms.service.IRegistrationProgressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 注册进度表 服务实现类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Service
public class RegistrationProgressServiceImpl extends ServiceImpl<RegistrationProgressMapper, RegistrationProgress> implements IRegistrationProgressService {

    @Override
    public RegistrationProgress getProjectMilestones(Long projectId) {
        return getOne(new QueryWrapper<RegistrationProgress>().eq("project_id", projectId));
    }

    @Override
    public boolean isProjectIdExists(Long projectId) {
        return count(new QueryWrapper<RegistrationProgress>().eq("project_id", projectId)) > 0;
    }

    @Override
    @Transactional
    public void add(RegistrationProgressDTO registrationProgressDTO) {
        RegistrationProgress registrationProgress = new RegistrationProgress();
        BeanUtils.copyProperties(registrationProgressDTO, registrationProgress);
        save(registrationProgress);
    }

    @Override
    @Transactional
    public void updateProject(RegistrationProgressDTO registrationProgressDTO) {
        QueryWrapper<RegistrationProgress> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", registrationProgressDTO.getProjectId());
        RegistrationProgress registrationProgress = getOne(queryWrapper);

        if (registrationProgress != null) {
            // 复制属性到现有对象
            BeanUtils.copyProperties(registrationProgressDTO, registrationProgress);
            // 更新对象
            updateById(registrationProgress);
        } else {
            throw new RuntimeException("模块化数量信息不存在，无法更新");
        }
    }
}
