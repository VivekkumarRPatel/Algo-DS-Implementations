package stringcompression;

public class StringCompression {

	public static int compress(char[] chars) {

		int read = 0;   // Pointer to read characters from the input
		int write = 0;  // Pointer to write compressed characters into the array

		// Loop through the array until all characters are read
		while (read < chars.length) {

			char currentChar = chars[read]; // Store the current character being read
			int count = 0; // Counter to count how many times currentChar appears consecutively

			// Count how many times the current character repeats in a row
			while (read < chars.length && currentChar == chars[read]) {
				read++;
				count++;
			}

			// Write the character to the current write position
			chars[write++] = currentChar;

			// If the character appears more than once, write its count
			if (count > 1) {
				// Convert the count to characters and write each digit one by one
				for (char ch : String.valueOf(count).toCharArray()) {
					chars[write++] = ch;
				}
			}
		}

		// Return the new length of the compressed array
		return write;
	}

	public static void main(String[] args) {

		// Example usage: compress the string "ABBCCC"
		System.out.println(compress("ABBCCC".toCharArray())); // Output should be 6
	}

}
