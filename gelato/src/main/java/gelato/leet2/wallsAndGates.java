package gelato.leet2;

//286
public class wallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int x, int y) {
        int dist = rooms[x][y] + 1;
        if (x > 0 && rooms[x - 1][y] > 0 && rooms[x - 1][y] > dist) {
            rooms[x - 1][y] = dist;
            dfs(rooms, x - 1, y);
        }
        if (x < rooms.length - 1 && rooms[x + 1][y] > 0 && rooms[x + 1][y] > dist) {
            rooms[x + 1][y] = dist;
            dfs(rooms, x + 1, y);
        }
        if (y > 0 && rooms[x][y - 1] > 0 && rooms[x][y - 1] > dist) {
            rooms[x][y - 1] = dist;
            dfs(rooms, x, y - 1);
        }
        if (y < rooms[0].length - 1 && rooms[x][y + 1] > 0 && rooms[x][y + 1] > dist) {
            rooms[x][y + 1] = dist;
            dfs(rooms, x, y + 1);
        }
    }
}
