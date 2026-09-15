package core_java_and_oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Question: Practice core ArrayList operations: adding, retrieving, updating,
 * removing, verifying elements, sorting, and iterating.
 */
public class ArrayListOperations {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("          ARRAYLIST CORE OPERATIONS DEMO         ");
        System.out.println("=================================================");

        // 1. Creation and Adding Elements
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Mango");
        // Insert at specific index
        fruits.add(1, "Blueberry");
        System.out.println("1. Initial ArrayList: " + fruits);

        // 2. Retrieving Elements (get)
        String firstFruit = fruits.get(0);
        String thirdFruit = fruits.get(2);
        System.out.println("\n2. Retrieval:");
        System.out.println("   Element at index 0: " + firstFruit);
        System.out.println("   Element at index 2: " + thirdFruit);

        // 3. Updating Elements (set)
        fruits.set(2, "Blackberry");
        System.out.println("\n3. After updating index 2 to 'Blackberry': " + fruits);

        // 4. Verifying Elements (contains, indexOf, isEmpty, size)
        System.out.println("\n4. Verification:");
        System.out.println("   Contains 'Mango'? " + fruits.contains("Mango"));
        System.out.println("   Contains 'Orange'? " + fruits.contains("Orange"));
        System.out.println("   Index of 'Banana': " + fruits.indexOf("Banana"));
        System.out.println("   Is list empty? " + fruits.isEmpty());
        System.out.println("   Current Size: " + fruits.size());

        // 5. Removing Elements (by index & by object)
        fruits.remove(1); // removes element at index 1 ("Blueberry")
        fruits.remove("Mango"); // removes object "Mango"
        System.out.println("\n5. After removing index 1 and object 'Mango': " + fruits);

        // 6. Sorting
        Collections.sort(fruits);
        System.out.println("\n6. After alphabetical sort: " + fruits);

        // 7. Iteration methods
        System.out.println("\n7. Iterating through ArrayList:");
        System.out.print("   Using Enhanced For-Loop: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        System.out.print("   Using Iterator: ");
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 8. Clearing the list
        fruits.clear();
        System.out.println("\n8. After clear(): " + fruits + ", Is Empty? " + fruits.isEmpty());
    }
}
