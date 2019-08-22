package leetcode.bishi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author: ZhaoYin
 * Date: 2019/8/3
 * Time: 16:18
 * Created with IntelliJ IDEA
 * Description:
 */
public class Netease1 {
    static  DecimalFormat df = new DecimalFormat("0.000000");

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalNum = scan.nextInt();
        scan.nextLine();
        ArrayList<Integer> grades = new ArrayList<Integer>();
        ArrayList<Integer> index = new ArrayList<Integer>();
        String inputString = scan.nextLine();
        String[] inputStrings = inputString.split(" ");
        for (String s : inputStrings) {
            grades.add(Integer.parseInt(s));
        }
        int indexNum = scan.nextInt();
        while (index.size() < indexNum) {
            index.add(scan.nextInt());
        }
        for(int i:index){
            System.out.println(calPercent(totalNum,grades.get(i-1),grades));
        }


    }


    public static double calPercent(int totalNum, int grade, ArrayList<Integer> grades) {
        double res = 0;
        double underNum = calUnderGradeNum(grade, grades);
        if(underNum==1){
            return 0.000000;
        }
        res = Double.parseDouble(df.format(((underNum - 1) / totalNum * 100)));
        return res;
    }

    public static double calUnderGradeNum(int grade, ArrayList<Integer> grades) {
        double count = 0.000000;
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) <= grade)
                count++;
        }
        return count;
    }

}
