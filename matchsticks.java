// Time Complexity : O(4^N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int peri = Arrays.stream(matchsticks).sum();
        if (peri % 4 != 0) {
            return false;
        }
        int side = peri / 4;
        for (int match : matchsticks) {
            if (match > side)
                return false;
        }
        int[] square = new int[4];
        matchsticks = Arrays.stream(matchsticks) // stream the array
                .boxed() // box to Integer
                .sorted(Collections.reverseOrder()) // sort descending
                .mapToInt(Integer::intValue) // unbox to int
                .toArray();

        return backtrack(matchsticks, square, 0, side);
    }

    private boolean backtrack(int[] matchsticks, int[] square, int idx, int side) {
        if (idx == matchsticks.length) {
            if (square[0] == square[1] && square[1] == square[2]
                    && square[2] == square[3] && square[3] == square[1]) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (square[i] + matchsticks[idx] <= side) {
                square[i] += matchsticks[idx];
                if (backtrack(matchsticks, square, idx + 1, side))
                    return true;
                square[i] -= matchsticks[idx];
            }
        }

        return false;
    }
}