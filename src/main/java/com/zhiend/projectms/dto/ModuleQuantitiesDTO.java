package com.zhiend.projectms.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 模块化数量表
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Data
public class ModuleQuantitiesDTO implements Serializable {

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 硬件数量
     */
    private Long hardwareQuantity;

    /**
     * 软件数量
     */
    private Long softwareQuantity;


}
