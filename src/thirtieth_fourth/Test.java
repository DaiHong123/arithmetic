package thirtieth_fourth;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 丑数只能被2或3或5整除的数，从1开始。
 * @Author: daihong
 * @Date: Created in  2018/8/16
 */
public class Test {
    public static void main(String[] args){
        //uglyNumber(14);
        System.out.println(GetUgly(14));
    }
    public static void uglyNumber(int n){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int j = 1;
        for (int i=2;;i++){
            int k = i;
            while (k%2==0||k%3==0||k%5==0){
                if(k%2==0){
                    k = k/2;
                }else if(k%3==0){
                    k = k/3;
                }else if(k%5==0){
                    k = k/5;
                }
                if(k==1){
                    list.add(i);
                    j++;
                }

            }
            if(j==n)
                break;
        }
        System.out.println(list.get(n-1));
    }

    public static Boolean isUgly(int n){
        while (n%2==0)
            n/=2;
        while (n%3==0)
            n/=3;
        while (n%5==0)
            n/=5;
        return (n==1)?true:false;
    }
    public static int GetUgly(int index){
        if(index<0)
            return 0;
        int number = 0;
        int ugly = 0;
        while (ugly<index){
            ++number;
            if (isUgly(number)){
                ++ugly;
            }
        }
        return number;
    }
}
