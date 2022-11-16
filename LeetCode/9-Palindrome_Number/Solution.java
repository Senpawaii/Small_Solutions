class Solution {
    public boolean isPalindrome(int x) {
        /* Version 1 - Intuitive but slow and costly in memory
        
        if(x < 0) return false;
        
        ArrayList<Integer> full_number = new ArrayList<Integer>();
        while(x >= 1) {
            full_number.add(x%10);
            x/=10;
        }
        for(int index_x = 0, index_y = full_number.size() -1; index_x <= index_y; index_x++, index_y--) {
            if(full_number.get(index_x) != full_number.get(index_y)) {
                return false;
            }
        }
        return true;
        */
        
        /* Version 2 - Faster and less expensive */
        /*  Logic:  Reverse half of the number. 
                    2 possible scenarios. Either:
                        - The numbers are equal
                        - The initial number is odd so one of the sides 1 more digit
        */

        
        if(x < 0) return false;             // negative numbers cannot be palindromes
        if(x%10 == 0 && x!=0) return false; // Numbers that end in a 0 cannot be palindromes, unless it is 0 itself.
        
        int reversed = 0;
        while(x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed == x || reversed / 10 == x;
    }
}