# Randomize Set Implementation

🔁 RandomizedSet
🧩 Problem Statement
Design a data structure that supports the following operations in average O(1) time:

RandomizedSet() – Initializes the data structure.

insert(val) – Inserts val if it’s not already present. Returns true if inserted, false otherwise.

remove(val) – Removes val if it’s present. Returns true if removed, false otherwise.

getRandom() – Returns a random element from the set. Each element should have an equal probability of being chosen.

⚠️ It’s guaranteed that getRandom() is only called when there is at least one element in the set.

💡 **Approach**
The challenge here is that we want all operations to be O(1) — especially getRandom() and remove(), which are usually more expensive in most data structures.

So what do we need?

✅ Fast Lookup
To check if a value exists and to get its position quickly → use a HashMap.

✅ Fast Random Access
To pick a random value in constant time → use a List (ArrayList).

**So the idea is:**

Use a List to store values (so we can get by index).

Use a Map to store the index of each value in the list.

For insert, add to list and update the map.

For remove, swap the target value with the last value in the list, update the map, and then remove the last element from the list. This avoids shifting elements.

For getRandom, just generate a random index and return the element at that index in the list.

🤯 **Trickiest Part**
The trickiest part of this problem is:

Removing an element in O(1)
Normally, removing an element from the middle of a list takes O(n) because of shifting. But here, we swap the target with the last element and then remove it — this keeps it O(1).

Returning a truly random element
Since ArrayList supports access by index in O(1), we can generate a random index and return the value at that index — ensuring equal probability for each element.

📚 **What I Learned**

How to combine two data structures (HashMap + ArrayList) to leverage the strengths of both.

The importance of designing around time complexity.

Swapping techniques to maintain O(1) deletions from a list.
