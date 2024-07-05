package com.zhiend.projectms.dto;

import com.zhiend.projectms.enums.ProgressEnum;
import com.zhiend.projectms.enums.StatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 项目状态日志表
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-05
 */
@Data
public class LogDTO implements Serializable {


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
