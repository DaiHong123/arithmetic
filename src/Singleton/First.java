package Singleton;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class First {
    private static First first = null;
    private First(){};
    public static First getInstance(){

            if(first==null){
                synchronized (First.class){
                    first =  new First();
                }

            }
            return first;
    }
}
