package twenty_first;

import java.util.Stack;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public  void push(int node){
       stack.push(node);
       if(minStack!=null){
           if(minStack.peek()>=node){
               minStack.push(node);
           }else {
               minStack.push(minStack.peek());
           }
       }
       else {
           minStack.push(node);
       }
    }
    public void pop(){
        if(stack!=null){
            stack.pop();
            minStack.pop();
        }

    }
    public int top(){
        return stack.peek();
    }
    public int min(){
        return minStack.peek();
    }
    public static void main(String[] args){}

}
