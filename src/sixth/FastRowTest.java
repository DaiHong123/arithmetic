package sixth;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class FastRowTest {
   /* public static void sort(int[] arr,int left,int right){
        int begin = left;
        int end = right;
        int key = arr[left];
        if(begin>end){
            return;
        }
        while (begin<end){
            while (begin<end&&arr[end]>=key){
                end--;
            }
            if(arr[end]<=key){
                int temp = arr[end];
                arr[end] = arr[begin];
                arr[begin] = temp;
            }
            while (begin<end&&arr[begin]<=key){
                begin++;
            }
            if(arr[begin]>=key){
                int temp = arr[begin];
                arr[begin] = arr[end];
                arr[end] = temp;
            }
        }
        if(begin>left) sort(arr,left,begin-1);
        if(end<right) sort(arr,end+1,right);
    }*/
   public static void sort(int[] arr){
       int[] temps = new int[101];
       for(int i=0;i<temps.length;i++){
           for (int j=0;j<arr.length;j++){
               if(arr[j]==i){
                   ++temps[i];
               }
               if(arr[j]>100||arr[j]<=0){
                   try {
                       throw new Exception("超过了年龄");
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           }
       }
       for(int i=0;i<temps.length;i++){
           System.out.println(temps[i]);
       }
   }
    public static void main(String[] args){
        int[] arr = {6, 2, 2, 7, 9, 3, 4, 5, 100, 8};
       /* sort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }*/
        sort(arr);
    }
}
