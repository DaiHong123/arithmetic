package fortieth_frist;

import java.util.HashMap;

/**
 * @Description: 正数序列
 * @Author: daihong
 * @Date: Created in  2018/8/18
 */
public class Test {
    public static void main(String[] args){
        int[] arr = {1,4,7,11,15};
        sortCode(arr,0,arr.length-1,15);
    }
    public static void sortCode(int[]arr,int left,int right,int n){
        if(left==right)
            return;
        int begin=left;
        int end=right;
        if(begin<end){
            if(arr[end]+arr[begin]==n){
                System.out.println(arr[begin]+"+"+arr[end]+"="+n);
                return;
            }else if(arr[end]+arr[begin]<n){
                begin++;
            }else{
                end--;
            }
        }
        sortCode(arr,begin,end,n);
    }
    public static void sort(int[]arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        int[]b=new int[2];
        sortCode(arr,0,arr.length-1,15,b);
        System.out.println(b[0]+":"+b[1]);
    }

    public static void sortCode(int[]arr,int left,int right,
                             int n,int[]b){
        if(left==right)
            return;
        int begin=left;
        int end=right;
        if(begin<end){
            if(arr[end]+arr[begin]==n){
                if(b[0]==0&&b[1]==0){
                    b[0]=arr[begin];
                    b[1]=arr[end];
                }else{
                    if((b[0]*b[1])>(arr[begin]*arr[end])){
                        b[0]=arr[begin];
                        b[1]=arr[end];
                    }
                }
                end--;
                begin++;
            }else if(arr[end]+arr[begin]<n){
                begin++;
            }else{
                end--;
            }

        }
        sortCode(arr,begin,end,n,b);

    }

}

