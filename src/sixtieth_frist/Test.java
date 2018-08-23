package sixtieth_frist;

/**
 * @Description: 序列化与反序列化二叉树
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
    public static void main(String[] args){
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
       // System.out.println(serialize(binaryTreeNode1).toString());
        String str = serialize(binaryTreeNode1).toString();
        System.out.println(str);
        BinaryTreeNode deserialize = deserialize(str);
        sort(deserialize);
    }

    public static String serialize(BinaryTreeNode binaryTreeNode){
        StringBuffer sb = new StringBuffer();
        if (binaryTreeNode==null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(binaryTreeNode.element+",");
        sb.append(serialize(binaryTreeNode.left));
        sb.append(serialize(binaryTreeNode.right));
        return sb.toString();
    }
   static int index = -1;
    public static BinaryTreeNode deserialize(String strings){
        index++;
        int len = strings.length();
        if (index>=len){
            return null;
        }
        String[] str = strings.split(",");
        BinaryTreeNode binaryTreeNode = null;
        if (!str[index].equals("#")){
            binaryTreeNode = new BinaryTreeNode(Integer.valueOf(str[index]));
            binaryTreeNode.left = deserialize(strings);
            binaryTreeNode.right = deserialize(strings);
        }
        return binaryTreeNode;
    }
    public static void sort(BinaryTreeNode binaryTreeNode){
        if(binaryTreeNode==null) return;
        sort(binaryTreeNode.left);
        System.out.println(binaryTreeNode.element);
        sort(binaryTreeNode.right);
    }
}
