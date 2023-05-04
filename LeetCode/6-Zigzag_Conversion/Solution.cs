Solution sol = new Solution();
Console.WriteLine(sol.Convert("PAYPALISHIRING", 3));
public class Solution {
    public string Convert(string s, int numRows) {
        int stringSize = s.Length;

        // Get a List of chars for each row
        List<List<char>> strings = new List<List<char>>();
        for (int rowN = 0; rowN < numRows; rowN++) {
            strings.Add(new List<char>());
        }
        // Index of the original string
        int i = 0;

        while (i < stringSize) {
            // Moving vertically - notice that the column might not be complete: therefore the i < stringSize
            for (int rowIndex = 0; rowIndex < numRows && i < stringSize; rowIndex++) {
                strings[rowIndex].Add(s[i++]);
            }
            // Move up diagonally - notice that the diagonal might not be complete: therefore the i < stringSize
            for (int rowIndex = numRows - 2; rowIndex > 0 && i < stringSize; rowIndex--) {
                strings[rowIndex].Add(s[i++]);
            }
        }

        string output = "";
        foreach (List<char> row in strings) {
            foreach (char letter in row) {
                output += letter;
            }
        }
        return output;
    }
}