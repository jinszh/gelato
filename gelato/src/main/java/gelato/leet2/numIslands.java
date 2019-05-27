package gelato.leet2;

import java.util.LinkedList;

//200
public class numIslands {
    //貌似做dfs之类的, 递归调用都比自己创建queue或者stack更快...好吧...
    public int numIslands(char[][] grid) {
        int isles = 0;
        for(int i = 0 ; i < grid.length; i++){
            for (int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    isles++;
                    LinkedList<int[]> q = new LinkedList<>();
                    char newIsle = (char) ('1' + isles);
                    grid[i][j] = newIsle;
                    q.add(new int[]{i,j});
                    while (!q.isEmpty()){
                        int[] head = q.poll();
                        if(head[0] < grid.length - 1 && grid[head[0] + 1][head[1]] == '1'){
                            grid[head[0] + 1][head[1]] = newIsle;
                            q.add(new int[]{head[0] + 1, head[1]});
                        }
                        if(head[0] > 0 && grid[head[0] - 1][head[1]] == '1'){
                            grid[head[0] - 1][head[1]] = newIsle;
                            q.add(new int[]{head[0] - 1, head[1]});
                        }
                        if(head[1] > 0 && grid[head[0]][head[1] - 1] == '1') {
                            grid[head[0]][head[1] - 1] = newIsle;
                            q.add(new int[]{head[0], head[1] - 1});
                        }
                        if(head[1] < grid[0].length - 1 && grid[head[0]][head[1] + 1] == '1') {
                            grid[head[0]][head[1] + 1] = newIsle;
                            q.add(new int[]{head[0], head[1] + 1});
                        }
                    }
                }
            }
        }
        return isles;
    }
}
