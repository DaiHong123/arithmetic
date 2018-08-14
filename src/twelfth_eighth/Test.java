package twelfth_eighth;

import java.util.*;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
    public static void main(String[] args){
        String str = "abcd";
        main(str);
    }
    /***
     * 输出指定字符的所有排列
     */
        public static void main(String str){
            //定义一个set集合，帮助去重
            Set<String> result=new TreeSet<>();
            //调用方法，进行组合
            sort(str.toCharArray(),0,result);
            //遍历集合，打印结果
            for(String s1:result){
                System.out.println(s1);
            }
        }

        //参数含义：ch是需要排序的参数；x是标签位，判断递归是否结束；set是结果集
        //排序思路，按照顺序，取出一个字符，放入末位。对剩下的字符进行相同操作
        //比如：abc，第一次取a，那么剩下的只有bc，第二次只能取b或者c，第三次就只能取一个。这就是一种排序。
        public static void sort(char[] ch,int x,Set set){
            //判断递归是否结束
            if(x==ch.length-1){
                set.add(String.valueOf(ch));
                return;
            }
            //取出一位，放入末尾，对剩下的进行递归操作，并且放入末尾的不参与递归
            for(int i=0;i<ch.length-x;i++){
                //将第i位取出与末位交换
                char tmp=ch[ch.length-x-1];
                ch[ch.length-x-1]=ch[i];
                ch[i]=tmp;
                sort(ch,x+1,set);
                //数据还原，准备下一次循环
                tmp=ch[ch.length-x-1];
                ch[ch.length-x-1]=ch[i];
                ch[i]=tmp;
            }
        }

}
