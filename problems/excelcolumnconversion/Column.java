package excelcolumnconversion;

public class Column {

    // This method converts Excel column title (like "AB") to its corresponding column number (like 28)
    public static int convertToColumnNumber(String columnTitle) {

        char ch[] = columnTitle.toCharArray();
        int result = 0;

        // Loop through each character in the string
        for (int index = 0; index < ch.length; index++) {

            // Convert the character to its corresponding value:
            // 'A' -> 1, 'B' -> 2, ..., 'Z' -> 26
            int corresIntValue = ch[index] - 'A' + 1;

            // Multiply the result by 26 (like base-26 number system)
            // and add the current character's value
            result = result * 26 + corresIntValue;
        }

        return result;
    }

    // This method converts a column number (like 28) back to its Excel title (like "AB")
    public static String convertToColumnTitle(int columnNumber) {

        StringBuilder string = new StringBuilder();

        // Repeat until we've processed the whole number
        while (columnNumber > 0) {
            columnNumber--; // Shift to 0-based indexing (so A starts from 0)
            
            // Get the remainder to find the rightmost character
            int reminder = columnNumber % 26;

            // Convert the remainder to the corresponding character
            char ch = (char) ('A' + reminder);

            // Append the character to the result
            string.append(String.valueOf(ch));

            // Move to the next digit in base-26
            columnNumber /= 26;
        }

        // Since we built the string from the end, we reverse it before returning
        return string.reverse().toString();
    }

}
