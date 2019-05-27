package com.souche.spring.statemachine.StateConfigs.OrderStateConfigs;

/**
 * 定义可以变更的所有节点
 */
public enum OrderStateEnum {

    WAITPAY("待签署合同", 100),//通用版为 待支付定金
    SIGN_CONTRACT("已签署合同，待支付定金",110),
    PAYING("定金收款中", 150);


    private String name;
    private int code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    OrderStateEnum(String name, int code) {
        this.name = name;
        this.code = code;
    }
    public static String getName(int code) {
        for (OrderStateEnum item : OrderStateEnum.values()) {
            if (item.code==code) {
                return item.name;
            }
        }
        return null;
    }

    public static OrderStateEnum getByCode(int code) {
        for (OrderStateEnum item : OrderStateEnum.values()) {
            if (item.code == code) {
                return item;
            }
        }
        return null;
    }
}
