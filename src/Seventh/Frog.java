package Seventh;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Frog {
    public static int jump(int n){
        if(n<=0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        return jump(n-1)+jump(n-2);
    }
    public static void main(String[] args){
        System.out.println(jump(10));
    }
}
