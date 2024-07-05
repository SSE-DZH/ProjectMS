package com.zhiend.projectms.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhiend.projectms.enums.ProgressEnum;
import com.zhiend.projectms.enums.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.EnumTypeHandler;

import java.io.Serializable;

/**
 * <p>
 * 研制状态与进展表
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Data
public class DevelopmentStatusDTO implements Serializable {


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

