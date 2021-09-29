package Node;

import org.w3c.dom.Node;

public class NodeTest {

     static class Nodes{
     int data;
     Nodes next;

    public Nodes(int data){
        this.data = data;
        this.next = null;
    }
}

    public Nodes head = null;
    public Nodes tail = null;


    public void addAtEnd (int data){
        Nodes newNode = new Nodes(data);

        if(head == null){
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void addAtStart(int data){
        Nodes newNode = new Nodes(data);

        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            Nodes temp = head;
            head = newNode;

            head.next = temp;
        }
    }

    public void removeFromStart (){
        if(head == null){
            System.out.println("Empty list");
        }
        else {
            if(head != tail){
                head = head.next;
            }
            else {
                head = tail = null;
            }
        }
    }
    static Nodes GetNode(int data){
        return new Nodes(data);
    }

    static Nodes insertRandom (Nodes headNode, int data, int pos){
        Nodes head = headNode;

        if(pos<1){
            System.out.println("Invalid position");
        }
        if(pos == 1){
            Nodes newNode = new Nodes(data);
            newNode.next = headNode;
            head = newNode;
        } else {
            while(pos-- != 0){
                if(pos == 1){
                    Nodes newNode = GetNode(data);

                    newNode.next = headNode.next;

                    headNode.next = newNode;
                    break;
                }
                headNode = headNode.next;
            }
            if(pos != 1){
                System.out.print("Position out of range");
            }

        }
        return head;
    }

    public void display (){
        Nodes current = head;
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        while (current!= null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    static void Printlist (Nodes node){
        while(node != null){
            System.out.print(node.data);
            node = node.next;
            if(node != null){
                System.out.print(",");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NodeTest sList = new NodeTest();

        sList.addAtEnd(1);
        sList.addAtEnd(3);
        sList.addAtEnd(5);
        sList.addAtEnd(6);

        sList.addAtStart(2);
        sList.addAtStart(11);

        sList.display();

        sList.removeFromStart();
        sList.display();

        Nodes head = GetNode(3);
        head.next = GetNode(4);
        head.next.next = GetNode(5);
        head.next.next.next = GetNode(7);
        Printlist(head);
        insertRandom(head, 29, 2);
        Printlist(head);
    }

}
