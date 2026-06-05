class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutives = 0;
        int consecutivesCounter = 0;
        int prev = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 1) {
                consecutivesCounter++;
                if (consecutivesCounter > maxConsecutives) {
                    maxConsecutives = consecutivesCounter;
                }

                prev = nums[index];
            } else {
                consecutivesCounter = 0;
            }
        }
        return maxConsecutives;
    }
}