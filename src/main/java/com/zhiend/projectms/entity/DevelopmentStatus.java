package com.zhiend.projectms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.zhiend.projectms.enums.ProgressEnum;
import com.zhiend.projectms.enums.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.EnumTypeHandler;

/**
 * <p>
 * 研制状态与进展表
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("development_status")
public class DevelopmentStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 当前状态，改为枚举类型
     */
    private StatusEnum currentStatus;

    /**
     * 本周完成情况，改为枚举类型
     */
    private ProgressEnum thisWeekProgress;

    /**
     * 下周工作安排
     */
    private String nextWeekPlan;

}

