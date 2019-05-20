package com.inspur.resource_02_cglib;

/**
 * User: YANG
 * Date: 2019/5/20-13:23
 * Description: No Description
 */
public class TestFindLove {
    public static void main(String[] args){
        MyMeiPo myMeiPo = new MyMeiPo(new YangYang());
        YangYang yang = (YangYang) myMeiPo.getInstance();
        yang.findLove();
    }
}
