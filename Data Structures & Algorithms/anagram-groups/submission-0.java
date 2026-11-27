class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupOfAnagrams = new ArrayList<>();
        Map<String, Integer> mapOfAnagrams = new HashMap<>();
    
        for(int i = 0; i<strs.length; i++){
            
            String sorted = sortString(strs[i]);
            if(mapOfAnagrams.containsKey(sorted)) {
                groupOfAnagrams.get(mapOfAnagrams.get(sorted)).add(strs[i]);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(strs[i]);
                mapOfAnagrams.put(sortString(strs[i]), groupOfAnagrams.size());
                groupOfAnagrams.add(anagrams);
            }
            
        }
        return groupOfAnagrams;
    }

    public String sortString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
