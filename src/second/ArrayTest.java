package second;

/**
 * @Author: daihong
 * @Date: $date$
 */
public class ArrayTest {
    public int[] array(int[] a, int[] b, int n) {
       for(int i=n-1,j=b.length-1,k=n+b.length-1;k>=0;k--){
           if(i>=0 &&(j<0||a[i]>=b[j])){
               a[k] = a[i--];
           }else {
               a[k] = b[j--];
           }
       }
        return a;
    }

    public static void main(String[] args) {
        int a[] = new int[10];
        int[] b = {2, 4, 7,8};
        int n = 3;
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        ArrayTest arrayTest = new ArrayTest();
        int[] c = arrayTest.array(a, b, n);
        for (int i = 0; i < n+b.length; i++) {
            System.out.println(c[i]);
        }
    }
}
