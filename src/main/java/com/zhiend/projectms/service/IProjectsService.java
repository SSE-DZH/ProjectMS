package com.zhiend.projectms.service;

import com.zhiend.projectms.dto.ProjectsDTO;
import com.zhiend.projectms.entity.Projects;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhiend.projectms.page.BackPage;

import java.util.ArrayList;

/**
 * <p>
 * 项目表 服务类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
public interface IProjectsService extends IService<Projects> {
    BackPage<Projects> listByBackPage(Long pageNo, Long pageSize);

    ArrayList<String> getAllProjectNames();

    void addProject(ProjectsDTO projectsDTO);
    boolean isProjectNameExists(String projectName);
    void updateProject(Long id, ProjectsDTO projectsDTO);

    boolean removeAllById(Long id);

    BackPage<Projects> listByCreatorId(String creatorId, Long pageNo, Long pageSize);

    ArrayList<Long> getProjectCount();
}
