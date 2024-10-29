
public class NonAdjacentSum {
    public static void main(String[] args) {

    }
    public static boolean canSelectGroup(int start, int[] nums, int target) {
        // if the target is 0 then valid group is founded
        if (target==0){
            return true;
        }
        // if sum has exceed the target
        if (target<0){
            return false;
        }
        // if reach the last element in the array
        if (start>=nums.length){
            return false;
        }
        // include current number + skip the next number
        boolean includeCurrent = canSelectGroup(start+2 , nums , target-nums[start]);

        // Skip current number
        boolean skipCurrent = canSelectGroup(start+1,nums , target);

        return



   }
}