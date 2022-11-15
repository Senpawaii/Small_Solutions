import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        int max = 0;
        int tmp_counter = 0;
        
        for(int index_i = 0, index_j = 0; index_j < s.length(); index_j ++){
            char c_1 = s.charAt(index_i);
            char c_2 = s.charAt(index_j);
            if(!hash.containsKey(c_2)) {
                tmp_counter++;
            } else {
                max = max > tmp_counter ? max : tmp_counter;
                index_i = index_i > hash.get(c_2) ? index_i : hash.get(c_2) + 1;
                tmp_counter = index_j - index_i + 1;
            }
            hash.put(c_2, index_j);
        }
        max = max > tmp_counter ? max : tmp_counter;
        return max;
    }
}