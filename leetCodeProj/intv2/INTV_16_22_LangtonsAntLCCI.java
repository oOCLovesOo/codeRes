package codeRes.leetCodeProj.intv2;

import java.util.*;

public class INTV_16_22_LangtonsAntLCCI {
    public List<String> printKMoves(int K) {
        if(K==0){
            List<String> list = new ArrayList<>();
            list.add("R");
            return list;
        }

        Set<String> set = new HashSet<String>();
        int farUp = 0;
        int farDown = 0;
        int farLeft = 1;
        int farRight = 1;

        int nowX = 1;
        int nowY = 0;
        //0↑ ，1→ ，2↓， 3←
        int nowDir = 1;
        for (int i = 0; i < K; i++) {
            //判断颜色并转向
            if (set.contains(nowX + "_" + nowY)) {
                set.remove(nowX + "_" + nowY);
                nowDir--;
                if (nowDir < 0) {
                    nowDir = 3;
                }
            } else {
                set.add(nowX + "_" + nowY);
                nowDir++;
                if (nowDir > 3) {
                    nowDir = 0;
                }
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
        List<String> resList = new ArrayList<>();
        for (int j = farUp; j <= farDown; j++) {
            String temp = "";
            for (int i = farLeft; i <= farRight; i++) {
                if(i==nowX && j==nowY){
                    switch (nowDir) {
                        case 0:
                            temp+="U";
                            break;
                        case 1:
                            temp+="R";
                            break;
                        case 2:
                            temp+="D";
                            break;
                        case 3:
                            temp+="L";
                            break;
                        default:
                            break;
                    }
                }else {
                    if (set.contains(i + "_" + j)) {
                        temp += "X";
                    } else {
                        temp += "_";
                    }
                }
            }
            resList.add(temp);
        }

        return resList;
    }

    public static void main(String[] agrs){
        new INTV_16_22_LangtonsAntLCCI().printKMoves(2);
    }

}
