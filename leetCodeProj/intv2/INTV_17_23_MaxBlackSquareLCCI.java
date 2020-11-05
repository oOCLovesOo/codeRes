package codeRes.leetCodeProj.intv2;

public class INTV_17_23_MaxBlackSquareLCCI {
    public int[] findSquare(int[][] matrix) {
        if(matrix[0].length==0){
            return new int[]{};
        }

        for(int k = matrix[0].length; k >= 1 ; k--){
            for(int r=0;r<=matrix[0].length-k;r++){
                for(int c=0;c<=matrix[0].length-k;c++){
                    if(isOk(matrix,r,c,k)){
                        return new int[]{r,c,k};
                    }
                }
            }
        }
        return new int[]{};
    }

    public int[] findSquare2(int[][] matrix) {
        if(matrix[0].length==0){
            return new int[]{};
        }


        for(int k = matrix[0].length; k >= 1 ; k--){
            for(int r=0;r<=matrix[0].length-k;r++){
                for(int c=0;c<=matrix[0].length-k;c++){
                    if(isOk(matrix,r,c,k)){
                        return new int[]{r,c,k};
                    }
                }
            }
        }
        return new int[]{};
    }


    public boolean isOk(int[][] martrix,int r,int c,int k){
        for(int i=r;i<=r+k-1;i++){
            if(martrix[i][c]==1||martrix[i][c+k-1]==1){
                return false;
            }
        }

        for(int j=c;j<=c+k-1;j++){
            if(martrix[r][j]==1||martrix[r+k-1][j]==1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[][] a = {
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1},
                {1,1,0,0,0,1,1},
                {1,1,0,0,0,0,1},
                {1,1,0,0,1,1,0}
        };
        int[] b = new INTV_17_23_MaxBlackSquareLCCI().findSquare(a);
    }
}
