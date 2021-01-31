package org.bees.box;

import com.alibaba.fastjson.JSONObject;
import org.bees.box.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> integerArrayList = new ArrayList<Integer>();

        List<Student> studentList = foreachAdd(10, x -> new Student(x));
        foreachPrint(studentList, x -> System.out.println(JSONObject.toJSONString(x)));

        long count =
                studentList.stream().skip(2).limit(4).peek(x -> System.out.println(JSONObject.toJSONString(x))).map(Student::getAge).count();

        System.out.println(count);

        long count1 =
                studentList.stream().skip(2).limit(4).peek(x -> System.out.println(JSONObject.toJSONString(x))).map(Student::getAge).flatMapToInt(x -> Arrays.stream(new int[]{x})).distinct().count();

        System.out.println(count1);


        int[] intArray = {1, 2, 3, 4 ,6, 6};

        //1. Stream<int[]>
        Stream<int[]> streamArray = Stream.of(intArray);

        //2. Stream<int[]> -> flatMap -> IntStream
        IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x)).distinct();

        intStream.forEach(x -> System.out.println(x));
        ;
    }

    private static <R> List<R> foreachAdd(int num, Function<Integer, R> trFunction) {
        List<R> integerList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            integerList.add(trFunction.apply(i));
            integerList.add(trFunction.apply(i));
        }
        return integerList;
    }

    private static <T> void foreachPrint(T inputList, Consumer<T> consumer) {
        consumer.accept(inputList);
    }
}
