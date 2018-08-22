package fifteenth_sixth;

import java.util.*;

/**
 * @Description: 链表去除相同
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
        LinkNode linkNode2 = new LinkNode(2);
        LinkNode linkNode3 = new LinkNode(3);
        LinkNode linkNode4 = new LinkNode(5);
        LinkNode linkNode5 = new LinkNode(4);
        LinkNode linkNode6 = new LinkNode(4);
        LinkNode linkNode7 = new LinkNode(3);
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        linkNode5.next = linkNode6;
        linkNode6.next = linkNode7;
        LinkNode linkNode = deWeight(linkNode1);
        while (linkNode!=null){
            System.out.println(linkNode.element);
            linkNode = linkNode.next;
        }
        /*LinkNode linkNode = deleteDuplication(linkNode1);
        while (linkNode!=null){
            System.out.println(linkNode.element);
            linkNode = linkNode.next;
        }*/
    }
    public static LinkNode deWeight(LinkNode linkNode){
        LinkNode linkNode1 = linkNode;
        Map<Integer,Integer> map = new LinkedHashMap<>();
        while (linkNode1!=null){
            if(map.get(linkNode1.element)==null){
                map.put(linkNode1.element,1);
            }else if(map.get(linkNode1.element)!=null) {
                int i = map.get(linkNode1.element);
                i++;
                map.put(linkNode1.element,i);
            }
            linkNode1 = linkNode1.next;
        }
        Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
        Queue<Integer> queue = new PriorityQueue<>();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> it = iterator.next();
            if (it.getValue().equals(1)){
              queue.offer(it.getKey());
            }
        }
        LinkNode linkNode2 = new LinkNode(0);
        LinkNode linkNode4 = linkNode2;
       while (queue.size()!=0){
           LinkNode linkNode3 = new LinkNode(queue.poll());
           linkNode2.next = linkNode3;
           linkNode2 = linkNode2.next;
       }
       linkNode4 = linkNode4.next;
      return linkNode4;
    }
    public static LinkNode deleteDuplication(LinkNode linkNode){
        if (linkNode==null||linkNode.next==null){
            return linkNode;
        }
        if(linkNode.element==linkNode.next.element){
            LinkNode node = linkNode.next;
            while (node!=null&&node.element==linkNode.element){
                node = node.next;
            }
            return deleteDuplication(node);
        }else {
            linkNode.next = deleteDuplication(linkNode.next);
            return linkNode;
        }
    }
}
