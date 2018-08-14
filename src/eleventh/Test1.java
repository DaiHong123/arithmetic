package eleventh;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test1 {
    public static int Binary(int k){
        int count = 0;
       while (k!=0){
            count ++;
            k = (k-1)&k;
       }
      return count;
    }

    public static void main(String[] args){
        System.out.println(Binary(-1));
    }
}
