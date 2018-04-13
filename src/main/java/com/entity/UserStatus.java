package com.entity;

public enum UserStatus {

    NORMAL(0, "正常"),

    FREEZE(1, "冻结");

    private int key;
    private String value;

    UserStatus(int key, String value) {
        this.key = key;
        this.value = value;
    }

    UserStatus(String value) {
        this.key = key;
        this.value = value;
    }

    UserStatus(int key) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static String getValueByKey(int key) {
        UserStatus[] enums = UserStatus.values();
        for (int i = 0; i < enums.length; i++) {
            if (enums[i].getKey() == key) {
                return enums[i].getValue();
            }
        }
        return "";
    }

    public static Integer getKeyByValue(String value) {
        UserStatus[] enums = UserStatus.values();
        for (int i = 0; i < enums.length; i++) {
            if (enums[i].getValue().equals(value)) {
                return enums[i].getKey();
            }
        }
        return null;
    }
}
