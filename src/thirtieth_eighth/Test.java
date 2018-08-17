package thirtieth_eighth;

/**
 * @Description: 数字出现几次
 * @Author: daihong
 * @Date: Created in  2018/8/17
 */
public class Test {
    static int count = 0;
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 5, 6};
        //System.out.println(mids(arr, 0, arr.length, 3));
        sort(arr,0,arr.length,3);
        System.out.println(count);
    }

    public static int mids(int[] arr, int left, int right, int n) {
        if(left>right){
            return -1;
        }
        int mid = (left + right) / 2;
        if(arr[mid]==n){
            if((mid>0&&arr[mid-1]!=n)||mid==0){
                return mid;
            }else {
                right = mid - 1;
            }
        }else if(arr[mid]>n){
            right = mid -1;
        }else{
            left = mid+1;
        }
        return mids(arr,left,right,n);
    }

    public static void sort(int[] arr,int left,int right,int n){
        if(left>right)
            return;
        int mid = (left+right)/2;
        if(arr[mid]==n){
            count++;
            if(mid>1){
                if(arr[mid-1]==n){
                    sort(arr,left,mid-1,n);
                }
            }
            if(mid<arr.length-1){
                if(arr[mid+1]==n){
                    sort(arr,mid+1,right,n);
                }
            }
        }else if(arr[mid]!=n){
            if(arr[mid]<n){
                sort(arr,mid+1,right,n);
            }else {
                sort(arr,left,mid-1,n);
            }
        }
    }
}
