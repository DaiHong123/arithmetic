package fourteenth;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
    public static void sort(int[] arr){
        int[] a = new int[arr.length];
        int[] b = new int[arr.length];
        int[] c = new int[arr.length];
        int j=0;
        int k=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]%2==1){
               a[j++]=arr[i] ;
            }else {
                b[k++]=arr[i];
            }
        }
        for(int i=0;i<c.length;i++){
            if(i<j){
                c[i] = a[i];
            }
            if(i-j>=0) {
                c[i] = b[i-j];
            }
        }
        for (int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
    }
    public static void sort(int[] arr,int length){
        if(arr==null||length==0){
            return;
        }
        int left = 0;
        int right = length-1;
        while (left<right){
            while (left<right&&arr[right]%2==0){
                right--;
            }
           while (left<right&&arr[left]%2==1){
                left++;
           }
           if(arr[right]%2==1&&arr[left]%2==0){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
           }
        }
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args){
        int[] arr = {2,4,3,-1,0,9,8,5};
        //sort(arr);
    sort(arr,arr.length);
    }
}
