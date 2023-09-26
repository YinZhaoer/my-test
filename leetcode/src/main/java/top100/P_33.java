package top100;

/**
 * 搜索旋轉數組
 */
public class P_33 {


    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        int target=0;

    }

    public static int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int length=nums.length;
        int leftMin=nums[0];
        int rightMax=nums[nums.length-1];
        if(target<=rightMax){
            for(int i=nums.length-1;i>=0;i--){
                if(target==nums[i]){
                    return i;
                }
                if(i-1>=0&&nums[i-1]>nums[i]){
                    return -1;
                }
            }
        }
        for(int i=0;i<length;i++){
            if(target==nums[i]){
                return i;
            }
            if(i+1<length&&nums[i+1]<leftMin){
                return -1;
            }
        }
        return -1;
    }




}
