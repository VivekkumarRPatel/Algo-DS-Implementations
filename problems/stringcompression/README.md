# String Compression

Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

- If the group's length is 1, append the character to s.
- Otherwise, append the character followed by the group's length.

The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.



🧠 Approach (Two Pointer Technique)

We use two pointers:

- read pointer → This keeps track of which character we are currently reading from the input array.

- write pointer → This keeps track of the current position in the array where we should write the compressed result.



💡 Idea Behind the Solution

- Start reading characters one by one.

- Count how many times the current character repeats consecutively.

- Write that character once at the write position.

- If its count is more than 1, convert that number into characters (e.g., 12 → '1', '2') and write each digit one by one.

- Move both read and write pointers accordingly.

- In the end, write will be pointing at the index after the last written character, which is the length of the compressed array.



🧩 Trickiest Part
The trickiest part is:

- Handling multi-digit counts (like 12) by converting the number into characters and writing each digit separately into the array.

- Ensuring we don’t use extra space (no new arrays) and do all operations in-place.

	for(char ch : String.valueOf(count).toCharArray()) {
    		chars[write++] = ch;
	}

- It ensures that even counts like 100 are split and written as '1','0','0'.


📘 What I Learned
- How to use two pointers effectively for in-place array manipulation.

- How to convert an integer into characters and loop through them.

- Importance of handling edge cases (like when a character appears only once).

- The value of clear, clean logic for maintaining separate read/write positions.

