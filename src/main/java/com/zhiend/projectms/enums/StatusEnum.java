package com.zhiend.projectms.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum StatusEnum  {
    RESEARCH(0, "调研"),
    ONGOING(1, "在研"),
    RECTIFICATION(2, "整改"),
    NOT_STARTED(3, "未启动"),
    DELAYED(4, "延误"),
    BATCH_COMPLETED(5, "批量完成");

    @EnumValue //标记存储到数据库的值
    @JsonValue //标记json返回的值
    private final Integer code;

    private final String remark;

    StatusEnum(Integer code, String remark) {
        this.code = code;
        this.remark = remark;
    }
}
