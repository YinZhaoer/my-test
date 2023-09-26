package top100;

/**
 * 子序列
 */
public class P_392 {

    public static void main(String[] args) {
        String t="";
        String s="";
        System.out.println(isSubsequence(s,t));


    }

    public static boolean isSubsequence(String s, String t) {
        int sIndex=0;
        int tIndex=0;
        if(t.equals(s)){
            return true;
        }
        if(t.equals("")){
            return false;
        }
        if(s.equals("")){
            return true;
        }
        while (tIndex<t.length()){
            Character tCh=t.charAt(tIndex);
            Character sCh=s.charAt(sIndex);
            if(tCh.equals(sCh)){
                sIndex++;
            }
            if(sIndex==s.length()){
                return true;
            }
            tIndex++;
        }
        return false;
    }


}

