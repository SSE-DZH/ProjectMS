package com.zhiend.projectms.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zhiend.projectms.enums.ProgressEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.EnumTypeHandler;

import java.io.Serializable;

/**
 * <p>
 * 风险跟踪与解决表
 * </p>
 *
 * @author Zhiend
 * @since 2024-07-04
 */
@Data
public class RiskTrackingDTO implements Serializable {

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 风险属性
     */
    private String riskAttribute;

    /**
     * 风险问题的描述
     */
    private String riskDescription;

    /**
     * 解决方案
     */
    private String solution;

    /**
     * 当前进度
     */
    @TableField(typeHandler = EnumTypeHandler.class)
    private ProgressEnum currentProgress;


}
