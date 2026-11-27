class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> index = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            int need = target - nums[i];
            if(index.containsKey(need))
                return new int[]{index.get(need), i};
            index.put(nums[i], i);
        }
        return new int[]{};
    }

    /*public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i< nums.length-1; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if((nums[i] + nums[j])==target) {
                    return new int[]{i,j};
                } 
            }
        }
        return null;
    }*/
}
