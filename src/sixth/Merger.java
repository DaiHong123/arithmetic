package sixth;

/**
 * @Author: daihong
 * @Date: $date$
 */
public class Merger {
    public static void merge(int[] a, int[] b, int[] c) {
        int i, j, k;
        i = j = k = 0;
        while (i <= a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
    }

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        internalMergeSort(arr,temp,0,arr.length-1);
    }

    public static void internalMergeSort(int[] a, int[] b, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            internalMergeSort(a, b, left, mid);
            internalMergeSort(a, b, mid + 1, right);
            mergeSortedArray(a,b,left,mid,right);
        }
    }

    public static void mergeSortedArray(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i < k; ++i) {
            arr[left + i] = temp[i];
        }
    }

    public static void main(String[] args){
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
       mergeSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
