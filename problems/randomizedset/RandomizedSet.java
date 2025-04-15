package randomizedset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

	// List to store the elements for O(1) access and random retrieval
		private List<Integer> list;

		// Map to store the index of each element in the list for O(1) insert/remove
		private Map<Integer, Integer> map;

		// Constructor to initialize the list and map
		public RandomizedSet() {
			list = new ArrayList<Integer>();
			map = new HashMap<Integer, Integer>();
		}

		/**
		 * Inserts a value to the set if not already present.
		 * @param val the value to insert
		 * @return true if the value was inserted, false if it was already present
		 */
		public boolean insert(int val) {
			// If already present, do not insert
			if (map.containsKey(val)) {
				return false;
			}

			// Add value to the list and store its index in the map
			map.put(val, list.size());
			list.add(val);
			return true;
		}

		/**
		 * Removes a value from the set if present.
		 * @param val the value to remove
		 * @return true if the value was removed, false if it was not found
		 */
		public boolean remove(int val) {
			// If value is not present, nothing to remove
			if (!map.containsKey(val)) {
				return false;
			}

			// Get index of element to be removed
			int index = map.get(val);

			// Get the last element in the list
			int lastElement = list.get(list.size() - 1);

			// Overwrite the index of the removed element with the last element
			list.set(index, lastElement);

			// Update the map with new index for the last element
			map.put(lastElement, index);

			// Remove the last element from the list
			list.remove(list.size() - 1);

			// Remove the value from the map
			map.remove(val);

			return true;
		}

		/**
		 * Returns a random element from the set.
		 * Assumes that the set contains at least one element.
		 * @return a randomly selected element
		 */
		public int getRandom() {
			Random rand = new Random();
			// Generate a random index and return the element at that index
			return list.get(rand.nextInt(list.size()));
		}

}
