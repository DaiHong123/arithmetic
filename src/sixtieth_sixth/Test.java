package sixtieth_sixth;

/**
 * @Description: 机器人走路ss1
 * @Author: daihong
 * @Date: Created in  2018/8/23
 */
public class Test {
    public static void main(String[] args){
        System.out.println(moving(18,35,36));
    }
    public static int moving(int threshold,int rows,int cols){
        int flag[][] = new int[rows][cols];
        return helper(0,0,rows,cols,flag,threshold);
    }
    public static int helper(int i,int j,int rows,int cols,int[][] flag,int threshold){
        if (i<0||i>=rows||j<0||j>=cols||flag[i][j]==1||num(i)+num(j)>threshold) return 0;
        flag[i][j] = 1;
        return helper(i-1,j,rows,cols,flag,threshold)+helper(i+1,j,rows,cols,flag,threshold)
                +helper(i,j-1,rows,cols,flag,threshold)+helper(i,j+1,rows,cols,flag,threshold)+1;
    }
    public static int num(int i){
        int sum = 0;
        while (i>0){
            sum = sum + i%10;
            i = i/10;
        }
        return sum;
    }
}
