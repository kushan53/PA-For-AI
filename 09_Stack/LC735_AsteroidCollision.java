package stack;

import java.util.Stack;
import java.util.Arrays;

public class LC735_AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean alive = true;
            while (alive && ast < 0 && !stack.isEmpty() && stack.peek() > 0) {
                if (stack.peek() < -ast) {
                    stack.pop();
                } else if (stack.peek() == -ast) {
                    stack.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }
            if (alive) {
                stack.push(ast);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ast1 = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(ast1)));

        int[] ast2 = {8, -8};
        System.out.println(Arrays.toString(asteroidCollision(ast2)));

        int[] ast3 = {10, 2, -5};
        System.out.println(Arrays.toString(asteroidCollision(ast3)));
    }
}
