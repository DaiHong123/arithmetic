package sixtieth_fourth;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @Description: 滑动窗口
 * @Author: daihong
 * @Date: Created in  2018/8/23
 */
public class Test {
    public static void main(String[] args){
        int[] arr = {2,3,4,2,6,2,5,1};
        //sort(arr,3);
        ArrayList<Integer> max = max(arr, 3);
        max.forEach(name-> System.out.println(name));
    }
    public static void sort(int[] arr,int key){
        for (int i=0;i<=arr.length-key;i++){
            int[] brr = new int[key];
            int k=0;
            int max = arr[i];
            for (int j=i;j<i+key;j++){
                brr[k++] = arr[j];
            }
            sort(brr,0,brr.length-1);
            System.out.println(brr[brr.length-1]);
        }
    }
    public static void sort(int[] arr,int left,int right){
       int begin = left;
       int end = right;
       int key = arr[begin];
       if (begin>end) return;
       while (begin<end){
           while (begin<end&&arr[end]>=key){
               end--;
           }
           if (arr[end]<key){
               int temp = arr[end];
               arr[end] = arr[begin];
               arr[begin] = temp;
           }
           while (begin<end&&arr[begin]<=key){
               begin++;
           }
           if (arr[begin]>key){
               int temp = arr[begin];
               arr[begin] = arr[end];
               arr[end] = temp;
           }
           if (begin>left) sort(arr,left,begin-1);
           if (end<right) sort(arr,end+1,right);
       }
    }
    /**
     * 利用双向队列保存最大值
     */
    public static ArrayList<Integer> max(int[] arr,int key){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (arr==null||key<=0||arr.length==0||arr.length<key) return arrayList;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0;i<key;i++){
            while (!deque.isEmpty()&&arr[i]>arr[deque.getLast()]){
                deque.removeLast();
            }
            deque.add(i);
        }
        for (int i=key;i<arr.length;i++){
            arrayList.add(arr[deque.getFirst()]);
            while (!deque.isEmpty()&&arr[i]>=arr[deque.getLast()]){
                deque.removeLast();
            }
            if (!deque.isEmpty()&&deque.getFirst()<=i-key){
                deque.removeFirst();
            }
            deque.addLast(i);
            System.out.println(i+"--"+deque);
        }
        arrayList.add(arr[deque.getFirst()]);
        return arrayList;
    }
}
