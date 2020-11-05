package codeRes.leetCodeProj.intv2;

public class INTV_16_11_DivingBoardLCCI {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            return new int[]{};
        }
        if(shorter==longer){
            return  new int[]{shorter * k};
        }

        int[] a = new int[k+1];
        a[0] = shorter * k;
        int subNum = longer - shorter;

        for (int i=1;i<=k;i++){
            a[i] = a[0] + subNum * i;
        }

        return a;
    }

    public static void main(String[] args){
        new INTV_16_11_DivingBoardLCCI().divingBoard(1,2,3);
    }



}
