package com.zhiend.projectms.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ProgressEnum implements BaseEnum{
    COMPLETED(0, "已完成"),
    NORMAL(1, "正常"),
    NOT_STARTED(2, "未启动"),
    DELAYED(3, "延误");

    private Integer code;

    private String leble;//枚举文本

    ProgressEnum(Integer code, String leble) {
        this.code = code;
        this.leble = leble;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getLabel() {
        return leble;
    }
}
