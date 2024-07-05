package com.zhiend.projectms.enums;

public interface BaseEnum {
    /**
     * 根据枚举值和type获取枚举
     */
    public static <T extends BaseEnum> T getEnum(Class<T> type, int code) {
        T[] objs = type.getEnumConstants();
        for (T em : objs) {
            if (em.getCode().equals(code)) {
                return em;
            }
        }
        return null;
    }


    /**
     * 获取枚举值
     *
     * @return
     */
    Integer getCode();

    /**
     * 获取枚举文本
     *
     * @return
     */
    String getLabel();
}

