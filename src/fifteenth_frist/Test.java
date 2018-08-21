package fifteenth_frist;

/**
 * @Description: 不用除法
 * @Author: daihong
 * @Date: Created in  2018/8/21
 */
public class Test {
    public static void main(String[] args){
        int[] A = {1,2,3,4,5,6,7,8,9};
        multiply(A);
    }
    public static void multiply(int[] A){
        int[] B = new int[A.length];
        int n;
        int k=0;
        for (int i=0;i<A.length;i++){
            n=1;
            for (int j=0;j<A.length;j++){
                if(j!=i){
                    n = n*A[j];
                }
            }
            B[k++] = n;
        }
        for(int i=0;i<B.length;i++){
            System.out.println(B[i]);
        }
    }
}
