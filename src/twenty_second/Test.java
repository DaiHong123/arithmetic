package twenty_second;

import java.util.Stack;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {

    public static Boolean sure(int[] a, int[] b) {
        Boolean flag = false;
        if (a != null && b != null ) {
            int j = 0;
            int top = 0;
            int k = 0;
            int l = 0;
            int b1[] = new int[a.length];
            Stack<Integer> stack = new Stack<>();
            while (j<b.length) {
                for(int i=0;i<a.length;i++){
                    if(a[i] ==b[j]){
                        top = i;
                    }
                }
                    for(int i=k;i<=top;i++){
                        stack.push(a[i]);
                    }
                k = stack.pop();
                    b1[l++] = k;
               j++;
            }

            for(int i=0;i<b1.length;i++){
                if(b1[i]!=b[i]){
                    flag = false;
                    break;
                }
                flag = true;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int a[] ={1,2,3,4,5};
        int b[] ={4,5,3,2,1};
        System.out.println(sure(a,b));
    }
}

