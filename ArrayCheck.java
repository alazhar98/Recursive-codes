public class ArrayCheck {
    public static void main(String[] args){

        System.out.println(array220(new int[]{1, 2, 20}, 0));
        System.out.println(array220(new int[]{3, 30}, 0));
        System.out.println(array220(new int[]{3}, 0));


    }
    public static boolean array220(int[] nums, int index) {
        if(index>=nums.length-1){
            return false;
        }
        if (nums[index] *10==nums[index +1]){
            return true;
        }
        return array220(nums,index+1);
    }
}
