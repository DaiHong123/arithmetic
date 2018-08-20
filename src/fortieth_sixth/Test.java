package fortieth_sixth;

/**
 * @Description: 求1+2+3+.....+n不能使用乘除法等.
 * @Author: daihong
 * @Date: Created in  2018/8/20
 */
public class Test {
    public static void main(String[] args){
        int n = 10;
        System.out.println(add(n));

    }
   public static int add(int n){
      return n*(n+1)/2;
   }
}
