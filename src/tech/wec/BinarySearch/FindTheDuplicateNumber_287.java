package tech.wec.BinarySearch;

public class FindTheDuplicateNumber_287 {

    // Floyd's Tortoise and Hare
    // 快慢双指针
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);

        int ptr1 = nums[0];
        int ptr2 = slow;
        while(ptr1 != ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}
