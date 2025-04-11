// Time Complexity : O(N*5^(N))
// Space Complexity : constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int[] digits = {0, 1, 6, 8, 9};
    Map<Integer, Integer> map = Map.of(0, 0, 1, 1, 6, 9, 8, 8, 9, 6);
    int res = 0;
    
    public int confusingNumberII(int n) {
        dfs(0, n);
        return res;
    }

    private void dfs(long curr, int n) {
        if (curr > n) return;

        if (isConfusing(curr)) res++;

        for (int i=0;i<digits.length;i++) {
            long next = curr * 10 + digits[i];
            if (next == 0) continue; 
            dfs(next, n);
        }
    }

    private boolean isConfusing(long num) {
        long original = num;
        long rotated = 0;
        while (num > 0) {
            int d = (int)(num % 10);
            rotated = rotated * 10 + map.get(d);
            num /= 10;
        }
        return rotated != original;
    }
}
