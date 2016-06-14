/**
 * Created by mohaowen on 11/1/15.
 */

import java.util.LinkedList;
import java.util.List;


/*
*  ���ܣ���һ�������ֵ����������У�Ȼ��������ַ�ʽ�ı���
*/
public class BinaryTree {
    private int[] arry = {1,2,3,4,5,6,7,8,9};
    private static List<Node> nodeList = null;

    //�ڲ��࣬�ڵ�
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
        //��һ�������ֵ����ת��ΪNode�ڵ�
        for(int nodeIndex = 0; nodeIndex < arry.length; nodeIndex++){
            nodeList.add(new Node(arry[nodeIndex]));
        }
        //��ǰlastParentIndex-1 �����ڵ㰴�ո��ڵ��뺢�ӽڵ�����ֹ�ϵ����������
        for(int parentIndex = 0; parentIndex < arry.length/2 - 1; parentIndex++){
            //����
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
            //�Һ���
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
        }
        //���һ�����ڵ㣺��Ϊ���һ�����ڵ����û���Һ��ӣ����Ե�������
        int lastParentIndex = arry.length /2 - 1;
        //����
        nodeList.get(lastParentIndex).leftChild = nodeList.get(lastParentIndex *2 + 1);
        //�Һ��ӣ��������ĳ���Ϊ�����Ž����Һ���
        if(arry.length % 2 == 1){
            nodeList.get(lastParentIndex).rightChild = nodeList.get(lastParentIndex *2 + 2);
        }
    }

    /*
    *�������
    */
    public static void preOrder(Node node){
        if(node == null)  return;
        System.out.print(node.data + " ");
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    /*
    *�������
    */
    public static void inOrder(Node node){
        if(node == null) return;
        inOrder(node.leftChild);
        System.out.print(node.data + " ");
        inOrder(node.rightChild);
    }

    /*
    *�������
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
        //nodeList�е�0����������ֵΪ�����
        Node root = nodeList.get(0);

        System.out.println("��������� ");
        preOrder(root);
        System.out.println();

        System.out.println("��������� ");
        inOrder(root);
        System.out.println();

        System.out.println("��������� ");
        postOrder(root);
        System.out.println();
    }



}













