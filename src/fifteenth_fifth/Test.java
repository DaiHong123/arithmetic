package fifteenth_fifth;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: 找出环形链表
 * @Author: daihong
 * @Date: Created in  2018/8/22
 */
public class Test {
    static class LinkNode{
        int element;
        LinkNode next;
        LinkNode(int element){
            this.element = element;
            this.next = null;
        }
    }
    public static void main(String[] args){
        LinkNode linkNode1 = new LinkNode(1);
        LinkNode linkNode2 = new LinkNode(3);
        LinkNode linkNode3 = new LinkNode(3);
        LinkNode linkNode4 = new LinkNode(4);
        LinkNode linkNode5 = new LinkNode(5);
        LinkNode linkNode6 = new LinkNode(6);
        LinkNode linkNode7 = new LinkNode(7);
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        linkNode5.next = linkNode6;
        linkNode6.next = linkNode7;
        linkNode7.next = linkNode3;
        sort(linkNode1);

    }
    public static void sort(LinkNode linkNode){
        Map<LinkNode,Integer> map = new LinkedHashMap<>();
        LinkNode linkNode1 = linkNode;
        while (linkNode1!=null){
            if(map.get(linkNode1)==null){
               map.put(linkNode1,1);
            }else if (map.get(linkNode1)==1){
                System.out.println(linkNode1.element);
                break;
            }
            linkNode1 = linkNode1.next;
        }
        if(linkNode1==null){
            System.out.println("null");
        }
    }



}
