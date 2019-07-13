package gelato.leet8;

import java.util.Arrays;

//853
public class carFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 0) return 0;
        int res = 1;
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));
        double t = (double)(target - cars[0][0]) / cars[0][1];
        for (int i = 1; i <= cars.length - 1; i++) {
            double t2 = (double)(target - cars[i][0]) / cars[i][1];
            if (t - t2 < 0) {
                res++;
                t = t2;
            }
        }
        return res;
    }
}
