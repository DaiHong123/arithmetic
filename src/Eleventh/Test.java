package Eleventh;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
    public static int List(char[] s){
        int line = 0;
        int j = s.length-1;
       for(int i=0;i<s.length;i++){
           if(j>=0)
           line += (s[i]-64)*Math.pow(26,j--);
       }
     return  line;
    }
    public static void main(String[] args){
        char[] s = {'A','B','C'};
        System.out.println(List(s));
    }
}
