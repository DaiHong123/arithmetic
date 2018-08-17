package twenty_third;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description: 打印树
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
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode8 = new BinaryTreeNode(8);
        BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(9);
        BinaryTreeNode binaryTreeNode10 = new BinaryTreeNode(10);
        BinaryTreeNode binaryTreeNode11 = new BinaryTreeNode(11);
        binaryTreeNode1.left = binaryTreeNode2;
        binaryTreeNode1.right = binaryTreeNode3;
        binaryTreeNode2.left = binaryTreeNode4;
        binaryTreeNode2.right = binaryTreeNode5;
        binaryTreeNode3.left = binaryTreeNode6;
        binaryTreeNode3.right = binaryTreeNode7;
        binaryTreeNode4.left = binaryTreeNode8;
        binaryTreeNode4.right = binaryTreeNode9;
        binaryTreeNode5.left = binaryTreeNode10;
        binaryTreeNode5.right = binaryTreeNode11;
        print(binaryTreeNode1);
    }

    public static void print(BinaryTreeNode treeNode) {
        if (treeNode == null) return;
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.offer(treeNode);
        while (queue.size()!=0) {
            if (queue.peek().left != null) {
                queue.offer(queue.peek().left);
            }
            if (queue.peek().right != null) {
                queue.offer(queue.peek().right);
            }
            System.out.println(queue.poll().element);
        }

    }
}
