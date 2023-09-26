package top100;

/**
 * 字符串相乘
 */
public class P_43 {

    public static void main(String[] args) {
        System.out.println(multiply("123","456"));
        System.out.println(add("120", "974"));
    }

    // 123  456
    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        String res="";
        String index="";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int numA=num1.charAt(i)-'0';
            String index2="";
            for (int j = num2.length() - 1; j >= 0; j--) {
                int numB=num2.charAt(j)-'0';
                String subRes=numB*numA+index+index2;
                res=add(subRes,res);
                index2=index2+"0";
            }
            index=index+"0";
        }
        return res;
    }


    public static String add(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        if (lengthB > lengthA) {
            for (int i = 0; i < lengthB - lengthA; i++) {
                a = "0" + a;
            }

        }
        if (lengthA > lengthB) {
            for (int i = 0; i < lengthA - lengthB; i++) {
                b = "0" + b;
            }
        }
        StringBuilder res = new StringBuilder();
        int tmp = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int aNum = a.charAt(i) - '0';
            int bNum = b.charAt(i) - '0';
            int subSum = (aNum + bNum + tmp) % 10;
            tmp = (aNum + bNum + tmp) / 10;
            res.insert(0, subSum);
        }
        if (tmp != 0) {
            res.insert(0, tmp);
        }
        return res.toString();
    }

}
