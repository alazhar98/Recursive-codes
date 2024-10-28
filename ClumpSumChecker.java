public class ClumpSumChecker {
    public static void main(String[] args ){

        System.out.println(groupSumClump(0, new int[]{2, 4, 8}, 10));
        System.out.println(groupSumClump(0, new int[]{1, 2, 4, 8, 1}, 14));
        System.out.println(groupSumClump(0, new int[]{2, 4, 4, 8}, 14));
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
        // if no valid group found the return false
        return false;
    }
}
