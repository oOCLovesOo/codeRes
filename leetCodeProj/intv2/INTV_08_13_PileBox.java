package codeRes.leetCodeProj.intv2;

import java.util.*;

public class INTV_08_13_PileBox {
    Integer maxHight = -1;
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int pileBox(int[][] box) {
        recursion(box,new HashSet<Integer>(),0,-1);
        return maxHight;
    }

    public int recursion(int[][] box, Set<Integer> set, int nowHight,int belowBox){
        boolean isIn = false;
        int curBoxMax = 0;
        for(int i = 0; i < box.length; i++){
            if(set.contains(i)){
                continue;
            }else{
                if(belowBox==-1||(box[belowBox][0]>box[i][0] && box[belowBox][1]>box[i][1] && box[belowBox][2]>box[i][2])){
                    isIn = true;
                    set.add(i);
                    int res = 0;
                    if(map.containsKey(i)){
                        res = map.get(i);
                    }else{
                        res = recursion(box,set,nowHight + box[i][2],i);
                    }
                    if(res>curBoxMax){
                        curBoxMax = res;
                    }
                    set.remove(i);
                }
            }
        }
        if(isIn == false && nowHight>maxHight){
            maxHight = nowHight;
        }
        if(belowBox!=-1) {
            if (isIn == false) {
                curBoxMax = box[belowBox][2];
            } else {
                curBoxMax += box[belowBox][2];
            }
            if(!map.containsKey(belowBox)){
                map.put(belowBox,curBoxMax);
            }

            if(curBoxMax>maxHight){
                maxHight = curBoxMax;
            }
        }

        return curBoxMax;
    }


    public static void main(String[] args){
        int[][] a = {{1, 1, 1}, {2, 3, 4}, {2, 6, 7}, {3, 4, 5}};
//        int[][] a = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        System.out.println(new INTV_08_13_PileBox().pileBox(a));
    }
}
