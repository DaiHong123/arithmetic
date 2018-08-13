package fifth;

import java.util.Stack;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
    public static void queue(Stack<Integer> stack1,Stack<Integer> stack2){
        while (stack2.size()!=0){
            stack1.push(stack2.pop());
        }
        while (stack1.size()!=0){
            stack2.push(stack1.pop());
        }
       while (stack2.size()!=0){
           System.out.print(stack2.pop()+" ");
       }
    }
    public static void main(String[] args){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int[] a = {1,2,3};
        int[] b = {6,5,4};
        int i = 0,j = 0;
        while (i<a.length){
            stack1.push(a[i]);
            i++;
        }
        while (j<b.length){
            stack2.push(b[j]);
            j++;
        }
        queue(stack1,stack2);
    }
}
