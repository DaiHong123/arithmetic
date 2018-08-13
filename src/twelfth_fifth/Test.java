package twelfth_fifth;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: $description$
 * @Param: $params$
 * @return: $returns$
 * @Author: daihong
 * @Date: $date$
 */
public class Test {
    static List<int[]> list = new ArrayList<>();
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
   public static void select(BinaryTreeNode treeNode,int key){
        if(treeNode.left==null&&treeNode.right==null&&treeNode.element==key) {

            return;
        }
        if(treeNode.element>key){
            return;
        }
        if(treeNode.element<key){

        }

   }
}
