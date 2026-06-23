class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]] = count[nums[i]] + 1;
        }
        
        int index =0;
        for(int element = 0; element < count.length; element ++){
            int times = count[element];
            for(int i = 0; i<times; i++){
                nums[index] = element;
                index++;
            }

        }
    }
}