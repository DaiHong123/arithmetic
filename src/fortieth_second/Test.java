package fortieth_second;

/**
 * @Description: 倒序输出
 * @Author: daihong
 * @Date: Created in  2018/8/18
 */
public class Test {
    public static void main(String[] args){
        String str = "I am a student.";
        sort(str);
        String str1 = "XYZabcd";
        sort(str1,3);
    }
    public static void sort(String str){
        String[]strings=str.split("");
        for(int i=strings.length-1;i>=0;i--){
            if(i>0)
                System.out.print(strings[i]+"");
            else
                System.out.print(strings[i]);
        }
    }
    public static void sort(String str,int n){
        System.out.println(str.substring(3)+str.substring(0,3));
    }
}
