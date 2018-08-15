package twelfth_fifth;

import java.util.*;

/**
 * 找出所有路径问题
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
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(10);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(7);
        BinaryTreeNode binaryTreeNode3 = new BinaryTreeNode(12);
        BinaryTreeNode binaryTreeNode4 = new BinaryTreeNode(4);
        BinaryTreeNode binaryTreeNode5 = new BinaryTreeNode(5);
        binaryTreeNode1.left = binaryTreeNode2;
        binaryTreeNode1.right = binaryTreeNode3;
        binaryTreeNode2.left = binaryTreeNode4;
        binaryTreeNode2.right = binaryTreeNode5;
        ArrayList<ArrayList<Integer>> select = select(binaryTreeNode1, 22);
        for (int i = 0; i < select.size(); i++) {
            ArrayList<Integer> arrayList = select.get(i);
            for (int j = 0; j < arrayList.size(); j++) {
                Integer integer = arrayList.get(j);
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> select(BinaryTreeNode treeNode, int key) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> curResult = new ArrayList<>();
        if (treeNode == null) return result;
        int curSum = 0;
        findPath(treeNode, key, curResult, result, curSum);
        return result;
    }

    public static void findPath(BinaryTreeNode treeNode, int key, ArrayList<Integer> curResult, ArrayList<ArrayList<Integer>> result, int curSum) {
        if (treeNode == null) return;
        Boolean isLeaf = (treeNode.left == null && treeNode.right == null);
        curSum += treeNode.element;
        if (isLeaf) {
            if (curSum == key) {
                curResult.add(treeNode.element);
                result.add(new ArrayList<Integer>(curResult));
                curResult.remove(curResult.size() - 1);
            }
            curSum = treeNode.element;
            return;

        }
        curResult.add(treeNode.element);
        findPath(treeNode.left, key, curResult, result, curSum);
        findPath(treeNode.right, key, curResult, result, curSum);
        curResult.remove(curResult.size() - 1);
    }
}
