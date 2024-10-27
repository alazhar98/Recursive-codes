public class ArraySplitter {
    public static void main(String[] args ){

    }
    public static boolean split53(int[] nums){
        int totalSum = 0;
        // calculate the sum of nums in array
        for (int num : nums){
            totalSum+=num;
        }
        // check if total sum is odd we can not split it evenly
        if (totalSum%2!=0){
            return false;
        }
    }
}
