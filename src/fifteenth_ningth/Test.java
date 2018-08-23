package fifteenth_ningth;

import java.util.*;

/**
 * @Description: s形打印二叉树
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
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(3);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(2);
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
        //print(binaryTreeNode1);
        ArrayList<ArrayList<Integer>> arrayLists = printInfo(binaryTreeNode1);
        arrayLists.forEach(name-> System.out.println(name));
    }

    public static void print(BinaryTreeNode binaryTreeNode) {
        HashMap<BinaryTreeNode, Integer> map = new LinkedHashMap<>();
        sort(binaryTreeNode, map, 1);
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        queue.offer(binaryTreeNode);
        while (queue.size() != 0) {
            if (map.get(queue.peek()) % 2 == 1)
                System.out.println(queue.peek().element);
            if (map.get(queue.peek()) % 2 == 0) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
            } else if (map.get(queue.peek()) % 2 == 1) {
                if (queue.peek().left != null) {
                    stack.push(queue.peek().left);
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    stack.push(queue.peek().right);
                    queue.offer(queue.peek().right);
                }
                while (!stack.empty()) {
                    System.out.println(stack.peek().element);
                    stack.pop();
                }
            }
            queue.poll();
        }
    }

    public static void sort(BinaryTreeNode binaryTreeNode, HashMap<BinaryTreeNode, Integer> set, int k) {
        if (binaryTreeNode == null) return;
        sort(binaryTreeNode.left, set, k + 1);
        set.put(binaryTreeNode, k);
        sort(binaryTreeNode.right, set, k + 1);
    }


    public static ArrayList<ArrayList<Integer>> printInfo(BinaryTreeNode binaryTreeNode){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(binaryTreeNode==null) return null;
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.add(binaryTreeNode);
        int flag = 0;
        ArrayList<Integer> lay = new ArrayList<>();
        while (!stack1.empty()){
            BinaryTreeNode binaryTreeNode1 = stack1.pop();
            lay.add(binaryTreeNode1.element);
            if (flag==0){
                if (binaryTreeNode1.left!=null){
                    stack2.add(binaryTreeNode1.left);
                }
                if (binaryTreeNode1.right!=null){
                    stack2.add(binaryTreeNode1.right);
                }
            }else {
                if (binaryTreeNode1.right!=null){
                    stack2.add(binaryTreeNode1.right);
                }
                if (binaryTreeNode1.left!=null){
                    stack2.add(binaryTreeNode1.left);
                }
            }
            if (stack1.isEmpty()){
                Stack<BinaryTreeNode> tmp = stack1;
                stack1 = stack2;
                stack2 = tmp;
                flag = 1 - flag;
                ans.add(new ArrayList<>(lay));
                lay.clear();
            }
        }
        return ans;
    }
}
