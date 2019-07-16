package gelato.leet7;

import java.util.Arrays;
import java.util.LinkedList;

//735
public class asteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.add(asteroids[i]);
            } else {
                while (!stack.isEmpty() && stack.peekLast() > 0 && stack.peekLast() < -asteroids[i]) {
                    stack.pollLast();
                }
                if (stack.isEmpty() || stack.peekLast() < 0) {
                    stack.add(asteroids[i]);
                }
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    //更快的办法 - 基本原理就是用数组替换java的栈 - 这样快很多
    public int[] asteroidCollision1(int[] asteroids) {
        int index = 1; //即将处理的数
        int end = 0; //栈尾
        while (index < asteroids.length) {
            if (end == -1) {
                asteroids[0] = asteroids[index];
                end = 0;
                index++;
                continue;
            } else {
                if (asteroids[end] > 0 && asteroids[index] < 0) {//弹栈
                    if (Math.abs(asteroids[end]) == Math.abs(asteroids[index])) {
                        end--;
                        index++;
                    } else if (Math.abs(asteroids[end]) > Math.abs(asteroids[index])) {
                        index++;
                    } else {
                        end--;
                    }
                } else {//入栈
                    end++;
                    asteroids[end] = asteroids[index];
                    index++;
                }
            }
        }

        return Arrays.copyOf(asteroids, end + 1);
    }
}
