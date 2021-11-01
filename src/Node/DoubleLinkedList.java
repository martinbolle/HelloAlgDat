package Node;

public class DoubleLinkedList {

    public static void main(String[] args) {
        DoubleLinkedList values = new DoubleLinkedList();

        values.add_First(3);
        values.print();
        //Forventer utskrift: 3,
        values.add_First(7);
        values.add_First(1);
        values.print();
    }
    /**
     * Representasjon av en node i en dobbelt
     * lenket liste
     */
    public static class Node {
        int value;      //Verdien vi vil lagre. burde brukt generics.
        Node next;      //Peker til neste node eller null
        Node prev;      //Peker til forrige node eller null



        Node(int verdi){
            this.value = verdi;
            this.next = null;
            this.prev = null;
        }
        Node(int value, Node prev, Node next){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

    }
    Node head;  //Peker til første node i den lenkede listen
    Node tail;  //Peker til siste node i den lenkede lsiten.
    int num_values; //Antall verdier i den lenkede listen.

    /**
     * Konstruktør
     */
    DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.num_values = 0;
    }

    public void print(){
        //Alternativ 1: skriv som forløkke
        // [0, num_values)
        Node p = head;
        for(int i = 0; i<num_values; i++){
            System.out.print(p.value + ", ");
            p = p.next;
        }
        System.out.println();

        //Alternativ 2: skriv som while-løkke
        Node q = head;
        while(q != null){
            System.out.print(q.value + ", ");
            q = q.next;
        }
        System.out.println();
    }


        /**
         * Add funskojn - legger til ved hode, altså først
         * Returnerer antall verdier vi har i lsiten etter innlegging
         */
        int add_First(int value){
            Node p = new Node(value);

            //Spesialtilfelle: Vi har en tom liste
            //Head == null
            //tail == null;
            if( (head == null) && (tail == null) ){
                //If (nums_values == 0) - samme måte å skrive på
                head = p;
                tail = p;
                num_values +=1;
            }
            //Generelt tilfelle: vi har noder allerede
            //i listen vår
            else {

                Node q = head;
                head = p;
                q.prev = p;
                p.next = q;
                num_values+=1;
            }

            return num_values;
        }

    /**
     * Add funksjon - legger til ved tail, sist i listen
     */
    int add_Last(int value){
        Node q = new Node(value);

        if( (head == null) && (tail == null)){
            head = q;
            tail = q;
            num_values+=1;
        } else {
            Node p = tail;
            tail = q;
            q.prev = p;
            p.next = q;
            num_values+=1;
        }
        return num_values;

    }

    /**
     * insert funksjon
     * Legger til ny node med index "pos"
     */
        void insert(int value, int pos){
            if(pos == 0){
                //Spesialtilfelle
                add_First(value);
            }
            if(value == num_values){
                //spesialtilfelle
                add_Last(value);
            }

            Node q = new Node(value);

            //Finn de nodene vi skal sette inn p mellom,
            // slik at vi få p - q - r i listen vår.
            Node r = head;
            for (int i = 0; i<pos; i++){
                r = r.next;
            }
            Node p = r.prev;

            p.next = q;
            q.next = r;
            q.prev = p;
            r.prev = q;
        }

}
