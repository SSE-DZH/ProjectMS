package com.zhiend.projectms.service;

import com.zhiend.projectms.dto.RegistrationProgressDTO;
import com.zhiend.projectms.entity.RegistrationProgress;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 注册进度表 服务类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
public interface IRegistrationProgressService extends IService<RegistrationProgress> {

    RegistrationProgress getProjectMilestones(Long projectId);

    boolean isProjectIdExists(Long projectId);

    void add(RegistrationProgressDTO registrationProgressDTO);

    void updateProject(RegistrationProgressDTO registrationProgressDTO);

    void deleteByProjectId(Long id);
}
