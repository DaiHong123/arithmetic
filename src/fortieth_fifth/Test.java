package fortieth_fifth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description: 环形问题
 * @Author: daihong
 * @Date: Created in  2018/8/20
 */
public class Test {
    static class Link{
        int element;
        Link next;
        Link(int element){
            this.element = element;
            this.next = null;
        }
    }
    public static void main(String[] args){
        Link link1 = new Link(0);
        Link link2 = new Link(1);
        Link link3 = new Link(2);
        Link link4 = new Link(3);
        Link link5 = new Link(4);
        link1.next = link2;
        link2.next = link3;
        link3.next = link4;
        link4.next = link5;
        link5.next = link1;
        sort(link1,2);
        System.out.println(last(5,2));
    }
    public static void sort(Link link,int n){
        Link link1 = null;
        while (link!=null){
            for (int i=0;i<n-2;i++){
                link = link.next;
            }
            link1 = link.next;
            link.next = link1.next;
            if (link.element==link.next.element){
                System.out.println(link.element);
                break;
            }
            link = link.next;
        }

    }
    public static int last(int n,int m){
        if(n<1||m<1) return -1;
        int last = 0;
        for(int i=2;i<=n;i++){
            last = (last+m)%i;
        }
        return last;
    }
}
