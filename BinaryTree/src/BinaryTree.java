/**
 * Created by mohaowen on 11/1/15.
 */

import java.util.LinkedList;
import java.util.List;


/*
*  功能：把一个数组的值存入二叉树中，然后进行三种方式的遍历
*/
public class BinaryTree {
    private int[] arry = {1,2,3,4,5,6,7,8,9};
    private static List<Node> nodeList = null;

    //内部类，节点
    private class Node{
        Node leftChild;
        Node rightChild;
        int data;
        Node(int newdata){
            leftChild = null;
            rightChild = null;
            data = newdata;
        }
    }

    public void createBinTree(){
        nodeList = new LinkedList<Node>();
        //将一个数组的值依次转换为Node节点
        for(int nodeIndex = 0; nodeIndex < arry.length; nodeIndex++){
            nodeList.add(new Node(arry[nodeIndex]));
        }
        //对前lastParentIndex-1 个父节点按照父节点与孩子节点的数字关系建立二叉树
        for(int parentIndex = 0; parentIndex < arry.length/2 - 1; parentIndex++){
            //左孩子
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
            //右孩子
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
        }
        //最后一个父节点：因为最后一个父节点可能没有右孩子，所以单独处理
        int lastParentIndex = arry.length /2 - 1;
        //左孩子
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex *2 + 1);
        //右孩子，如果数组的长度为奇数才建立右孩子
        if(arry.length % 2 == 1){
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex *2 + 2);
        }
    }

    /*
    *先序遍历
    */
    public static void preOrder(Node node){
        if(node == null)  return;
        System.out.print(node.data + " ");
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    /*
    *中序遍历
    */
    public static void inOrder(Node node){
        if(node == null) return;
        inOrder(node.leftChild);
        System.out.print(node.data + " ");
        inOrder(node.rightChild);
    }

    /*
    *后序遍历
    */
    public static void postOrder(Node node){
        if(node == null) return;
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTree BTree = new BinaryTree();
        BTree.createBinTree();
        //nodeList中第0个索引处的值为根结点
        Node root = nodeList.get(0);

        System.out.println("先序遍历： ");
        preOrder(root);
        System.out.println();

        System.out.println("中序遍历： ");
        inOrder(root);
        System.out.println();

        System.out.println("后序遍历： ");
        postOrder(root);
        System.out.println();
    }



}













