package thirtieth_nigth;

import sixth.Binary;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 树的深度
 * @Author: daihong
 * @Date: Created in  2018/8/17
 */
public class Test {
    static class BinaryTreeNode{
        int element;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode(int element){
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args){
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(8);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(6);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(10);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(9);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(11);
        BinaryTreeNode binaryTreeNode8 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(2);
        binaryTreeNode1.left = binaryTreeNode2;
        binaryTreeNode1.right = binaryTreeNode3;
        binaryTreeNode2.left = binaryTreeNode4;
        binaryTreeNode2.right = binaryTreeNode5;
        binaryTreeNode3.left = binaryTreeNode6;
        binaryTreeNode3.right = binaryTreeNode7;
        binaryTreeNode4.left = binaryTreeNode8;
        binaryTreeNode8.left = binaryTreeNode9;
        System.out.println(depth(binaryTreeNode1));
    }
    public static int depth(BinaryTreeNode binaryTreeNode){
        if (binaryTreeNode==null){
            return 0;
        }
        int left = depth(binaryTreeNode.left);
       int right =  depth(binaryTreeNode.right);
        System.out.println("left"+left);
        System.out.println("right"+right);
       return (left>right)?(left+1):(right+1);
    }
}
