package sixth;

/**
 * @Author: daihong
 * @Date: 2018/8/8
 */
public class FastRow {
    public static void fastRow(int[] arr,int left,int right) {
        int begin = left;
        int end = right;
        int key = arr[left];
        if (left > right) {
            return;
        }
        while (begin < end) {
            while (begin < end && arr[end] >= key) {
                end--;
            }
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[begin];
                arr[begin] = temp;
            }
            while (begin < end && arr[begin] <= key) {
                begin++;
            }
            if (arr[begin] >= key) {
                int temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp;
            }
        }
        if (begin > left) fastRow(arr, left, begin - 1);
        if (end < right) fastRow(arr, end + 1, right);
    }
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        fastRow(arr,0,9);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
