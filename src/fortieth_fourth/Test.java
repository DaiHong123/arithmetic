package fortieth_fourth;

/**
 * @Description: 牌的顺序
 * @Author: daihong
 * @Date: Created in  2018/8/20
 */
public class Test {
    public static void main(String[] args){
      int[] arr = {0,2,3,6,0};

        System.out.println(sort(arr));
    }
    public static Boolean sort(int[] arr){
        Boolean flag = true;
        for(int i=0;i<arr.length-1;i++){
            for (int k=i+1;k<arr.length;k++){
                if(arr[i]>=arr[k]){
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                }
            }
        }
        int[] brr = new int[2];
        int j=0;
        for (int i=0;i<arr.length-1;i++){
            if(arr[i]==0){
                brr[j++]=arr[i];
                arr[i] = arr[i+1];
            }
        }
        if (j==0){
           for(int i=0;i<arr.length-1;i++){
               if(arr[i+1]-arr[i]!=1){
                   flag = false;
                   break;
               }
           }
        }else if(j==1){
            int k = 0;
            for(int i=j;i<arr.length-1;i++){
                if(arr[i+1]-arr[i]==2){
                    k = i;
                    break;
                }
            }
            for (int i=j;i<arr.length-1;i++){
                if (i!=k){
                    if (arr[i+1]-arr[i]!=1){
                        flag = false;
                        break;
                    }
                }
            }
        }else if(j==2){
            int k1 = 0;
            int k2 = 0;
            if(arr[3]-arr[2]>3){
                flag = false;
            }else if(arr[4]-arr[3]>3){
                flag = false;
            }else if(arr[3]-arr[2]>1&&arr[4]-arr[3]>2){
                flag = false;
            }else if(arr[3]-arr[2]>2&&arr[4]-arr[3]>1){
                flag = false;
            }
        }
        return flag;
    }
}
