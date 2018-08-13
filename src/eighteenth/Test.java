package eighteenth;

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
    public static void main(String[] args){

    }
    public static BinaryTreeNode mirror(BinaryTreeNode treeNode){
        if (treeNode==null) return null;
        if(treeNode.right==null&&treeNode.left==null) return null;
        BinaryTreeNode temp = treeNode.right;
        treeNode.right = treeNode.left;
        treeNode.left = temp;
            if(treeNode.left!=null){
                return mirror(treeNode.left);
            }else {
                return  mirror(treeNode.right);
            }
    }
}
