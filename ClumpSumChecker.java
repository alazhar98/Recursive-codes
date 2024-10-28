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
    }
}
