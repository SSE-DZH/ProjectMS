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
 * 注册进度表
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("registration_progress")
public class RegistrationProgress implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目ID
     */
    private Integer projectId;

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
