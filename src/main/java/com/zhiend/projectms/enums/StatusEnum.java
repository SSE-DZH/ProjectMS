package com.zhiend.projectms.enums;

public enum StatusEnum {
    RESEARCH("调研"),
    ONGOING("在研"),
    RECTIFICATION("整改"),
    NOT_STARTED("未启动"),
    DELAYED("延误"),
    BATCH_COMPLETED("批量完成");

    private final String status;

    StatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
