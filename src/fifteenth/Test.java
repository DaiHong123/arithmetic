package fifteenth;

import java.util.LinkedList;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
        public static Node select(Node node,int k){
            if(node==null||k<0) return null;
            Node aNode = node;
            Node bNode = null;
            for(int i=0;i<k-1;i++){
                if(aNode.next==null){
                return null;
            }
                aNode = aNode.next;
            }
            bNode = node;
            while (aNode.next!=null){
                aNode = aNode.next;
                bNode = bNode.next;
            }
            return bNode;
    }
    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        Node node = select(node1,2);
        System.out.println(node.element);
    }

public Node ReverseList(Node head){
    if(head==null) return null;
    Node pre = null;
    Node next = null;
    while (head!=null){
        next = head.next;
        head.next = pre;
        pre = head;
        head = next;
    }
    return pre;
}
    static class Node{
        Node next;
        int element;
        Node(int element){
            this.next = null;
            this.element = element;
        }
    }

}
