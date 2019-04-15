package com.souche.spring.statemachine;

/**
 * 定义可以变更的所有节点
 */
public enum OrderStateEnum {

    WAITPAY("待签署合同", 100),//通用版为 待支付定金
    SIGN_CONTRACT("已签署合同，待支付定金",110),
    PAYING("定金收款中", 150),
    WAITGIVECAR("定金收全款", 200),
    RETAINAGE_PAYING("尾款收款中", 210),
    RETAINAGE_PAYED("尾款收全款", 220),
    HAND_CAR("卖家已交车", 300),
    CARRAY_CAR("终端已提车", 310),
    CONFIRM_HAND_CAR("确认交车", 350),
    FINISH("审核通过，交易完成", 500),
    CUSTOMER_UNPAY_CANCEL("客户未及时支付取消订单", 510),
    OPERATOR_TERMINATE("订单关闭", 520),
    CUSTOMER_ACTIVE_CANCEL("客户在淘宝上主动取消订单", 530),
    DEALER_NOPAY("买家未及时支付关闭", 550),
    STOCK_FAIL("备货失败关闭", 560),
    CONFIRMING("待确认", 900),
    INVALID("无效作废", 950);


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
