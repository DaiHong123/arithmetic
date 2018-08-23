package sixtieth;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: 深度遍历二叉树
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
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(2);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);
        BinaryTreeNode binaryTreeNode6 = new BinaryTreeNode(6);
        BinaryTreeNode binaryTreeNode7 = new BinaryTreeNode(7);
        binaryTreeNode1.left = binaryTreeNode2;
        binaryTreeNode1.right = binaryTreeNode3;
        binaryTreeNode2.left = binaryTreeNode4;
        binaryTreeNode2.right = binaryTreeNode5;
        binaryTreeNode3.left = binaryTreeNode6;
        binaryTreeNode3.right = binaryTreeNode7;
        ArrayList<ArrayList<Integer>> print = print(binaryTreeNode1);
        print.forEach(name-> System.out.println(name));
    }
    public static ArrayList<ArrayList<Integer>> print(BinaryTreeNode binaryTreeNode){
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
       Queue<BinaryTreeNode> stack1 = new ArrayDeque<>();
        Queue<BinaryTreeNode> stack2 = new ArrayDeque<>();
        stack1.offer(binaryTreeNode);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack1.isEmpty()){
            BinaryTreeNode binaryTreeNode1 = stack1.poll();
            arrayList.add(binaryTreeNode1.element);
            if(binaryTreeNode1.left!=null){
                stack2.offer(binaryTreeNode1.left);
            }
            if (binaryTreeNode1.right!=null){
                stack2.offer(binaryTreeNode1.right);
            }
            if(stack1.isEmpty()){
                Queue<BinaryTreeNode> temp = stack1;
                stack1 = stack2;
                stack2 = temp;
                arrayLists.add(new ArrayList<>(arrayList));
                arrayList.clear();
            }
        }
        return arrayLists;
    }
}
