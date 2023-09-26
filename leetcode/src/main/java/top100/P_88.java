package top100;

/**
 * 合并有序数组
 */
public class P_88 {
    public static void main(String[] args) {
        int [] num1={2,5,6,0,0,0};
        int [] num2={1,2,3};
        int m=3;
        int n=3;
        merge(num1,m,num2,n);
        System.out.println(num1);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1Index=m-1;
        int num2Index=n-1;
        int tail=m+n-1;
        int cur;
        while (num2Index>-1||num1Index>-1){
            if(num1Index==-1){
                //说明1已经走完了
                cur=nums2[num2Index];
                num2Index--;
            }
           else if(num2Index==-1){
                //说明2已经走完了
                cur=nums1[num1Index];
                num1Index--;
            }else {
                int num1Value=nums1[num1Index];
                int num2Value=nums2[num2Index];
                if(num2Value>=num1Value){
                    cur=num2Value;
                    num2Index--;
                }else {
                    cur=num1Value;
                    num1Index--;
                }
            }
            nums1[tail]=cur;
            tail--;

        }


    }


}
