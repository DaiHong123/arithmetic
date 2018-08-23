package sixtieth_second;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: 找出第k小的树
 * @Author: daihong
 * @Date: Created in  2018/8/23
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
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(8);
        binaryTreeNode1.left = binaryTreeNode2;
        binaryTreeNode1.right = binaryTreeNode3;
        binaryTreeNode2.left = binaryTreeNode4;
        binaryTreeNode2.right = binaryTreeNode5;
        binaryTreeNode3.left = binaryTreeNode6;
        binaryTreeNode3.right = binaryTreeNode7;
        sort(binaryTreeNode1,1,3);
    }
    public static void sort(BinaryTreeNode binaryTreeNode,int k,int key){
        Stack<BinaryTreeNode> queue = new Stack<>();
        while (binaryTreeNode!=null||!queue.empty()){
            while (binaryTreeNode!=null){
                queue.push(binaryTreeNode);
                binaryTreeNode = binaryTreeNode.left;
            }
            if(!queue.empty()){
                if(k==key)
                System.out.println(queue.peek().element);
                binaryTreeNode = queue.pop();
                binaryTreeNode = binaryTreeNode.right;
                k++;
            }
        }
    }
}
