package com.inspur.resource_08_stratege;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * User: YANG
 * Date: 2019/5/20-22:33
 * Description: No Description
 */
public class MyListTest {
    public static void main(String[] args){
        List<Long> longList = Arrays.asList(10L, 5L, 8L, 11L, 100L, 0L);
        longList.sort(Comparator.comparingLong(Long::new));
        longList.stream().forEach(System.out::println);
    }
}
