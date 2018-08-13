package sixth;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
    public static int sort(int[] arr) {
        int left = 0;
        int mid = left;
        int right = arr.length-1;
        while (arr[left] >= arr[right]) {
            if (right-left == 1) {
                mid = right;
                break;
            }
             mid = (left + right) / 2;
            if (arr[mid] >= arr[left]) {
                left = mid ;
            }
            if (arr[mid] < arr[right]) {
                right = mid ;
            }

        }
        return arr[mid];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sort(arr));
    }
}
