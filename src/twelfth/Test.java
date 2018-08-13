package twelfth;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
    public static double add(double base,int exponent){
        if(base==0&&exponent<0){
            try {
                throw new Exception("不能两个同时出现base=0和exponent<0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        double l = 1;
        int modulus = Math.abs(exponent);
            for(int i=0;i<modulus;i++){
                l =  l*base;
            }
        return (exponent>0)?l:1/l;
    }
    public static void main(String[] args){
        int exponent = 2;
        double base = 2;
            System.out.println(add(base,exponent));

    }
}
