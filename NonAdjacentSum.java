
public class NonAdjacentSum {
    public static void main(String[] args) {

    }
    public static boolean canSelectGroup(int start, int[] nums, int target) {
        // if the target is 0 then valid group is founded
        if (target==0){
            return true;
        }
        // if reach the last element in the array
        if (start>=nums.length){
            return false;
        }
        boolean include = false;

        // check the number is not exceed target
        if(nums[start] <=target){
            //skip the adjacent number to check the next number
            include= canSelectGroup(start+2, nums ,target-nums[start]);


        }




   }
}