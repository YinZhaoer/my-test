package leetcode;

/**
 * @author: ZhaoYin
 * @version: 2019/11/21
 * @description: 75颜色分类，使用多指针记录,还需要再理解一下
 */
public class SortColors {
    public static void main(String[] args) {
        int [] nums={2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(nums.toString());

    }

    public static void sortColors(int[] nums) {
        int i=0;
        int cur=0;
        int j=nums.length-1;
        while (cur<=j){
            int num=nums[cur];
            if(num==0){
                int temp=nums[i];
                nums[i]=num;
                nums[cur]=temp;
                i++;
                cur++;
            }
            else if(num==2){
                //此时cur不加，很关键
                int temp=nums[j];
                nums[j]=num;
                nums[cur]=temp;
                j--;
            }else {
                cur++;
            }
        }

        }

}
