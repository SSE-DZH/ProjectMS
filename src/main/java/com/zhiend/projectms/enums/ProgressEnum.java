package com.zhiend.projectms.enums;

public enum ProgressEnum {
    COMPLETED("已完成"),
    NORMAL("正常"),
    NOT_STARTED("未启动"),
    DELAYED("延误");

    private final String progress;

    ProgressEnum(String progress) {
        this.progress = progress;
    }

    public String getProgress() {
        return progress;
    }
}
