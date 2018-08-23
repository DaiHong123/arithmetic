package fifteenth_eighth;

import sixth.Binary;

import java.util.Stack;

/**
 * @Description: 镜像二叉树
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
        sort(binaryTreeNode1);
        BinaryTreeNode binaryTreeNode11 = new BinaryTreeNode(8);
        BinaryTreeNode binaryTreeNode21 = new BinaryTreeNode(10);
        BinaryTreeNode binaryTreeNode31 = new BinaryTreeNode(6);
        BinaryTreeNode binaryTreeNode41 = new BinaryTreeNode(11);
        BinaryTreeNode binaryTreeNode51 = new BinaryTreeNode(9);
        BinaryTreeNode binaryTreeNode61 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode71 = new BinaryTreeNode(5);
        binaryTreeNode11.left = binaryTreeNode21;
        binaryTreeNode11.right = binaryTreeNode31;
        binaryTreeNode21.left = binaryTreeNode41;
        binaryTreeNode21.right = binaryTreeNode51;
        binaryTreeNode31.left = binaryTreeNode61;
        binaryTreeNode31.right = binaryTreeNode71;
        //System.out.println(equal(binaryTreeNode1,binaryTreeNode11));
        System.out.println(sort(binaryTreeNode1, binaryTreeNode11));
    }

    public static void sort(BinaryTreeNode binaryTreeNode) {
        if (binaryTreeNode == null) return;
        BinaryTreeNode binaryTreeNode1 = binaryTreeNode.left;
        binaryTreeNode.left = binaryTreeNode.right;
        binaryTreeNode.right = binaryTreeNode1;
        sort(binaryTreeNode.left);
        sort(binaryTreeNode.right);
    }

    public static Boolean equal(BinaryTreeNode binaryTreeNode1, BinaryTreeNode binaryTreeNode2) {
        if (binaryTreeNode1 == null && binaryTreeNode2 == null) return true;
        if ((binaryTreeNode1 == null && binaryTreeNode2 != null) || (binaryTreeNode1 != null && binaryTreeNode2 == null))
            return false;
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        ss(binaryTreeNode1, stack1);
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        ss(binaryTreeNode2, stack2);
        Boolean flag = true;
        while (!stack1.empty() && !stack2.empty()) {
            if (stack1.pop().element != stack2.pop().element) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void ss(BinaryTreeNode binaryTreeNode, Stack<BinaryTreeNode> stack) {
        if (binaryTreeNode == null) return;
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        stack1.push(binaryTreeNode);
        while (binaryTreeNode != null || !stack1.empty()) {
            while (binaryTreeNode != null) {
                stack.push(binaryTreeNode);
                stack1.push(binaryTreeNode);
                binaryTreeNode = binaryTreeNode.left;
            }
            if (!stack1.empty()) {
                binaryTreeNode = stack1.pop();
                binaryTreeNode = binaryTreeNode.right;
            }
        }

    }

    public static Boolean sort(BinaryTreeNode binaryTreeNode1, BinaryTreeNode binaryTreeNode2) {
        if (binaryTreeNode1 == null && binaryTreeNode2 == null) return true;
        if ((binaryTreeNode1 == null && binaryTreeNode2 != null) || (binaryTreeNode1 != null && binaryTreeNode2 == null))
            return false;
        Boolean flag = false;
        if (binaryTreeNode1.element == binaryTreeNode2.element)
            flag = true;
        if(flag==false){
            return false;
        }
        Boolean flag1 = sort(binaryTreeNode1.left, binaryTreeNode2.left);
        Boolean flag2 = sort(binaryTreeNode1.right, binaryTreeNode2.right);
        if (flag1==false||flag2==false){
            return false;
        }
        return flag1 && flag2;
    }
}
