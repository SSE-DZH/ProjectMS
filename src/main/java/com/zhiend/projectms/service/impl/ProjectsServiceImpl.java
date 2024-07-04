package com.zhiend.projectms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiend.projectms.dto.ProjectsDTO;
import com.zhiend.projectms.entity.Projects;
import com.zhiend.projectms.entity.Projects;
import com.zhiend.projectms.enums.StatusEnum;
import com.zhiend.projectms.mapper.ProjectsMapper;
import com.zhiend.projectms.page.BackPage;
import com.zhiend.projectms.service.IProjectsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
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
                .setCurrentStatus(projectsDTO.getCurrentStatus());

        save(projects);
    }


    @Override
    @Transactional
    public void updateProject(Long id, ProjectsDTO projectsDTO) {
        Projects project = getById(id);
        if (project != null) {
            // 检查项目名称是否已存在
            if (!projectsDTO.getProductName().equals(project.getProductName()) && isProjectNameExists(projectsDTO.getProductName())) {
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

}
