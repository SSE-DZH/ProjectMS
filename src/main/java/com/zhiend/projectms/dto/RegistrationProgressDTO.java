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
 * 注册进度表
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Data
public class RegistrationProgressDTO implements Serializable {

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 注册类型
     */
    private String registrationType;

    /**
     * 注册提交日期
     */
    private LocalDate submissionDate;

    /**
     * 注册申报日期
     */
    private LocalDate declarationDate;

    /**
     * 体考日期
     */
    private LocalDate testDate;

    /**
     * 下证日期
     */
    private LocalDate certificateDate;


}
