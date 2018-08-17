package thirtieth_fifth;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description: 查找第一次只出现一次的字符
 * @Author: daihong
 * @Date: Created in  2018/8/17
 */
public class Test {
    public static void main(String[] args){
        String str = "abcdcda";
        sort(str);
    }

    public static void sort(String str){
        char[] chars = str.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 1;
        int flag = 0;
        for(int j=0;j<chars.length;j++){
            count = 1;
            if(map.get(chars[j])==null){
                map.put(chars[j],count);
            }else {
                count++;
                map.put(chars[j],count);
            }
        }
        Iterator<Map.Entry<Character,Integer>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Character,Integer> entry = it.next();
            if (entry.getValue().equals(1)){
                System.out.println(entry.getKey());
                flag = 1;
                break;
            }
        }
        if(flag ==0){
            System.out.println("-1");
        }
    }
}
