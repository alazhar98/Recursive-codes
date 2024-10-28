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
            // if next number is 1 skip the number
            if(start+1 <nums.length && nums[start+1]==1){
                return groupSum5(start + 2, nums, target - current);

            }
            // if the number is multiple of 5 and not 1
            else {
                groupSum5(start+1,nums,target-current);
            }
        }
        boolean include = groupSum5(start+1 ,nums,target-current);
        boolean exclude = groupSum5(start+1,nums , target);

        return include || exclude;
    }

}
