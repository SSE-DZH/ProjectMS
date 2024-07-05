package com.zhiend.projectms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhiend.projectms.dto.ModuleQuantitiesDTO;
import com.zhiend.projectms.entity.ModuleQuantities;
import com.zhiend.projectms.mapper.ModuleQuantitiesMapper;
import com.zhiend.projectms.service.IModuleQuantitiesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 模块化数量表 服务实现类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Service
public class ModuleQuantitiesServiceImpl extends ServiceImpl<ModuleQuantitiesMapper, ModuleQuantities> implements IModuleQuantitiesService {

    @Override
    public ModuleQuantities getModuleQuantities(Long projectId) {
        return getOne(new QueryWrapper<ModuleQuantities>().eq("project_id", projectId));
    }

    @Override
    public boolean isProjectIdExists(Long projectId) {
        return count(new QueryWrapper<ModuleQuantities>().eq("project_id", projectId)) > 0;
    }

    @Override
    public void addStatus(ModuleQuantitiesDTO moduleQuantitiesDTO) {
        ModuleQuantities moduleQuantities = new ModuleQuantities();
        BeanUtils.copyProperties(moduleQuantitiesDTO, moduleQuantities);
        save(moduleQuantities);
    }

    @Override
    public void updateProject(Long id, ModuleQuantitiesDTO moduleQuantitiesDTO) {
        ModuleQuantities moduleQuantities = new ModuleQuantities();
        BeanUtils.copyProperties(moduleQuantitiesDTO, moduleQuantities);
        moduleQuantities.setId(id);
        updateById(moduleQuantities);
    }
}
