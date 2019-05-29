package com.souche.spring.statemachine.configs.orders;

/**
 * 定义触发节点变更的所有事件
 */
public enum OrderEventEnum {

    SIGN_CONTRACT_EVENT("签署电子合同"),
    PAY_DEPOSIT_PART_EVENT("部分支付定金");

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
