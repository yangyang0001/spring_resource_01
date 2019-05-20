package com.inspur.resource_07_delegate;

/**
 * User: YANG
 * Date: 2019/5/20-21:43
 * Description: No Description
 * Boss委派给  ExecutorA 或   ExecutorB   来做事情!
 */
public class Boss implements ExecutorInterface{

    private ExecutorInterface executorInterface;

    public Boss(ExecutorInterface executorInterface) {
        this.executorInterface = executorInterface;
    }

    @Override
    public void doSomething() {
        executorInterface.doSomething();
    }
}
