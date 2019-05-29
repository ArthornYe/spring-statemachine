package com.souche.spring.statemachine.actions;

import com.souche.spring.statemachine.configs.orders.OrderEventEnum;
import com.souche.spring.statemachine.configs.orders.OrderStateEnum;
import org.springframework.statemachine.StateContext;
import org.springframework.stereotype.Service;

@Service("signContractAction")
public class SignContractAction extends AbstractAction {

    @Override
    public void execute(StateContext<OrderStateEnum, OrderEventEnum> stateContext) {
        //签署合同action
        System.out.println("执行签署合同事件对应动作...");

    }
}
