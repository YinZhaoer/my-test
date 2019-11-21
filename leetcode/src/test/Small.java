package test;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Vector;

/**
 * Author: ZhaoYin
 * Date: 2019/8/3
 * Time: 17:04
 * Created with IntelliJ IDEA
 * Description:
 */
public class Small {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.println(df.format(0.00));
    }
}
