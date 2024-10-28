public class EqualSumPartition {
    public static void main(String[] args){

    }
    public static boolean splitArray(int[] nums) {
        int sum =0;

        // calculate the sum
        for (int num : nums){
            sum=sum+num;
        }
        // if sum is odd then we can no split them
        if(sum%2 != 0){
            return false;
        }
    }
    private static boolean splitHelper(int[] nums, int index, int target) {

    }
}
