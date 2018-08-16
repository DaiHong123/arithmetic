package frist;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test01 {
    public Boolean sure(int[][] arr, int k) {
        Boolean b = false;
        for (int i = 0; i < arr.length; i++) {
            if (b ==false) {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    if (arr[i][j] > k) {
                        continue;
                    } else if (arr[i][j] < k) {
                        break;
                    } else {
                        b = true;
                        break;
                    }
                }
            }
            if(b == true)
                break;
        }
        return b;
    }
    public Boolean sure1(int[][] arr,int k){
        Boolean b = false;
        int row = 0;
        int clo = arr[0].length-1;
        if(arr==null){
            return false;
        }
        while (row<arr.length&&clo>0){
            if(arr[row][clo]==k){
                b = true;
                break;
            }else if(arr[row][clo]>k){
                clo --;
                continue;
            }else {
                row ++;
            }
        }
        return b;
    }
}
