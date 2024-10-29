public class EqualSumPartition {

    public static void main(String[] args){


        System.out.println(splitArray(new int[]{2, 2}));
        System.out.println(splitArray(new int[]{2, 3}));
        System.out.println(splitArray(new int[]{7,3,2,2}));


    }
    public static boolean splitArray(int[] nums) {
        int sum =0;

        // calculate the sum
        for (int num : nums){
            sum=sum+num;
        }
        // if sum is odd then we can not split them
        if(sum%2 != 0){
            return false;
        }
        // calculate target
        int target = sum/2;

        return splitHelper(nums,0,target);

    }

    private static boolean splitHelper(int[] nums, int index, int target) {

        // if target is equal to zero then we found split
        if (target==0){
            return true;
        }
        // if the index is more than the length
        if (index >= nums.length){
            return false;
        }
        // if the target is negative then we exceed the sum because target = sum/2
        if (target<0){
            return false;
        }
        //include the current number to the group
        if (splitHelper(nums, index + 1, target - nums[index])) {
            return true;
        }

        return splitHelper(nums, index + 1, target);
    }

}

