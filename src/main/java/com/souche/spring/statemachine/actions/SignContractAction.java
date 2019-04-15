package com.souche.spring.statemachine.actions;

import com.souche.spring.statemachine.OrderEventEnum;
import com.souche.spring.statemachine.OrderStateEnum;
import org.springframework.statemachine.StateContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;

@Service("signContractAction")
public class SignContractAction extends AbstractAction {

    @Override
    public void execute(StateContext<OrderStateEnum, OrderEventEnum> stateContext) {
        super.execute(stateContext);
        //
        System.out.println("第二个action进来执行");

    }
}
