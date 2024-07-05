package com.zhiend.projectms.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.zhiend.projectms.enums.ProgressEnum;
import com.zhiend.projectms.enums.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 项目状态日志表
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("log")
public class Log implements Serializable {

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
     * 项目当前状态
     */
    private StatusEnum currentStatus;

    /**
     * 本周完成情况
     */
    private ProgressEnum completionThisWeek;

    /**
     * 记录时间
     */
    private LocalDateTime timestamp;


}
