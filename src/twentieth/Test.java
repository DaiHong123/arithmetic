package twentieth;

/**
 * @Description: 回文
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
    public static void palindrome(int[][] arr,int x1,int x2,int x3,int x4){
        if(x1==x2||x3==x4||x1==x4||x2==x3) return;
        if(x1>=arr.length||x2<x1||x3>=arr.length||x4<x3) return;
        for (int i=x1;i<x2;i++){
            System.out.println(arr[x1][i]);
        }
            for(int i=x1+1;i<x2;i++){
                System.out.println(arr[i][x2-1]);
            }
            for(int i=x3-2;i>x3;i--){
                System.out.println(arr[x4-1][i]);
        }
        for(int i=x4-1;i>x1;i--){
            System.out.println(arr[i][x1]);
        }
        palindrome(arr,x1+1,x2-1,x3+1,x4-1);
    }
    public static void main(String[] args){
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        palindrome(arr,0,arr[0].length,0,arr.length);
    }
}
