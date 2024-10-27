public class ArraySplitter {
    public static void main(String[] args ){

    }
    public static boolean split53(int[] nums){
        int totalSum = 0;
        // calculate the sum of nums in array
        for (int num : nums){
            totalSum+=num;
        }
        // check if total sum is odd we can not split it evenly
        if (totalSum%2!=0){
            return false;
        }
        return canBeSplit(nums,0,totalSum/2,0,0);
    }
    private static boolean canBeSplit(int[] nums, int index, int targetSum, int group5Sum, int group3Sum) {
        // if reach the end of the array
        if (index==nums.length){
            return group5Sum==targetSum && group3Sum==targetSum;
        }
        int num = nums[index];

        //if the number is a multiple of 5 add to the group5Sum
        if (num % 5 == 0) {
            return canBeSplit(nums, index + 1, targetSum, group5Sum + num, group3Sum);
        }
        // If the number is a multiple of 3 but not 5 add it to the group3Sum
        else if (num % 3 == 0) {
            return canBeSplit(nums, index + 1, targetSum, group5Sum, group3Sum + num);

    }
}
