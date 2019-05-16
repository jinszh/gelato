package gelato.leet7;

public class escapeGhosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        //对于任何一只ghost你都得绕道走, 但是最终需要去的是target. 如果任何一只ghost能先到target自己就输了
        int max = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int d = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (d <= max) return false;
        }
        return true;
    }
}
