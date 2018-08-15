package twelfth_eighth;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description: 正方体问题
 * @Author: daihong
 * @Date: Created in  2018/8/15
 */
public class Test1 {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(main(arr));
    }

    public static Boolean main(int[] arr) {
        Boolean b = false;
        Set<int[]> set = new TreeSet<>();
        sort(set, arr, 0);
        for(int[] ints:set){
           /*if((ints[0]+ints[1]+ints[2]+ints[3]==ints[4]+ints[5]+ints[6]+ints[7])&&(ints[0]+ints[1]+ints[6]+ints[7]==ints[4]+ints[5]+ints[2]+ints[3])&&(ints[0]+ints[7]+ints[4]+ints[3]==ints[1]+ints[5]+ints[6]+ints[2])){
               b = true;
               break;
           }*/
           for(int i=0;i<ints.length;i++){
               System.out.print(ints[i]+" ");
           }
            System.out.println();
        }
        return b;
    }

    public static void sort(Set<int[]> set, int[] arr, int x) {
        if (arr == null) return;
        if (x == arr.length - 1) {
           set.add(arr);
            return;
        }
        for (int i = 0; i < arr.length - x; i++) {
            int temp = arr[arr.length - x - 1];
            arr[arr.length - x - 1] = arr[i];
            arr[i] = temp;
            sort(set, arr, x + 1);
            temp = arr[arr.length - x - 1];
            arr[arr.length - x - 1] = arr[i];
            arr[i] = temp;
        }
    }
}

