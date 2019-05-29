package com.souche.spring.statemachine.events;

import lombok.Data;

/**
 * @autor yeqiaozhu.
 * @date 2019-05-30
 */
@Data
public class PayDepositPartEvent extends CommonEvent {
    //支付金额
    private Long paidMoney;
}
