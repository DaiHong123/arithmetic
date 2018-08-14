package eleventh;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test2 {
    public static int Binary(int a, int b){
        int count = 0;
        int c = a^b;
        while (c!=0){
            if((c&1)==1)
           count++;
            c = c>>1;
        }
        return count;
    }
    public static void main(String[] args){
        System.out.println(Binary(11,13));
    }
}
