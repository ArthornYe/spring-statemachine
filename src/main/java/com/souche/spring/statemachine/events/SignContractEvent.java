package com.souche.spring.statemachine.events;

import lombok.Data;

/**
 * @autor yeqiaozhu.
 * @date 2019-05-29
 */
@Data
public class SignContractEvent extends CommonEvent {
    //验证码
    private String depta;
}
