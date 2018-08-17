package thirtieth_sixth;

/**
 * @Description: 逆序对
 * @Author: daihong
 * @Date: Created in  2018/8/17
 */
public class Test {
    public static void main(String[] args){
        int[] arr = {7,5,6,4};
        //sort(arr);
        System.out.println(helper(arr,arr.length));
    }
    public static void sort(int[] arr){
        int count = 0;
        for(int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static int helper(int[] arr,int length){
        if(arr==null||length<0){
            return 0;
        }
        int[] brr = new int[length];
        for (int i=0;i<length;i++){
            brr[i] = arr[i];
        }
        int count = helperCode(arr,brr,0,length-1);
        return count;
    }
    public static int helperCode(int[] arr,int[] brr,int start,int end){
        if(start==end){
            brr[start] = arr[start];
            return 0;
        }
        int length = (end-start)/2;
        int left = helperCode(brr,arr,start,start+length);
        int right = helperCode(brr,arr,start+left+1,end);
        int i = start+length;
        int j = end;
        int index = end;
        int count = 0;
        while (i>=start&&j>=start+length+1){
            if (arr[i]>arr[j]){
                brr[index--] = arr[i--];
                count +=j-start-length;
            }else {
                brr[index--] = arr[j--];
            }
        }
        for (;i>=start;--i){
            brr[index--] = arr[i];
        }
        for (;j>=start+length+1;--j){
            brr[index--] = arr[j];
        }
        return left+right+count;
    }
}
