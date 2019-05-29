package com.souche.spring.statemachine.actions;

import com.souche.spring.statemachine.configs.orders.OrderEventEnum;
import com.souche.spring.statemachine.configs.orders.OrderStateEnum;
import org.springframework.statemachine.StateContext;
import org.springframework.stereotype.Service;

/**
 * @autor yeqiaozhu.
 * @date 2019-05-22
 */
@Service("payDepositPartAction")
public class PayDepositPartAction extends AbstractAction {

    @Override
    public void execute(StateContext<OrderStateEnum, OrderEventEnum> stateContext) {
        //支付定金action
        System.out.println("执行付定金事件对应动作...");
    }
}
