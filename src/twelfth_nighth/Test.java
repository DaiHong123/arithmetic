package twelfth_nighth;

import java.util.regex.Pattern;

/**
 * @Description: 找出出现超过数组一半的数字重复。
 * @Author: daihong
 * @Date: Created in  2018/8/15
 */
public class Test {
    public static void main(String[] args){
        int arr[] = {1,2,3,3,3,3,5,4,3};
        //sort(arr,0,0);
        sort(arr);
    }
    public static void sort(int arr[],int n,int pre){
        int count = 1;
        if(n==arr.length){
            System.out.println("0");
            return;
        }
        if(n>0){
            for(int i=n;i<arr.length;i++){
                if(arr[n]==arr[pre]){
                    n++;
                }
            }
        }
       for (int i=n+1;i<arr.length;i++){
           if(arr[n]==arr[i]){
               ++count;
           }
       }
            if(count<=(arr.length/2)){
                sort(arr,n+1,n);
            } else {
                System.out.println(arr[n]);
            }
    }


    public static void quickSort(int[] arr,int left,int right){
        int begin = left;
        int end = right;
        if(left>right) return;;
        int key = arr[left];
        while (begin<end){
            while (begin<end&&key<=arr[end]){
                end--;
            }
            if(arr[end]<key){
                int temp = arr[end];
                arr[end] = arr[begin];
                arr[begin] = temp;
            }
            while (begin<end&&arr[begin]<=key){
                begin++;
            }
            if(arr[begin]>key){
                int temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp;
            }
        }
        if(begin>left) quickSort(arr,left,begin-1);
        if(end<right) quickSort(arr,end+1,right);
    }

    public static void sort(int[] arr){
        quickSort(arr,0,arr.length-1);
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==arr[arr.length/2])
               count++;
        }
        if(count<=arr.length/2)
            System.out.println("0");
        else
        System.out.println(count);
    }
}
