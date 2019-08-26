package tech.wec.Facebook;

/*
Usually, solving and fully understanding a dynamic programming problem is a 4 step process:
1.Start with the recursive backtracking solution
2.Optimize by using a memoization table (top-down dynamic programming)
3.Remove the need for recursion (bottom-up dynamic programming)
4.Apply final tricks to reduce the time / memory complexity
 */
public class JumpGame_55 {

    // Backtracking
    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    private boolean canJumpFromPosition(int position, int[] nums){
        if (position == nums.length - 1){
            return true;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        //for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++)
        for (int nextPosition = furthestJump; nextPosition > position; nextPosition--)
        {
            if (canJumpFromPosition(nextPosition, nums))
                return true;
        }
        return false;
    }

    // Dynamic Programming Top-down
    enum Index{
        GOOD, BAD, UNKNOWN
    }
    Index[] memo;
    public boolean canJumpFromPosition_1(int position, int[] nums){
        if (memo[position] != Index.UNKNOWN){
            return memo[position] == Index.GOOD;
        }
        int furtherJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1;nextPosition <= furtherJump; nextPosition++){
            if (canJumpFromPosition(nextPosition, nums)){
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }

    public boolean canJump_1(int[] nums){
        memo = new Index[nums.length];
        for (int i =0;i<memo.length;i++)
            memo[i] = Index.UNKNOWN;
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition_1(0, nums);
    }

    // Dynamic Programming Bottom-up
    public boolean canJump_2(int[] nums){
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++)
            memo[i] = Index.UNKNOWN;
        memo[memo.length - 1] = Index.GOOD;
        for (int i = nums.length - 2; i >= 0; i--){
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++){
                if (memo[j] == Index.GOOD){
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }

    // Greedy
    public boolean canJump_3(int[] nums){
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1;i>=0;i--){
            if (i + nums[i] >= lastPos)
                lastPos = i;
        }
        return lastPos == 0;
    }
}
