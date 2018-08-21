package fiftieth;


import sixth.Binary;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: 求两个节点的公共最低父节点。
 * @Author: daihong
 * @Date: Created in  2018/8/21
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

    public static BinaryTreeNode binaryTree = null;

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
        int n = 7, m = 7;
        //sort(binaryTreeNode1, n, m);
        //System.out.println(common(binaryTreeNode1, n, m));
        /*normal(binaryTreeNode1, n, m);*/
        BinaryTreeNode lowestCommon = getLowestCommon(binaryTreeNode1, binaryTreeNode4, binaryTreeNode5);
        System.out.println(lowestCommon.element);
    }

    /**
     * 它是一个二叉搜索树
     */
    public static void sort(BinaryTreeNode binaryTreeNode, int n, int m) {
        if (binaryTreeNode == null) {
            System.out.println("没有该树");
            return;
        }
        if (n < binaryTreeNode.element && m > binaryTreeNode.element) {
            System.out.println(binaryTreeNode.element);
            return;
        }
        if (n == binaryTreeNode.element || m == binaryTreeNode.element) {
            System.out.println("不存在");
            return;
        }
        while (binaryTreeNode != null) {
            if (m < binaryTreeNode.element) {
                binaryTreeNode = binaryTreeNode.left;
            } else if (n > binaryTreeNode.element) {
                binaryTreeNode = binaryTreeNode.right;
            } else if (n < binaryTreeNode.element && m > binaryTreeNode.element) {
                System.out.println(binaryTreeNode.element);
                return;
            }
        }
    }

    /**
     * 他只是一个普通的二叉树并且有一个父指针
     */
    public static int common(BinaryTreeNode binaryTreeNode, int n, int m) {
        int key = 0;
        Queue<BinaryTreeNode> linkedList1 = new ArrayDeque<>();
        Queue<BinaryTreeNode> linkedList2 = new ArrayDeque<>();
        select(binaryTreeNode, n);
        BinaryTreeNode binaryTreeNode1 = binaryTree;
        while (binaryTreeNode1 != null) {
            linkedList1.add(binaryTreeNode1);
            binaryTreeNode1 = binaryTreeNode1.parent;
        }
        select(binaryTreeNode, m);
        binaryTreeNode1 = binaryTree;
        while (binaryTreeNode1 != null) {
            linkedList2.add(binaryTreeNode1);
            binaryTreeNode1 = binaryTreeNode1.parent;
        }
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();

        while (linkedList1.size() != 0) {
            stack1.push(linkedList1.poll());
        }
        while (linkedList2.size() != 0) {
            stack2.push(linkedList2.poll());
        }
        while (stack1.size() != 0 && stack2.size() != 0) {
            if (stack1.peek().element == stack2.peek().element) {
                key = stack1.peek().element;
            }
            stack1.pop();
            stack2.pop();
        }
        return key;
    }

    public static void select(BinaryTreeNode binaryTreeNode, int key) {
        if (binaryTreeNode == null) return;
        if (binaryTreeNode.element == key) {
            binaryTree = binaryTreeNode;
            return;
        }
        select(binaryTreeNode.left, key);
        select(binaryTreeNode.right, key);
    }

    static class LinkNode {
        int element;
        LinkNode next;

        LinkNode(int element) {
            this.element = element;
            this.next = null;
        }
    }

    /**
     * 普通二叉树和没有父指针
     */
    public static void normal(BinaryTreeNode binaryTreeNode, int n, int m) {
        /*LinkNode linkNode1 = new LinkNode(0);
        LinkNode linkNode11 = linkNode1;
        LinkNode linkNode ;
        BinaryTreeNode binaryTreeNode1 = binaryTreeNode;
        BinaryTreeNode binaryTreeNode11 = null;
        LinkNode linkNode111;
        while (binaryTreeNode1 != null) {
            linkNode = new LinkNode(0);
            linkNode.element = binaryTreeNode1.element;
            linkNode1.next = linkNode;
            if (binaryTreeNode1.left==null) {
                linkNode111 = linkNode11;
                linkNode111 = linkNode111.next;
                System.out.println(linkNode111.element);
            }
            binaryTreeNode1 = binaryTreeNode1.left;
            linkNode1 = linkNode1.next;

        }*/
        LinkedList<BinaryTreeNode> linkedList1 = new LinkedList<>();
        BinaryTreeNode b1 = binaryTreeNode;
        while (b1 != null) {
            while (b1 != null) {
                linkedList1.push(b1);
                if (b1.element == n) {
                    break;
                }
                b1 = b1.left;

            }
            linkedList1.forEach(name -> System.out.println(name.element));
            if (linkedList1.getLast().element != n) {
                linkedList1.removeFirst();
                BinaryTreeNode binaryTreeNode1 = linkedList1.getFirst();
                binaryTreeNode1 = binaryTreeNode1.right;
                while (binaryTreeNode1 != null) {
                    linkedList1.push(binaryTreeNode1);
                    if (binaryTreeNode1.element == n) {
                        break;
                    }
                    binaryTreeNode1 = binaryTreeNode1.right;

                }
            }
            linkedList1.forEach(name -> System.out.println(name.element));
        }
        if (linkedList1.getLast().element != n) {
            linkedList1.removeLast();
        }
        /*select(binaryTreeNode, linkedList1.getLast().element);
        BinaryTreeNode b11 = binaryTree;
        while (b11 != null) {
            if (b11.right != null) {
                linkedList1.add(b11.right);
            }
            if (b11.element == n) {
                break;
            }
            //System.out.println(b11.element);
            b11 = b11.right;
        }
        linkedList1.forEach(name -> System.out.println(name.element));*/
    }

    public static BinaryTreeNode getLowestCommon(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        Stack<BinaryTreeNode> path1 = new Stack<>();
        Boolean flag1 = getThePath(root, node1, path1);
        if (!flag1) {
            return null;
        }
        Stack<BinaryTreeNode> path2 = new Stack<>();
        Boolean flag2 = getThePath(root, node2, path2);
        if (!flag2) {
            return null;
        }
        if (path1.size() > path2.size()) {
            while (path1.size() != path2.size()) {
                path1.pop();
            }
        } else {
            while (path1.size() != path2.size()) {
                path2.pop();
            }
        }
        if(path1==path2){
            path1.pop();
            return path1.pop();
        }else {
            BinaryTreeNode p = path1.pop();
            BinaryTreeNode q = path2.pop();
            while (q!=p){
                p = path1.pop();
                q = path2.pop();
            }
            return p;
        }
    }

    public static Boolean getThePath(BinaryTreeNode root, BinaryTreeNode node, Stack<BinaryTreeNode> path) {
        path.push(root);
        if (root == node) {
            return true;
        }
        boolean found = false;
        if (root.left != null) {
            found = getThePath(root.left, node, path);
        }
        if (!found&&root.right != null) {
            found = getThePath(root.right, node, path);
        }
        if (!found) {
            path.pop();
        }
        return found;
    }
}
