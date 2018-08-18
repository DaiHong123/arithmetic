package fortieth;

import java.util.HashMap;

/**
 * @Description: 出现一次
 * @Author: daihong
 * @Date: Created in  2018/8/18
 */
public class Test {
    public static void main(String[] args){
        int[] arr = {2,2,3,3,4,5,6,6};
        sort(arr);
    }
    public static void sort(int[]arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i])==null){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        map.forEach((K,V)->{
            if(V.equals(1)){
                System.out.println(K);
            }
        });
    }
   // 采用异或运算
    public static void sort1(int[]arr){
        if(arr==null||arr.length<2){
            return;
        }
        int result=0;
        for(int i=0;i<arr.length;i++){
            result^=arr[i];
        }
        int index=Find(result);
        int num1,num2;
        num1=num2=0;
        for(int j=0;j<arr.length;j++){
            if(isBit(arr[j],index)){
                num1^=arr[j];
            }else{
                num2^=arr[j];
            }
        }
        System.out.println(num1+":"+num2);
    }
    public static int Find(int num){
        int indexBit=0;
        while((num&1)==0&&indexBit<Integer.SIZE){
            num=num>>1;
            ++indexBit;
        }
        return indexBit;
    }
    public static Boolean isBit(int num,int indexBit){
        num=num>>indexBit;
        return(num&1)==1?true:false;
    }

}
