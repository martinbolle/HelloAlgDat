package stack;

public class CircularBuffer {
    char [] buffer;
    int size;
    int head; // Peker til starten av køen
    int tail; // peker til slutten av køen.
    int count; // antall elementer som er i køen nå..

    CircularBuffer(int size){
        this.buffer = new char [size];
        this.size = size;
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    void pushBack(char value){
        if(count+1 > size){
            throw new IllegalArgumentException("for mange verdier");
        }
        this.buffer[tail] = value;
        tail = (tail+1) % size;
        count = count+1;
    }

    char popFront(){
        if(count<=0){
            throw new IndexOutOfBoundsException();
        }
        char retval = buffer[head];
        System.out.print(head);
        head = (head+1) % size;
        count = count - 1;
        return retval;

    }
    int count(){
        return count;
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(7);

        char[] values = "ABCDEFGHIJKLMNOPQRST".toCharArray();

        for(int i = 0; i<values.length; ){
            //Legger inn tre bokstaver i bufferet
            for(int j = 0; j<6; j++){
                if(values.length>i+j){
                    buffer.pushBack(values[i+j]);
                }
            }
            // Ta ut alt fra bufferet.
            while(buffer.count>0){
                System.out.print(buffer.popFront());
            }
            System.out.println();

            i = i+6;
        }
    }
}
