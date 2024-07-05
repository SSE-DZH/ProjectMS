package com.zhiend.projectms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 项目节点完成情况表
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("project_milestones")
public class ProjectMilestones implements Serializable {

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
