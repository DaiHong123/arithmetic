package thirtieth_seventh;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: 找链表的公共节点
 * @Author: daihong
 * @Date: Created in  2018/8/17
 */
public class Test {
    public static class Link{
        int element;
        Link next;
        Link(int element){
            this.element = element;
            this.next = null;
        }
    }
    public static void main(String[] args){
        Link link1 = new Link(1);
        Link link2 = new Link(2);
        Link link3 = new Link(3);
        Link link4 = new Link(4);
        Link link5 = new Link(5);
        Link link6 = new Link(6);
        Link link7 = new Link(7);
        link1.next = link2;
        link2.next = link3;
        link3.next = link6;
        link6.next = link7;
        link4.next = link5;
        link5.next = link6;
        sort(link1,link4);
    }
    public static void sort(Link aLink,Link bLink){
        if (aLink==null||bLink==null) return;
        Stack<Link> aStack = new Stack<>();
        Stack<Link> bStack = new Stack<>();
        Stack<Link> queue = new Stack<>();
        while (aLink!=null){
           aStack.push(aLink);
           aLink = aLink.next;
        }
        while (bLink!=null){
            bStack.push(bLink);
            bLink = bLink.next;
        }
        while (aStack.size()!=0&&bStack.size()!=0){
            if (aStack.peek()==bStack.peek()){
                queue.push(aStack.peek());
            }
            aStack.pop();
            bStack.pop();
        }
        while (queue.size()!=0){
            System.out.println("公共节点时："+queue.pop().element);
        }
    }
}
