package twelfth_third;

import java.util.*;

/**
 * @Description:
 * @Author: daihong
 * @Date: Created in  2018/8/16
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {4, 32, 321};
        print(arr);
        printInfo(arr);
    }

    public static void print(int[] arr) {
        List<int[]> list = new LinkedList<>();
        sort(arr, list, 0);
        int[] b = new int[list.size()];
        List<StringBuilder> list1 = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < list.get(i).length; j++) {
                stringBuilder.append(list.get(i)[j]);
            }
            list1.add(stringBuilder);
        }
        for (int i = 0; i < list1.size(); i++) {
            StringBuilder stringBuilder = list1.get(i);
            b[i] = Integer.parseInt(stringBuilder.toString());
        }
        Arrays.sort(b);
        System.out.println(b[0]);
    }

    public static void sort(int[] arr, List<int[]> list, int x) {
        if (x == arr.length - 1) {
            int[] b = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                b[i] = arr[i];
            }
            list.add(b);
            return;
        }
        for (int i = 0; i < arr.length - x; i++) {
            int temp = arr[arr.length - x - 1];
            arr[arr.length - x - 1] = arr[i];
            arr[i] = temp;
            sort(arr, list, x + 1);
            temp = arr[arr.length - x - 1];
            arr[arr.length - x - 1] = arr[i];
            arr[i] = temp;
        }
    }

    public static void printInfo(int[] arr) {
        String s1 = String.valueOf(arr[0]);
        String s2 = null;
        String s = null;
        for (int i = 1; i < arr.length; i++) {
            s2 = String.valueOf(arr[i]);
            if ((s1 + s2).compareTo(s2 + s1) >= 1) {
                s = s2 + s1;
            } else {
                s = s1+s2;
            }
            s1 = s;
        }
        System.out.println(s);
    }
}
