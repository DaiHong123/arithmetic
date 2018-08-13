package Seventh;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Fibonacci {
    public static int add(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        return add(n-1)+add(n-2);
    }
    public static int add1(int n){
        int[] f = new int[n+1];
        if(n<=0) return 0;
        f[0] = 0;
        f[1] = 1;
        for(int i=2;i<=n;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f[n];
    }
    public static void main(String[] args){
        System.out.println(add(10));
        System.out.println(add1(10));
    }
}
