package top100;

public class P_35 {
    public static void main(String[] args) {

        int[]nums={1,3,5,6};
        int target =7;
        System.out.println(findIndex(nums,target));

    }

    public static int findIndex(int[]nums,int target){
        if(nums.length==1){
            return target>nums[0]?1:0;
        }
        int rightIndex=nums.length-1;
        int leftIndex=0;
        if(nums[leftIndex]>=target){
            return leftIndex;
        }
        if(nums[rightIndex]<target){
            return rightIndex+1;
        }
        while (rightIndex-leftIndex>1){
            int middleIndex=(rightIndex+leftIndex)/2;
            int middleValue=nums[middleIndex];
            if(target==middleValue){
                return middleIndex;
            }
            if(target>middleValue){
                leftIndex=middleIndex;
            }else {
                rightIndex=middleIndex;
            }
        }
        return nums[leftIndex]<target?rightIndex:leftIndex;


    }

}
