package com.zhiend.projectms.service;

import com.zhiend.projectms.dto.ProjectMilestonesDTO;
import com.zhiend.projectms.entity.ProjectMilestones;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 项目节点完成情况表 服务类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
public interface IProjectMilestonesService extends IService<ProjectMilestones> {

    ProjectMilestones getProjectMilestones(Long projectId);

    boolean isProjectIdExists(Long projectId);

    void addProjectMilestones(ProjectMilestonesDTO projectMilestonesDTO);

    void updateProject(Long id, ProjectMilestonesDTO projectMilestonesDTO);
}
