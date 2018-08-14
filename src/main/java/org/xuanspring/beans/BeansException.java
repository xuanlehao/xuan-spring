package org.xuanspring.beans;

/**
 * @author Leo xuan
 * @date 2018/8/14
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg){
        super();
    }

    public BeansException(String msg,Throwable cause){
        super(msg,cause);
    }
}
