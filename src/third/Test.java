package third;

import java.util.ArrayList;
import java.util.Stack;


/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
    public ArrayList<Integer> sort(ArrayList<Integer> arrayList){
        Stack<Integer> stack = new Stack<>();
        if(arrayList!=null){
            for(Integer integer:arrayList){
                stack.push(integer);
            }
        }


        while (stack.size()>0){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
        return arrayList;
    }
    public static void main(String[] args){
        Test test = new Test();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        test.sort(arrayList);
    }
}
