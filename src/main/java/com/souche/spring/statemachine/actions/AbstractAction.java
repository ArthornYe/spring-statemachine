package com.souche.spring.statemachine.actions;

import com.souche.spring.statemachine.StateConfigs.OrderStateConfigs.OrderEventEnum;
import com.souche.spring.statemachine.StateConfigs.OrderStateConfigs.OrderStateEnum;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

public abstract class AbstractAction implements Action<OrderStateEnum, OrderEventEnum> {

    @Override
    public void execute(StateContext<OrderStateEnum, OrderEventEnum> stateContext) {

    }
}
