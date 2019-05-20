package com.inspur.resource_07_delegate;

/**
 * User: YANG
 * Date: 2019/5/20-21:39
 * Description: No Description
 */
public class ExecutorA implements ExecutorInterface {
    @Override
    public void doSomething() {
        System.out.println("员工A开始做事...");
    }
}
