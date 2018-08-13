package Seventh;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Frog1 {
    public static int jump(int n){
        if(n<=0) return 0;
        if(n==1) return 1;
        return 2*jump(n-1);
    }
    public static void main(String[] args){
        System.out.println(jump(9));
    }
}
