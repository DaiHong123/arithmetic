package fifteenth_fourth;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: 只出现一次
 * @Author: daihong
 * @Date: Created in  2018/8/22
 */
public class Test {
    public static void main(String[] args){
        String str = "go";
        sort(str);
    }
    public static void sort(String str){
        char[] chars = str.toCharArray();
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<chars.length;i++){
            if (map.get(chars[i])==null){
                map.put(chars[i],1);
            }else {
                Integer integer = map.get(chars[i]);
                integer++;
                map.put(chars[i],integer);
            }
        }
        Iterator<Map.Entry<Character,Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character,Integer> it = iterator.next();
            if(it.getValue().equals(1)){
                System.out.println(it.getKey());
                break;
            }
        }
    }
}
