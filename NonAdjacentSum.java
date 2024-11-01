
public class NonAdjacentSum {
    public static void main(String[] args) {

        int[] nums = {2, 5, 10, 4};
        System.out.println(canSelectGroup(0, nums, 12));
        System.out.println(canSelectGroup(0, nums, 14));
        System.out.println(canSelectGroup(0, nums, 7));

    }
    public static boolean canSelectGroup(int start, int[] nums, int target) {
        // if the target is 0 then valid group is founded
        if (target==0){
            return true;
        }
        // if sum has exceeded the target
        // if reach the last element in the array
        if (target < 0 || start >= nums.length) {
            return false;
        }

        // include current number + skip the next number
        boolean withCurrent = canSelectGroup(start+2 , nums , target - nums[start]);

        // Skip current number
        boolean withoutCurrent = canSelectGroup(start+1 , nums , target);

        return withCurrent || withoutCurrent;

   }
}