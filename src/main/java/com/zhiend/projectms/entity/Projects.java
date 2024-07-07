package com.zhiend.projectms.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.zhiend.projectms.enums.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.EnumTypeHandler;

/**
 * <p>
 * 项目表
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("projects")
public class Projects implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品型号
     */
    private String productModel;

    /**
     * 大项目
     */
    private String majorProject;

    /**
     * 项目负责人
     */
    private String projectLeader;

    /**
     * 实物图片
     */
    private String physicalPicture;

    /**
     * 产品属性（新品/改良）
     */
    private String productAttribute;

    /**
     * 启动时间
     */
    private LocalDate startDate;

    /**
     * 立项时间
     */
    private LocalDate approvalDate;

    /**
     * 项目评分
     */
    private Integer projectScore;

    /**
     * 样机完成（人天）
     */
    private Integer workload;

    /**
     * 项目周期（天）
     */
    private Integer projectDuration;

    /**
     * 当前状态
     */
    private StatusEnum currentStatus;

    /**
     * 创建者id
     */
    private String creatorId;
}
