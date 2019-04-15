package com.souche.spring.statemachine;

/**
 * 定义触发节点变更的所有事件
 */
public enum OrderEventEnum {

    CREATE_ORDER_EVENT("创建销售订单"),
    SIGN_CONTRACT_EVENT("签署电子合同"),
    PAY_DEPOSIT_PART_EVENT("部分支付定金"),
    PAY_DEPOSIT_ALL_EVENT("定金支付完成");

    private String  name;

    OrderEventEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
