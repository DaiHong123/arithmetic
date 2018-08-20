package fortieth_nigth;

/**
 * @Description: 字符串转成整数
 * @Author: daihong
 * @Date: Created in  2018/8/20
 */
public class Test {
    public static void main(String[] args){
      String str = "";
        System.out.println(math(str));

    }
    public static int math(String str){
        if(str.length()<=0) return 0;
        char[] chars = str.toCharArray();
        int i=1;
        int sum=0;
        char first = chars[0];
            while (i<chars.length){
                        if(chars[i]<'0'||chars[i]>'9'){
                            return 0;
                        }else {
                            sum = sum+((chars[i]-'0')*(int)Math.pow(10,(chars.length-i-1)));
                        }
                        i++;

            }
       if(first=='-'){
            sum = 0-sum;
       }else if(first=='+'){
            sum = sum;
       }else if(first>='0'&&first<='9') {
            sum = (first-'0')*(int)Math.pow(10,(chars.length-1))+sum;
       }else {
                return 0;
       }
        return sum;
    }
}
