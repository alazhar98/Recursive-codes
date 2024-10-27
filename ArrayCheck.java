public class ArrayCheck {
    public static void main(String[] args){

        System.out.println(array220(new int[]{1, 2, 20}, 0));
        System.out.println(array220(new int[]{3, 30}, 0));
        System.out.println(array220(new int[]{3}, 0));


    }
    /*
    first check if if the array has fewer than 2 elements remaining from the current index return false
    check if the element at the current index is followed by that element multiplied by 10 at the next index return true
    If not found, move to the next index by calling
     */
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
