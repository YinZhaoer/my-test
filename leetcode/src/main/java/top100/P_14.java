package top100;

/**
 * 最長公共前綴
 */
public class P_14 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flower", "flower"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        StringBuilder res = new StringBuilder();
        if(strs[0].equals("")){
            return "";
        }
        Character ch = strs[0].charAt(0);
        int j = 0;
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < strs.length; i++) {
                if(strs[i].equals("")){
                    return "";
                }
                if (j == strs[i].length() - 1) {
                    flag = false;
                }
                if (!ch.equals(strs[i].charAt(j))) {
                    flag = false;
                    break;
                }
                if (i == strs.length - 1) {
                    res.append(ch);
                    j++;
                    if(j==strs[0].length()){
                        flag=false;
                    }else {
                        ch = strs[0].charAt(j);
                    }

                }
            }

        }
        return res.toString();
    }
}
