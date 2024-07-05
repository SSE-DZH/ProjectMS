package com.zhiend.projectms.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum ProgressEnum{
    COMPLETED(0, "已完成"),
    NORMAL(1, "正常"),
    NOT_STARTED(2, "未启动"),
    DELAYED(3, "延误");

    @EnumValue //标记存储到数据库的值
    @JsonValue //标记json返回的值
    private final Integer code;

    private final String remark;

    ProgressEnum(Integer code, String remark) {
        this.code = code;
        this.remark = remark;
    }
}
