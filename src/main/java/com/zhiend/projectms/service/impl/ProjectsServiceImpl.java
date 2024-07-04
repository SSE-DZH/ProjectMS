package com.zhiend.projectms.service.impl;

import com.zhiend.projectms.entity.Projects;
import com.zhiend.projectms.mapper.ProjectsMapper;
import com.zhiend.projectms.service.IProjectsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
