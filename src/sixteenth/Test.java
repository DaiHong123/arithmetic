package sixteenth;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
    public static Node add(Node aNode, Node bNode) {
        if (aNode == null) {
            return bNode;
        }
        if (bNode == null) {
            return aNode;
        }
        Node cNode = null;
            if (aNode.element <= bNode.element) {
                    cNode = aNode;
                    cNode.next = add(aNode.next,bNode);

            } else if (aNode.element > bNode.element) {
                    cNode = bNode;
                   cNode.next = add(aNode,bNode.next);

            }
        return cNode;
    }

    public static Node add1(Node aNode, Node bNode) {
        if (aNode == null) {
            return bNode;
        }
        if (bNode == null) {
            return aNode;
        }
        Node dNode = null;
        Node cNode = null;
        while (aNode!=null&&bNode!=null){
            if (aNode.element <= bNode.element) {
                if(dNode ==null){
                    dNode = cNode = aNode;
                }else {
                    cNode.next = aNode;
                    cNode = cNode.next;
                }
                aNode = aNode.next;
            } else  {
                if(dNode==null){
                    dNode = cNode = bNode;
                }else {
                    cNode.next = bNode;
                    cNode = cNode.next;
                }
                bNode = bNode.next;
            }
        }
       while (dNode!=null){
           System.out.println(dNode.element);
           dNode = dNode.next;
       }
       if(dNode==null){
           if(aNode==null)
           dNode = bNode;
           else
               dNode = aNode;
       }
       while (dNode!=null){
           System.out.println(dNode.element);
           dNode = dNode.next;
       }
        return null;
    }
    static class Node {
        int element;
        Node next;

        Node(int element) {
            this.element = element;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(5);
        Node node4 = new Node(7);
        Node node5 = new Node(2);
        Node node6 = new Node(4);
        Node node7 = new Node(6);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        //Node node = add(node1, node5);
       /* while (node!=null){
            System.out.println(node.element);
            node = node.next;
        }*/
        add1(node1,node5);
    }
}
