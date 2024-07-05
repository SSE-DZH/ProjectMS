package com.zhiend.projectms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhiend.projectms.dto.ModuleQuantitiesDTO;
import com.zhiend.projectms.entity.ModuleQuantities;
import com.zhiend.projectms.mapper.ModuleQuantitiesMapper;
import com.zhiend.projectms.service.IModuleQuantitiesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void addStatus(ModuleQuantitiesDTO moduleQuantitiesDTO) {
        ModuleQuantities moduleQuantities = new ModuleQuantities();
        BeanUtils.copyProperties(moduleQuantitiesDTO, moduleQuantities);
        save(moduleQuantities);
    }

    @Override
    @Transactional
    public void updateProject(ModuleQuantitiesDTO moduleQuantitiesDTO) {
        // 根据 projectId 查找模块化数量信息
        QueryWrapper<ModuleQuantities> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("project_id", moduleQuantitiesDTO.getProjectId());
        ModuleQuantities existingModuleQuantities = getOne(queryWrapper);

        if (existingModuleQuantities != null) {
            // 复制属性到现有对象
            BeanUtils.copyProperties(moduleQuantitiesDTO, existingModuleQuantities);
            // 更新对象
            updateById(existingModuleQuantities);
        } else {
            throw new RuntimeException("模块化数量信息不存在，无法更新");
        }
    }

}
