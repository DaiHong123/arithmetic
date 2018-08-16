package thirtieth_frist;

/**
 * @Description: 输入一个整型数组，数组里有正数和负数，数组中一个或者连续多个整数组成一个子数组，求所有子数组的和的最大值，时间复杂度为O(n)
 * @Author: daihong
 * @Date: Created in  2018/8/16
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 10, -4, 7, 2, -5};
        //maxChildAdd(arr);
        maxChild(arr);
    }

    public static void maxChildAdd(int[] arr) {
        int brr[] = new int[arr.length];
        int k = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            count = 0;
            while (j<arr.length){
                if(arr[i]<0){
                   brr[k++] = arr[i];
                   break;
                }else if(arr[i]>0&&arr[j]>0){
                    count = count+arr[j];
                }else if(arr[j]<0){
                    i = j;
                    brr[k++] = arr[j];
                    break;
                }
                j++;
            }
            brr[k++] = count;
        }
        int sum = 0;
        for(int i=0;i<k-1;i++){
            int j = i;
            while (j<k-1){
                if(brr[j+1]+brr[j]<0){
                    i = i+1;
                    sum = 0;
                    break;
                }else {
                    sum = sum+(brr[j+1]+brr[j]);
                    i = i+1;
                    break;
                }
            }
        }
        sum = sum-brr[k-2];
        System.out.println(sum);

    }

    public static void maxChild(int[] arr){
        int sum = arr[0];
        int temp = sum;
        for(int i=0;i<arr.length;i++){
            if(sum<=0)
                sum = arr[i];
            else{
                sum+=arr[i];
            }
            if(sum>temp)
                temp = sum;
        }
        System.out.println(temp);
    }
}
