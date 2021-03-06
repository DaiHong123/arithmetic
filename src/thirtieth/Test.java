package thirtieth;

import com.sun.deploy.util.ArrayUtil;

/**
 * @Description: 求一个数组中最小的k个数.
 * @Author: daihong
 * @Date: Created in  2018/8/15
 */
public class Test {
    public static void main(String[] args) {
        int k = 4;
        int[] arr = {4, 5, 1, 6};
        //quickSort(arr, k);
        /*qSort1(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
        heap(arr);
       /* if(k<arr[0]){
            arr[0] = k;
            heap(arr);
        }*/
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr, int left, int right) {
        if (left > right) return;
        int begin = left;
        int end = right;
        int key = arr[begin];
        while (begin < end) {
            while (begin < end && arr[end] >= key) {
                end--;
            }
            if (arr[end] < key) {
                int temp = arr[end];
                arr[end] = arr[begin];
                arr[begin] = temp;
            }
            while (begin < end && arr[begin] <= key) {
                begin++;
            }
            if (arr[begin] > key) {
                int temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp;
            }
        }
        if (begin > left) sort(arr, left, begin - 1);
        if (end < right) sort(arr, end + 1, right);
    }

    public static void quickSort(int[] arr, int k) {
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int partition(int[] arr, int begin, int end, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, end);
        int storeIndex = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, storeIndex);
                ++storeIndex;
            }
        }
        swap(arr, storeIndex, end);
        return storeIndex;
    }

    public static int partition2(int[] arr, int begin, int end, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, end);
        int i = begin, j = end;
        while (i < j) {
            while (i < j && arr[i] <= pivot) i++;
            while (i < j && arr[j] >= pivot) j--;
            if (i < j) swap(arr, i, j);
        }
        swap(arr, i, end);
        return i;
    }

    public static void qSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int p = partition(arr, begin, end, end);
            qSort(arr, begin, p - 1);
            qSort(arr, p + 1, end);
        }
    }

    public static void qSort1(int[] arr, int begin, int end) {
        if (begin < end) {
            int p = partition2(arr, begin, end, end);
            qSort1(arr, begin, p - 1);
            qSort1(arr, p + 1, end);
        }
    }

    public static void swap(int[] arr, int form, int to) {
        int temp = arr[form];
        arr[form] = arr[to];
        arr[to] = temp;
    }

    public static void heapIfy(int[] arr, int currentRootNode, int size) {
        if (currentRootNode < size) {
            int left = 2 * currentRootNode + 1;
            int right = 2 * currentRootNode + 2;
            int max = currentRootNode;
            if (left < size) {
                if (arr[left] > arr[max]) {
                    max = left;
                }
            }
            if (right < size) {
                if (arr[right] > arr[max]) {
                    max = right;
                }
            }
            if (max != currentRootNode) {
                int temp = arr[max];
                arr[max] = arr[currentRootNode];
                arr[currentRootNode] = temp;
                heapIfy(arr, max, arr.length);
            }
        }
    }

    public static void maxHeapIfy(int[] arr, int size) {
        for (int i = size - 1; i >= 0; i--) {
            heapIfy(arr, i, size);
        }
    }
    public static void heap(int[] arr){
        for (int i=0;i<arr.length;i++){
            maxHeapIfy(arr,arr.length-1);
            int temp = arr[0];
            arr[0] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }
}
