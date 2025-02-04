package com.zhiend.projectms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiend.projectms.dto.LogDTO;
import com.zhiend.projectms.dto.ProjectsDTO;
import com.zhiend.projectms.entity.DevelopmentStatus;
import com.zhiend.projectms.entity.Projects;
import com.zhiend.projectms.mapper.ProjectsMapper;
import com.zhiend.projectms.page.BackPage;
import com.zhiend.projectms.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 项目表 服务实现类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Service
public class ProjectsServiceImpl extends ServiceImpl<ProjectsMapper, Projects> implements IProjectsService {
    @Autowired
    private ProjectsMapper projectsMapper;

    @Autowired
    private IDevelopmentStatusService developmentStatusService;

    @Autowired
    private IModuleQuantitiesService moduleQuantitiesService;

    @Autowired
    private ILogService logService;

    @Autowired
    private IRegistrationProgressService registrationProgressService;

    @Autowired
    private IRiskTrackingService riskService;

    @Autowired
    private IProjectMilestonesService projectMilestonesService;

    @Override
    public BackPage<Projects> listByBackPage(Long pageNo, Long pageSize) {
        BackPage<Projects> ProjectsBackPage = new BackPage<>();
        // 设置条件构造器
        QueryWrapper<Projects> wrapper = new QueryWrapper<>();
        // 构造分页信息，其中的Page<>(page, PAGE_RECORDS_NUM)的第一个参数是第几页，而第二个参数是每页的记录数
        Page<Projects> ProjectsPage = new Page<>(pageNo, pageSize);
        // page(ProjectsPage, wrapper)这里的第一个参数就是上面定义了的Page对象，第二个参数就是上面定义的条件构造器对象，通过调用这个方法就可以根据你的分页信息以及查询信息获取分页数据
        IPage<Projects> ProjectsIPage = page(ProjectsPage, wrapper);
        // 封装数据，其中getRecords()是获取记录数，getCurrent()获取当前页数，getPages()获取总页数，getTotal()获取记录总数，还要其他更多的方法，大家可以自行查看，在这里就不过多赘述了
        ProjectsBackPage.setContentList(ProjectsIPage.getRecords());
        ProjectsBackPage.setCurrentPage(ProjectsIPage.getCurrent());
        ProjectsBackPage.setTotalPage(ProjectsIPage.getPages());
        ProjectsBackPage.setTotalNum(ProjectsIPage.getTotal());
        return ProjectsBackPage;
    }

    @Override
    public ArrayList<String> getAllProjectNames() {
        QueryWrapper<Projects> wrapper = new QueryWrapper<>();
        List<String> projectNames = this.list(wrapper)
                .stream()
                .map(Projects::getProductName)
                .collect(Collectors.toList());
        return new ArrayList<>(projectNames);
    }

    @Override
    public boolean isProjectNameExists(String projectName) {
        QueryWrapper<Projects> wrapper = new QueryWrapper<>();
        wrapper.eq("product_name", projectName);
        return count(wrapper) > 0;
    }

    @Override
    @Transactional
    public void addProject(ProjectsDTO projectsDTO) {
        Projects projects = new Projects()
                .setProductName(projectsDTO.getProductName())
                .setProductModel(projectsDTO.getProductModel())
                .setMajorProject(projectsDTO.getMajorProject())
                .setProjectLeader(projectsDTO.getProjectLeader())
                .setPhysicalPicture(projectsDTO.getPhysicalPicture())
                .setProductAttribute(projectsDTO.getProductAttribute())
                .setStartDate(projectsDTO.getStartDate())
                .setApprovalDate(projectsDTO.getApprovalDate())
                .setProjectScore(projectsDTO.getProjectScore())
                .setWorkload(projectsDTO.getWorkload())
                .setProjectDuration(projectsDTO.getProjectDuration())
                .setCurrentStatus(projectsDTO.getCurrentStatus())
                .setCreatorId(projectsDTO.getCreatorId());
        save(projects);
        LogDTO logDTO = LogDTO.builder()
                .projectId(projects.getId())
                .currentStatus(projects.getCurrentStatus())
                .build();
        logService.addLog(logDTO);
    }


