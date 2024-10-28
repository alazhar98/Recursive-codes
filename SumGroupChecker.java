public class SumGroupChecker {
    public static void main(String[] args){

        System.out.println(groupSum5(0, new int[]{2, 5, 10, 4}, 19));
        System.out.println(groupSum5(0, new int[]{2, 5, 10, 4}, 17));
        System.out.println(groupSum5(0, new int[]{2, 5, 10, 4}, 12));
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
