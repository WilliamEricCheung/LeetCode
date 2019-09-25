package tech.wec.Google;

public class AndroidUnlockPatterns_351 {

    private boolean used[] = new boolean[9];

    public int numberOfPatterns(int m, int n) {
        int res = 0;
        for (int len = m; len <= n; len++){
            res += calcPattern(-1, len);
            for (int i = 0;i < 9; i++)
                used[i] = false;
        }
        return res;
    }

    private boolean isValid(int index, int last){
        if (used[index])
            return false;
        // first digit of the pattern
        if (last == -1)
            return true;
        // knight move or adjacent cells
        if ((index + last) % 2 == 1)
            return true;
        // indexes are at both end of the diagonals for example 0,0 and 8,8
        int mid = (index + last)/2;
        if (mid == 4) // mid is 5
            return used[mid];
        // adjacent cells on diagonal
        if ((index % 3 != last%3) && (index / 3 != last / 3))
            return true;
        // all other cells which are not adjacent
        return used[mid];
    }

    private int calcPattern(int last, int len){
        if (len == 0)
            return 1;
        int sum = 0;
        for (int i = 0; i < 9; i++){
            if (isValid(i, last)){
                used[i] = true;
                sum += calcPattern(i, len - 1);
                used[i] = false;
            }
        }
        return sum;
    }
}
