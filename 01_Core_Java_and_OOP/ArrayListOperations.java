package core_java_and_oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListOperations {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("          ARRAYLIST CORE OPERATIONS DEMO         ");
        System.out.println("=================================================");

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Mango");

        fruits.add(1, "Blueberry");
        System.out.println("1. Initial ArrayList: " + fruits);

        String firstFruit = fruits.get(0);
        String thirdFruit = fruits.get(2);
        System.out.println("\n2. Retrieval:");
        System.out.println("   Element at index 0: " + firstFruit);
        System.out.println("   Element at index 2: " + thirdFruit);

        fruits.set(2, "Blackberry");
        System.out.println("\n3. After updating index 2 to 'Blackberry': " + fruits);

        System.out.println("\n4. Verification:");
        System.out.println("   Contains 'Mango'? " + fruits.contains("Mango"));
        System.out.println("   Contains 'Orange'? " + fruits.contains("Orange"));
        System.out.println("   Index of 'Banana': " + fruits.indexOf("Banana"));
        System.out.println("   Is list empty? " + fruits.isEmpty());
        System.out.println("   Current Size: " + fruits.size());

        fruits.remove(1);
        fruits.remove("Mango");
        System.out.println("\n5. After removing index 1 and object 'Mango': " + fruits);

        Collections.sort(fruits);
        System.out.println("\n6. After alphabetical sort: " + fruits);

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

        fruits.clear();
        System.out.println("\n8. After clear(): " + fruits + ", Is Empty? " + fruits.isEmpty());
    }
}
