public class SumGroupChecker {
    public static void main(String[] args){

    }
    public static boolean groupSum5(int start, int[] nums, int target) {
        //if reach the end of the array
        if(start>= nums.length){
            return target == 0;
        }
        int current = nums[start];
        // if current number is multiple if 5
        if (current%5==0){
            if(start+1 <nums.length && nums[start+1]==1){
                return groupSum5(start + 2, nums, target - current);

            }
        }
    }
}
