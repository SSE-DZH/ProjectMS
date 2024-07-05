package com.zhiend.projectms.service;

import com.zhiend.projectms.dto.ModuleQuantitiesDTO;
import com.zhiend.projectms.entity.ModuleQuantities;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 模块化数量表 服务类
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
public interface IModuleQuantitiesService extends IService<ModuleQuantities> {

    ModuleQuantities getModuleQuantities(Long projectId);

    boolean isProjectIdExists(Long projectId);

    void addStatus(ModuleQuantitiesDTO moduleQuantitiesDTO);

    void updateProject(Long id, ModuleQuantitiesDTO moduleQuantitiesDTO);
}
