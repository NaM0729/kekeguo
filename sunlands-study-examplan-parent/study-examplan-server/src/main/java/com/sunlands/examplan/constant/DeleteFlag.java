package com.sunlands.examplan.constant;

public enum DeleteFlag {

    /**
     * 正常
     */
    NORMAL(0),
    /**
     * 删除
     */
    DELETE(1);

    private int value;

    DeleteFlag(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
