package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC451_SortCharactersByFrequency {

    public static String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        List<Character> characters = new ArrayList<>(freqMap.keySet());
        characters.sort((a, b) -> Integer.compare(freqMap.get(b), freqMap.get(a)));

        StringBuilder sb = new StringBuilder();
        for (char ch : characters) {
            int count = freqMap.get(ch);
            for (int i = 0; i < count; i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }
}
