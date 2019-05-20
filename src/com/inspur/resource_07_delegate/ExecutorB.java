package com.inspur.resource_07_delegate;

/**
 * User: YANG
 * Date: 2019/5/20-21:40
 * Description: No Description
 */
public class ExecutorB implements ExecutorInterface {
    @Override
    public void doSomething() {
        System.out.println("员工B开始做事...");
    }
}
