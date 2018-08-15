package twelfth_eighth;

/**
 * @Description: 8皇后问题
 * @Author: daihong
 * @Date: Created in  2018/8/15
 */
public class Test2 {
    public static void main(String[] args) {
        //System.out.println(input(0, 0, 8, new int[8]));
        check(0,0,new int[8]);
    }
    public static int input(int r, int total, int n, int[] ac) {
        for (int i = 0, j = 0; r < n && i < n; i++) {
            for ( j = 0; j < r; j++) {
                if (ac[j] == i || Math.abs(ac[j] - i) == Math.abs(j - r)) break;
            }
            if (j == r && (ac[r] = i) >= 0) total = input(r + 1, total, n, ac);
        }
        return r < n ? total : total + 1;
    }


    public static void check(int n,int print,int[] arr){
        if (n==arr.length){
            prints(arr);
            return ;
        }
        for(int i=0;i<arr.length;i++){
            arr[n] = i;
            if(jude(n,arr)){
                print = print+1;
                check(n+1,print,arr);
            }
        }

    }
    public static Boolean jude(int n,int[] arr){
        for (int i=0;i<n;i++){
            if(arr[n]==arr[i]||(Math.abs(n-i)==Math.abs(arr[n]-arr[i]))) return false;
        }
        return true;
    }
    public static void prints(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i] +1 + " ");
        }
        System.out.println();
    }
}
