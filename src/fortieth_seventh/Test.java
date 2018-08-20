package fortieth_seventh;

/**
 * @Description: 求和
 * @Author: daihong
 * @Date: Created in  2018/8/20
 */
public class Test {
    public static void main(String[] args){
        int n1 = 5;
        int n2 = 7;
        int sum = 0;
        while (n2!=0){
            sum = n1^n2;
            n2 = (n1&n2)<<1;
            n1 = sum;
        }
        System.out.println(sum);
    }
}
