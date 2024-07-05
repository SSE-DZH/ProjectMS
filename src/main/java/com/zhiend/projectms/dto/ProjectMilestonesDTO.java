package com.zhiend.projectms.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 项目节点完成情况表
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Data
public class ProjectMilestonesDTO implements Serializable {

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 项目节点名称
     */
    private String milestoneName;

    /**
     * 计划完成时间
     */
    private LocalDate plannedDate;

    /**
     * 实际完成时间
     */
    private LocalDate actualDate;

    /**
     * 事业部
     */
    private String division;

    /**
     * 公共组
     */
    private String commonGroup;


}
