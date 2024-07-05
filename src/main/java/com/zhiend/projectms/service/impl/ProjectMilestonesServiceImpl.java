package com.zhiend.projectms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhiend.projectms.dto.ProjectMilestonesDTO;
import com.zhiend.projectms.entity.ProjectMilestones;
import com.zhiend.projectms.mapper.ProjectMilestonesMapper;
import com.zhiend.projectms.service.IProjectMilestonesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 项目节点完成情况表 服务实现类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Service
public class ProjectMilestonesServiceImpl extends ServiceImpl<ProjectMilestonesMapper, ProjectMilestones> implements IProjectMilestonesService {

    @Override
    public ProjectMilestones getProjectMilestones(Long projectId) {
        return getOne(new QueryWrapper<ProjectMilestones>().eq("project_id", projectId));
    }

    @Override
    public boolean isProjectIdExists(Long projectId) {
        return count(new QueryWrapper<ProjectMilestones>().eq("project_id", projectId)) > 0;
    }

    @Override
    @Transactional
    public void addProjectMilestones(ProjectMilestonesDTO projectMilestonesDTO) {
        ProjectMilestones projectMilestones = new ProjectMilestones();
        BeanUtils.copyProperties(projectMilestonesDTO, projectMilestones);
        save(projectMilestones);
    }

    @Override
    @Transactional
    public void updateProject(Long id, ProjectMilestonesDTO projectMilestonesDTO) {
        ProjectMilestones projectMilestones = new ProjectMilestones();
        BeanUtils.copyProperties(projectMilestonesDTO, projectMilestones);
        projectMilestones.setId(id);
        updateById(projectMilestones);
    }
}
