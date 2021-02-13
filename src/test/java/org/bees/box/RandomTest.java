package org.bees.box;

import com.alibaba.fastjson.JSONObject;
import org.bees.box.entity.Student;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class RandomTest {
    //是ParameterizedType
    private HashMap<String, Object> map;
    private HashSet<String> set;
    private List<String> list;
    private Class<?> clz;

    //不是ParameterizedType
    private Integer i;
    private String str;


    public static void main(String[] args) {

        Field[] declaredField = RandomTest.class.getDeclaredFields();
        System.out.println(JSONObject.toJSONString(declaredField));

        for (Field f : declaredField){
            //打印是否是ParameterizedType类型
            System.out.println("FieldName:  " + f.getName() + " instanceof ParameterizedType is : " +
                    (f.getGenericType() instanceof ParameterizedType));
        }

        List<Student> studentList = new ArrayList<>();

        System.out.println("1");
    }

}
