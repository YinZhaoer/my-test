package test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author zhaoyin
 * @Description TODO
 * @date 2019-06-24 11:36
 */
public class Test {

    public static void main(String[] args) {
        String s="  ";
        System.out.println(s.length());

    }
    public static String test(String s){
        if(s==null){
            return null;
        }
        try {
            System.out.println(s);
            return s;
        }catch (Exception e){
            System.out.println("eeeee");
        }
        return null;
    }

}


