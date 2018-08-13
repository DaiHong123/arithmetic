package sixth;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Binary {
    public static int arrBinary(int[] arr,int k,int left,int right){
       int mid = (left+right)/2;
       if(arr[mid]==k){
           return  mid;
       } else if(left<=right){
           if(arr[mid]>k){
             return   arrBinary(arr,k,left,mid-1);
           } else{
             return   arrBinary(arr,k,mid+1,right);
           }
       }else {
           return -2;
       }
    }
    public static int arrBinary(int[] arr,int k){
        int left = 0;
        int right = arr.length;
        int mid = (left+right)/2;
        while (arr[mid]!=k){
            if(arr[mid]<k){
                left = mid + 1;
            }else if(arr[mid]>k){
                right = mid - 1;
            }
            if(left>right){
                return -1;
            }
            mid = (left+right)/2;
        }
        return mid;
    }
    public static void main(String[] args){
        int[] arr = {5,6,8,9,10,15,16};
        System.out.println(arrBinary(arr,5));
        System.out.println("位置为"+(arrBinary(arr,1,0,arr.length-1)+1));
    }
}
