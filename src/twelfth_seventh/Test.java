package twelfth_seventh;

import sixth.Binary;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
    static class BinaryTreeNode {
        int element;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(8);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(6);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(10);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(9);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(11);
        binaryTreeNode1.left = binaryTreeNode2;
        binaryTreeNode1.right = binaryTreeNode3;
        binaryTreeNode2.left = binaryTreeNode4;
        binaryTreeNode2.right = binaryTreeNode5;
        binaryTreeNode3.left = binaryTreeNode6;
        binaryTreeNode3.right = binaryTreeNode7;
        compile(binaryTreeNode1);
       /* BinaryTreeNode convent = convent(binaryTreeNode1);
        while (convent!=null){
            System.out.println(convent.element);
            convent = convent.left;
        }*/
    }

    public static BinaryTreeNode compile(BinaryTreeNode treeNode) {
        if (treeNode == null) return null;
        BinaryTreeNode list = null;
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        change(treeNode, queue);
        BinaryTreeNode k = null;
        BinaryTreeNode head = null;
        head = list = queue.poll() ;
        while (queue.size() != 0) {
            list.right = queue.peek();
            k = list;
            list.right.left = k;
            list = list.right;
            queue.poll();
        }
        return head;
    }

    public static void change(BinaryTreeNode treeNode, Queue<BinaryTreeNode> queue) {
        if (treeNode == null) return;
        change(treeNode.left, queue);
        queue.offer(treeNode);
        change(treeNode.right, queue);
    }


    /**
     * 正确答案
     */
    public static BinaryTreeNode convent(BinaryTreeNode treeNode) {
        BinaryTreeNode copyList = null;
        conventNode(treeNode, copyList);
        BinaryTreeNode head = copyList;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    public static void conventNode(BinaryTreeNode treeNode, BinaryTreeNode copyList) {
        if (treeNode == null) return;
        BinaryTreeNode p = treeNode;
        if (p.left != null) {
            conventNode(p.left, copyList);
        }
        p.left = copyList;
        if (copyList != null) {
            copyList.right = p;
        }
        copyList = p;
        if (p.right != null) {
            conventNode(p.right, copyList);
        }
    }
}
