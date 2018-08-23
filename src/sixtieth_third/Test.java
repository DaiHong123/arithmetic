package sixtieth_third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description: 一个数据流的中位数
 * @Author: daihong
 * @Date: Created in  2018/8/23
 */
public class Test {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args){
        /*ss(1);
        ss(2);
        ss(4);
        ss(3);
        if(arrayList.size()%2==1){
            System.out.println(arrayList.get((arrayList.size()/2)));
        }else {
            double sum = arrayList.get(arrayList.size()/2)+arrayList.get(arrayList.size()/2-1);
            sum = sum/2;
            System.out.println(sum);
        }*/
        insert(1);
        insert(2);
        insert(4);
        insert(3);
        System.out.println(getMedian());
    }
    public static void ss(int index){
       int[] arr = new int[arrayList.size()+1];
       if(arr.length==1){
           arr[0] = index;
       }else {
           for (int i=0;i<arr.length-1;i++){
               arr[i] = arrayList.get(i);
           }
           for (int i=0;i<arr.length-1;i++){
               if (arr[i]>index){
                   arr[i+1] = arr[i];
                   arr[i] = index;
               } else if(i==arr.length-2){
                   arr[arr.length-1] = index;
               }
           }
       }
       arrayList.removeAll(arrayList);
       for (int i=0;i<arr.length;i++){
           arrayList.add(arr[i]);
       }
    }

    /**
     Java的PriorityQueue 是从JDK1.5开始提供的新的数据结构接口，默认内部是自然排序，结果为小顶堆，也可以自定义排序器，
     比如下面反转比较，完成大顶堆。
     思路：
     为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
     1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
     2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
     用两个堆保存数据，保持两个堆的数据保持平衡（元素个数相差不超过1）大顶堆存放的数据要比小顶堆的数据小当两个堆中元素为
     偶数个，将新加入元素加入到大顶堆，如果要加入的数据，比小顶堆的最小元素大，先将该元素插入小顶堆，然后将小顶堆的最小元
     素插入到大顶堆。当两个推中元素为奇数个，将新加入元素加入到小顶堆，如果要加入的数据，比大顶堆的最大元素小，先将该元素
     插入大顶堆，然后将大顶堆的最大元素插入到小顶堆。
     */
    static int count = 0;
    static PriorityQueue<Integer> minheap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxheap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    public static void insert(Integer num){
        count++;
        if ((count&1)==0){
            if (!maxheap.isEmpty()&&num<maxheap.peek()){
                maxheap.offer(num);
                num = maxheap.poll();
            }
            minheap.offer(num);
        }else {
            if (!minheap.isEmpty()&&num>minheap.peek()){
                minheap.offer(num);
                num = minheap.poll();
            }
            maxheap.offer(num);
        }
    }
    public static Double getMedian(){
        if (count==0) {
            throw new RuntimeException("非法字符");
        }
            double median = 0;
            if ((count&1)==1){
                median = maxheap.peek();
            }else {
                median = (maxheap.peek()+minheap.peek())/2;
            }
        return median;
    }
}
