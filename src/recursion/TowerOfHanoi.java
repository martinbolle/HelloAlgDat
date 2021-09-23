package recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi(3);

    }

    /**
     * Lager en funksjon som kjører "Tower of hanoi"
     * ved hjelp av rekursive kall
     * @param num_pieces Antall brikker som skal brukes.
     */
    static void towerOfHanoi (int num_pieces) {
        hanoiMove(num_pieces,'A','C','B');
    }

    /**
     * Utfører et rekursivt flytt i Tower of hanoi.
     * @param piece_number Brikken vi skal flytte
     * @param from Stikken vi flytter fra. => "A"
     * @param to Stikken vi flytter til. => "C"
     * @param helper Hjelpestikken. => "B"
     */
    static void hanoiMove (int piece_number, char from, char to, char helper){

        //Vi slutter rekursjon når vi har kommet til øverste brikke.
        if(piece_number <0){
            return;
        }

        //Punkt 1; flytt alt fra stikke C over til stikke B.
        //      Bruk stikke A som hjelpestikke.
        hanoiMove(piece_number-1, from, helper, to);

        //punkt 2: Flytt øverste brukke fra A til C.
        //         Trenger ingen hjelpestikke - flyttes bare en brikke.
        System.out.println("Flytter " + piece_number + " " + from + "-" + to);

        //punkt 3: Flytt alt fra stikke B (fra punkt 1) over på stikke C.
        //         Bruke stikke A som hjelpestikke.
        hanoiMove(piece_number-1,helper, to, from);

    }
}
