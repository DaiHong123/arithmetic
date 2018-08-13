package sixth;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Choose {
    public static void sort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
