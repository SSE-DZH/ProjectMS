package com.zhiend.projectms.enums;


public enum StatusEnum implements BaseEnum{
    RESEARCH(0, "调研"),
    ONGOING(1, "在研"),
    RECTIFICATION(2, "整改"),
    NOT_STARTED(3, "未启动"),
    DELAYED(4, "延误"),
    BATCH_COMPLETED(5, "批量完成");

    private Integer code;//枚举值

    private String leble;//枚举文本

    StatusEnum(Integer code, String leble) {
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