    @Override
    @Transactional
    public void updateProject(Long id, ProjectsDTO projectsDTO) {
        Projects project = getById(id);
        if (project != null) {
            // 检查项目名称是否已存在，但排除当前项目的名称
            if (!projectsDTO.getProductName().equals(project.getProductName()) && isProjectNameExistsExceptCurrent(projectsDTO.getProductName(), id)) {
                throw new RuntimeException("项目名称已存在，无法更新");
            }
            BeanUtils.copyProperties(projectsDTO, project);
            // 需要单独设置枚举类型的字段
            project.setCurrentStatus(projectsDTO.getCurrentStatus());
            updateById(project);
        } else {
            throw new RuntimeException("项目不存在，无法更新");
        }
    }

    @Override
    @Transactional
    public boolean removeAllById(Long id) {
        logService.deleteLogByProjectId(id);
        developmentStatusService.deleteByProjectId(id);
        moduleQuantitiesService.deleteByProjectId(id);
        registrationProgressService.deleteByProjectId(id);
        projectMilestonesService.deleteByProjectId(id);
        riskService.deleteByProjectId(id);
        return removeById(id);
    }

    @Override
    public BackPage<Projects> listByCreatorId(String creatorId, Long pageNo, Long pageSize) {
        BackPage<Projects> ProjectsBackPage = new BackPage<>();
        // 设置条件构造器
        QueryWrapper<Projects> wrapper = new QueryWrapper<>();
        wrapper.eq("creator_id", creatorId);
        // 构造分页信息，其中的Page<>(page, PAGE_RECORDS_NUM)的第一个参数是第几页，而第二个参数是每页的记录数
        Page<Projects> ProjectsPage = new Page<>(pageNo, pageSize);
        // page(ProjectsPage, wrapper)这里的第一个参数就是上面定义了的Page对象，第二个参数就是上面定义的条件构造器对象，通过调用这个方法就可以根据你的分页信息以及查询信息获取分页数据
        IPage<Projects> ProjectsIPage = page(ProjectsPage, wrapper);
        // 封装数据，其中getRecords()是获取记录数，getCurrent()获取当前页数，getPages()获取总页数，getTotal()获取记录总数，还要其他更多的方法，大家可以自行查看，在这里就不过多赘述了
        ProjectsBackPage.setContentList(ProjectsIPage.getRecords());
        ProjectsBackPage.setCurrentPage(ProjectsIPage.getCurrent());
        ProjectsBackPage.setTotalPage(ProjectsIPage.getPages());
        ProjectsBackPage.setTotalNum(ProjectsIPage.getTotal());
        return ProjectsBackPage;
    }

    @Override
    public ArrayList<Long> getProjectCount() {
        //首先返回项目总数
        ArrayList<Long> countList = new ArrayList<>();
        countList.add(count());
        //返回状态为0的项目总数
        countList.add(count(new QueryWrapper<Projects>().eq("current_status", 0)));
        //返回状态为1的项目总数
        countList.add(count(new QueryWrapper<Projects>().eq("current_status", 1)));
        //返回状态为2的项目总数
        countList.add(count(new QueryWrapper<Projects>().eq("current_status", 2)));
        //返回状态为3的项目总数
        countList.add(count(new QueryWrapper<Projects>().eq("current_status", 3)));
        //返回状态为4的项目总数
        countList.add(count(new QueryWrapper<Projects>().eq("current_status", 4)));
        //返回状态为5的项目总数
        countList.add(count(new QueryWrapper<Projects>().eq("current_status", 5)));
        return countList;
    }

    /**
     * 检查项目名称是否存在，排除当前项目的名称
     *
     * @param projectName 项目名称
     * @param projectId   当前项目ID
     * @return 如果名称存在返回true，否则返回false
     */
    private boolean isProjectNameExistsExceptCurrent(String projectName, Long projectId) {
        return projectsMapper.selectCount(
                new QueryWrapper<Projects>()
                        .eq("product_name", projectName)
                        .ne("id", projectId)
        ) > 0;
    }


}
