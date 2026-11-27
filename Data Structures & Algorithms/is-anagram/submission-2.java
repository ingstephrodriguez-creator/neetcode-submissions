class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> chars = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            chars.computeIfPresent(c, (k, v) -> v+1);
            chars.computeIfAbsent(c, k -> 1);
        }

        for(int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            if(chars.containsKey(c)){
                chars.put(c, chars.get(c) -1);
                if(chars.get(c) <= 0) 
                    chars.remove(c);
            } else {
                return false;
            }
        }

        return chars.isEmpty();
    }
}
