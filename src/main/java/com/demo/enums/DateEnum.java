package com.demo.enums;

/**
 * 时间格式枚举类
 * @author 皇甫
 */

public enum DateEnum {
    YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss"),
    YYYY_MM_DD("yyyy-MM-dd");

    private String format;

    DateEnum(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
