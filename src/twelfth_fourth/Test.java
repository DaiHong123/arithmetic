package twelfth_fourth;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {


    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        System.out.println(print(arr,arr.length));
    }

    public static Boolean print(int[] arr,int length) {
        if(arr==null&&arr.length<0) return false;
        int root = arr[length-1];
        int i = 0;
        for(;i<length;i++){
            if(arr[i]>root){
                break;
            }
        }
        int j = i;
        for(;j<length-1;j++){
            if(arr[j]<root){
                return false;
            }
        }
        Boolean left = true;
        if(length-i>0){
            left = print(arr,i);
        }
        Boolean right = true;
        if(i<length-1){
            right = print(arr,length-i-1);
        }
        return left&&right;
    }
}
