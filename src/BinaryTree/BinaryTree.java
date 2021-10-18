package BinaryTree;

import java.util.ArrayDeque;

public class BinaryTree {

    static class BinaryTreeNode{
        char value;
        BinaryTreeNode left_child;
        BinaryTreeNode right_child;

        BinaryTreeNode(char value){
            this.value = value;
            this.left_child = null;
            this.right_child = null;
        }

        BinaryTreeNode addLeftChild(char value){
            this.left_child = new BinaryTreeNode(value);
            return this.left_child;
        }
        BinaryTreeNode addRightChild(char value){
            this.right_child = new BinaryTreeNode(value);
            return this.right_child;
        }
    }

    static void printLevelOrder(BinaryTreeNode root){
        //Lager en kø
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();

        //Initialiserer første i køen - root noden
        queue.addLast(root);

        while(!queue.isEmpty()){
            // tar ut første fra køen.
            BinaryTreeNode current = queue.removeFirst();

            //Legg til current sine to barn til køen
            if(current.left_child!= null){
                queue.addLast(current.left_child);
            }
            if(current.right_child != null){
                queue.addLast(current.right_child);
            }

            //Skriv ut.
            System.out.println(current.value + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode('A');

        //Legg inn resterende noder
        BinaryTreeNode b = root.addLeftChild('B');
        BinaryTreeNode c = root.addRightChild('C');

        //Legg inn alle noder på nivå 2
        BinaryTreeNode d = b.addLeftChild('D');
        BinaryTreeNode e = b.addRightChild('E');

        BinaryTreeNode f = c.addLeftChild('F');
        BinaryTreeNode g = c.addRightChild('G');

        //Kaller funksjonen vår.
        printLevelOrder(root);
    }
}
