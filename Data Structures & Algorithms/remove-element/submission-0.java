class Solution {
    public int removeElement(int[] nums, int val) {
        int lastValidIndex =0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != val) {
                nums[lastValidIndex]= nums[index];
                lastValidIndex++; 
            }
        }
        return lastValidIndex;
    }
}