public class ClumpSumChecker {
    public static void main(String[] args ){

    }
    public static boolean groupSumClump(int start, int[] nums, int target) {
        // if reach the end of the array
        if (start>=nums.length){
            return target==0;
        }

        int current = nums[start];
        int sum =0;
        int count =0;

        // find the sum
        while (start+count< nums.length && nums[start+count]==current){
            sum = sum +nums[start+count];
            count++;
        }
        // include the clump in the sum
        if (groupSumClump(start + count, nums, target - sum)) {
            return true;
        }
        // exclude the clump from the sum
        if (groupSumClump(start + count, nums, target)) {
            return true;
        }
    }
}
