package org.bees.box;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;

public class FunctionTest {

    public static void main(String[] args) {
        IntBinaryOperator sum = (x, y) -> x + y;

        int i = sum.applyAsInt(1, 2);

        System.out.println(JSONObject.toJSONString(i));

        List<String> strings = Arrays.asList("1", "2", "3");
        strings.forEach(System.out::println);


        Consumer<List<String>> consumer = System.out::println;
        consumer.accept(strings);


    }
}
