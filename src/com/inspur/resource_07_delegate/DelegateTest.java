package com.inspur.resource_07_delegate;

/**
 * User: YANG
 * Date: 2019/5/20-22:02
 * Description: No Description
 */
public class DelegateTest {
    public static void main(String[] args){
        Boss boss = new Boss(new ExecutorA());
        boss.doSomething();
    }
}
