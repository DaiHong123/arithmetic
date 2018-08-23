package fifteenth_seventh;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description: 给出中序遍历的的下一个节点
 * @Author: daihong
 * @Date: Created in  2018/8/22
 */
public class Test {
    static class BinaryTreeNode {
        int element;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;

        BinaryTreeNode(int element) {
            this.element = element;
            this.left = null;
            this.right = null;
            this.parent = null;
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
        binaryTreeNode2.parent = binaryTreeNode1;
        binaryTreeNode3.parent = binaryTreeNode1;
        binaryTreeNode4.parent = binaryTreeNode2;
        binaryTreeNode5.parent = binaryTreeNode2;
        binaryTreeNode6.parent = binaryTreeNode3;
        binaryTreeNode7.parent = binaryTreeNode3;
        //sort(binaryTreeNode1, binaryTreeNode4);
        BinaryTreeNode next = getNext(binaryTreeNode4);
        System.out.println(next.element);
    }

    public static void sort(BinaryTreeNode binaryTreeNode, BinaryTreeNode pattern) {
        if (binaryTreeNode == null) return;
        Stack<BinaryTreeNode> stack = new Stack<>();
        LinkedList<BinaryTreeNode> linkedList = new LinkedList<>();
        while (binaryTreeNode != null || !stack.empty()) {
            while (binaryTreeNode != null) {
                stack.push(binaryTreeNode);
                binaryTreeNode = binaryTreeNode.left;
            }
            if (!stack.empty()) {
                binaryTreeNode = stack.pop();
                linkedList.add(binaryTreeNode);
                binaryTreeNode = binaryTreeNode.right;
            }
        }
        for (int i = 0; i < linkedList.size(); i++) {
            if (i < linkedList.size() - 1 && pattern == linkedList.get(i)) {
                System.out.println(linkedList.get(i + 1).element);
                break;
            }
        }
    }

    public static BinaryTreeNode getNext(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) {
            return null;
        }
        if (binaryTreeNode.right!=null){
            binaryTreeNode = binaryTreeNode.right;
            while (binaryTreeNode.left!=null){
                binaryTreeNode = binaryTreeNode.left;
            }
            return binaryTreeNode;
        }
        while (binaryTreeNode.parent!=null){
            if (binaryTreeNode.parent.left==binaryTreeNode){
                return binaryTreeNode.parent;
            }
            binaryTreeNode = binaryTreeNode.parent;
        }
        return null;
    }
}
