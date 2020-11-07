package codeRes.leetCodeProj.intv2;

import java.util.*;

public class INTV_16_22_LangtonsAntLCCI2 {
    char[] direction = {'U', 'R', 'D', 'L'};
    public List<String> printKMoves(int K) {
        if(K==0){
            List<String> list = new ArrayList<>();
            list.add("R");
            return list;
        }

        Set<Position> set = new HashSet<Position>();
        int farUp = 0;
        int farDown = 0;
        int farLeft = 1;
        int farRight = 1;

        int nowX = 1;
        int nowY = 0;
        //0↑ ，1→ ，2↓， 3←
        int nowDir = 1;
        for (int i = 0; i < K; i++) {
            Position pos =  new Position(nowX,nowY);
            //判断颜色并转向
            if (set.contains(pos) ){
                set.remove(pos);
                nowDir = (nowDir + 3)%4;
            } else {
                set.add(pos);
                nowDir = (nowDir + 1)%4;
            }

            //移动
            switch (nowDir) {
                case 0:
                    nowY--;
                    break;
                case 1:
                    nowX++;
                    break;
                case 2:
                    nowY++;
                    break;
                case 3:
                    nowX--;
                    break;
                default:
                    break;
            }

            if (nowY > farDown) {
                farDown = nowY;
            }
            if (nowY < farUp) {
                farUp = nowY;
            }
            if (nowX > farRight) {
                farRight = nowX;
            }
            if (nowX < farLeft) {
                farLeft = nowX;
            }


        }

        char[][] grid = new char[farDown - farUp + 1][farRight - farLeft + 1];
        for (char[] row : grid)
            Arrays.fill(row, '_');

        for (Position pos : set)
            grid[pos.y - farUp][pos.x - farLeft] = 'X';

        grid[nowY - farUp][nowX - farLeft] = direction[nowDir];

        List<String> result = new ArrayList<>();
        for (char[] row : grid)
            result.add(String.valueOf(row));

        return result;
    }

    private class Position {

        // 横坐标 x 纵坐标 y
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Position)) return false;
            Position o = (Position) obj;
            return x == o.x && y == o.y;
        }

        // 改写哈希算法，使两个 Position 对象可以比较坐标而不是内存地址
        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(String[] agrs){
        new INTV_16_22_LangtonsAntLCCI2().printKMoves(2);
    }

}
