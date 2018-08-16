package twelfth_second;

/**
 * @Description: 求1到n个数有几个1
 * @Author: daihong
 * @Date: Created in  2018/8/16
 */
public class Test {
    public static void main(String[] args){
    /*    int n = 20;
        System.out.println(number(n));*/
    int n = 20;
        System.out.println(sort(n));
    }

    /**
     * 时间复杂度为O(n)
     * @param n
     * @return
     */
    public static int number(int n){
        int count = 0;
        for(int i=1;i<=n;i++){
            if (i<10){
                if(i==1){
                    count++;
                }
            }else {
                int k = i;
                while (k>=10){
                    if(k%10==1){
                        count++;
                    }
                    k = k/10;
                }
                if(k==1){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 时间复杂度为O(logn)
     * @param n
     * @return
     */
    public static int sort(int n){
        if(n<0){
            return 0;
        }
        StringBuilder s = new StringBuilder(((Integer)n).toString());
        return numbers(s);
    }
    public static int numbers(StringBuilder s){
        if(s==null||s.length()==0||s.charAt(0)<'0'||s.charAt(s.length()-1)>'9'){
            return 0;
        }
        int first = s.charAt(0)-'0';
        int length = s.length();
        if(length==1&&first==0){
            return 0;
        }
        if(length==1&&first>0){
            return 1;
        }
        int numFirst = 0;
        if(first>1){
            numFirst =power(length-1);
        }else if(first==1){
            numFirst = Integer.parseInt(s.substring(1))+1;
        }
        int numOther = first * (length-1)*power(length-2);
        int numRecursive = numbers(s.deleteCharAt(0));
        return numFirst+numOther+numRecursive;
    }
    public static int power(int n){
        int result = 1;
        for(int i=0;i<n;i++){
            result *=10;
        }
        return result;
    }
}
