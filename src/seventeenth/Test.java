package seventeenth;


import java.util.ArrayList;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
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
    public static Boolean equal(BinaryTreeNode aTreeNode,BinaryTreeNode bTreeNode){
        Boolean b = false;
        if(aTreeNode!=null&&bTreeNode!=null){
            if (aTreeNode.element==bTreeNode.element){
                b = check(aTreeNode,bTreeNode);
            }
            if (!b){
                b = equal(aTreeNode.left,bTreeNode);
            }
            if(!b){
                b = equal(aTreeNode.right,bTreeNode);
            }
        }
        return b;
    }
    public static Boolean check(BinaryTreeNode aTreeNode,BinaryTreeNode bTreeNode){
        if(bTreeNode==null) return true;
        if(aTreeNode==null) return false;
       if(aTreeNode.element!=bTreeNode.element) return false;
       return check(aTreeNode.left,bTreeNode.left)&&check(aTreeNode.right,bTreeNode.right);
    }
    public static void main(String[] args){
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(8);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(8);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(9);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode8 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode9 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode10 = new BinaryTreeNode(7);
        binaryTreeNode1.left = binaryTreeNode2;
        binaryTreeNode1.right = binaryTreeNode3;
        binaryTreeNode2.left = binaryTreeNode4;
        binaryTreeNode2.right = binaryTreeNode5;
        binaryTreeNode5.left = binaryTreeNode6;
        binaryTreeNode5.right = binaryTreeNode7;
        binaryTreeNode8.left = binaryTreeNode9;
        binaryTreeNode8.right = binaryTreeNode10;
        System.out.println(equal(binaryTreeNode1,binaryTreeNode8));
    }
}
