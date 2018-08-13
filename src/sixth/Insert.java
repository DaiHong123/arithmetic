package sixth;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Insert {
    public static void sort(int[] arr){
        int j;
        for(int i=0; i<arr.length; i++){
            int key = arr[i];
            j = i;
            while (j>0&&key<arr[j-1]){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
