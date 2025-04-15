package multithreading;

public class RandomizedSetDemo {
	
	public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();

        // Insert elements
        System.out.println("Insert 10: " + randomizedSet.insert(10)); // true
        System.out.println("Insert 20: " + randomizedSet.insert(20)); // true
        System.out.println("Insert 10 again: " + randomizedSet.insert(10)); // false

        // Remove elements
        System.out.println("Remove 10: " + randomizedSet.remove(10)); // true
        System.out.println("Remove 30 (not present): " + randomizedSet.remove(30)); // false

        // Insert more elements
        System.out.println("Insert 30: " + randomizedSet.insert(30)); // true
        System.out.println("Insert 40: " + randomizedSet.insert(40)); // true

        // Get random elements
        System.out.println("Random Element: " + randomizedSet.getRandom());
        System.out.println("Random Element: " + randomizedSet.getRandom());
    }
}
