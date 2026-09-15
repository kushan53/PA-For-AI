package sorting_algorithms;

import java.util.Arrays;

/**
 * LeetCode 2418: Sort the People
 * You are given an array of strings names, and an array heights that consists of distinct positive integers.
 * Return names sorted in descending order by the people's heights.
 *
 * Example:
 * Input: names = ["Mary","John","Emma"], heights = [180,165,170]
 * Output: ["Mary","Emma","John"]
 *
 * Time Complexity: O(N log N)
 * Space Complexity: O(N)
 */
public class LC2418_SortThePeople {

    static class Person {
        String name;
        int height;

        Person(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Person[] people = new Person[n];

        for (int i = 0; i < n; i++) {
            people[i] = new Person(names[i], heights[i]);
        }

        // Sort in descending order of height
        Arrays.sort(people, (a, b) -> Integer.compare(b.height, a.height));

        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people[i].name;
        }

        return sortedNames;
    }

    public static void main(String[] args) {
        String[] names1 = { "Mary", "John", "Emma" };
        int[] heights1 = { 180, 165, 170 };

        System.out.println("Original Names:   " + Arrays.toString(names1));
        System.out.println("Original Heights: " + Arrays.toString(heights1));
        System.out.println("Sorted by Height: " + Arrays.toString(sortPeople(names1, heights1)));

        String[] names2 = { "Alice", "Bob", "Bob" };
        int[] heights2 = { 155, 185, 150 };
        System.out.println("\nOriginal Names:   " + Arrays.toString(names2));
        System.out.println("Original Heights: " + Arrays.toString(heights2));
        System.out.println("Sorted by Height: " + Arrays.toString(sortPeople(names2, heights2)));
    }
}
