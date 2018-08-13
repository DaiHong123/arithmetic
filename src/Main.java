import Frist.Test01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
       /* Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1==i2);
        System.out.println("Hello World!");*/
       //int n = 10;
       int[][] arr = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        Test01 test01 = new Test01();
        System.out.println(test01.sure(arr,4));
        System.out.println(test01.sure1(arr,5));

    }

}
