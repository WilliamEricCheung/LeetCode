package tech.wec.Facebook;

public class SquaresOfASortedArray_977 {

    // very much like merge two sorted linked list
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int index = nums.length - 1;
        int[] result = new int[nums.length];
        while(left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare =  nums[right]*nums[right];
            if(leftSquare > rightSquare) {
                result[index--] = leftSquare;
                left++;
            }else{
                result[index--] = rightSquare;
                right--;
            }
        }
        return result;
    }
}
