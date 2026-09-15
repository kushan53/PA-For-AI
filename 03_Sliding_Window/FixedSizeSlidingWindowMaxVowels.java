package sliding_window;

public class FixedSizeSlidingWindowMaxVowels {

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static int maxVowels(String s, int k) {
        if (s == null || s.length() < k || k <= 0) return 0;

        int currentVowelCount = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                currentVowelCount++;
            }
        }

        int maxVowelCount = currentVowelCount;

        for (int i = k; i < s.length(); i++) {

            if (isVowel(s.charAt(i))) {
                currentVowelCount++;
            }

            if (isVowel(s.charAt(i - k))) {
                currentVowelCount--;
            }

            maxVowelCount = Math.max(maxVowelCount, currentVowelCount);

            if (maxVowelCount == k) {
                return maxVowelCount;
            }
        }

        return maxVowelCount;
    }

    public static void main(String[] args) {
        String s1 = "abciiidef";
        int k1 = 3;
        System.out.println("String: \"" + s1 + "\", k = " + k1 + " -> Max Vowels: " + maxVowels(s1, k1));

        String s2 = "aeiou";
        int k2 = 2;
        System.out.println("String: \"" + s2 + "\", k = " + k2 + " -> Max Vowels: " + maxVowels(s2, k2));

        String s3 = "leetcode";
        int k3 = 3;
        System.out.println("String: \"" + s3 + "\", k = " + k3 + " -> Max Vowels: " + maxVowels(s3, k3));
    }
}
