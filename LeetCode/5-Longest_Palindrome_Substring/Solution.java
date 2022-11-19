/*
 * Time complexity: O(n^2) - This solution could be optimized.
 */

public class Solution {
    public static String longestPalindrome(String s) {
        String largestOddPalindrome = "";
        String largestEvenPalindrome = "";
        
        largestOddPalindrome = testOddPalindromes(s, false); // test largest palindrome for odd sized palindromes
        largestEvenPalindrome = testOddPalindromes(s, true); // test largest palindrome for odd sized palindromes
        

        return (largestEvenPalindrome.length() > largestOddPalindrome.length()) ? largestEvenPalindrome : largestOddPalindrome;
    }

    private static String testOddPalindromes(String s, boolean flag) {
        String largestPalindrome = "";
        
        for(int index = 0; index < s.length(); index++) {
            int leftIndex = index;
            int rightIndex = flag ? index + 1 : index;
            String palindrome = "";

            while(leftIndex > -1 && rightIndex < s.length()) {
                if(s.charAt(leftIndex) == s.charAt(rightIndex)) {
                    // The characters match
                    if(leftIndex == rightIndex) {
                        palindrome += s.charAt(rightIndex);
                    } else { 
                        palindrome = s.charAt(rightIndex) + palindrome + s.charAt(rightIndex);
                    }

                    leftIndex--;
                    rightIndex++;                        
                } else {
                    // The characters do not match, check if this is the largest palindrome we have seen
                    break;
                }
            }
            largestPalindrome = (largestPalindrome.length() > palindrome.length()) ? largestPalindrome : palindrome;
        }
        return largestPalindrome;
    }

    public static void main(String[] args) {
        String test1 = "aba";
        System.out.println(longestPalindrome(test1)); 

        String test2 = "aa";
        System.out.println(longestPalindrome(test2)); 

        String test3 = "ab";
        System.out.println(longestPalindrome(test3));

        String test4 = "abcbdddddcba";
        System.out.println(longestPalindrome(test4));

        String test5 = "aacabdkacaa";
        System.out.println(longestPalindrome(test5));

    }
}
