package hashmap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap {
    public static void main(String[] args) {
        System.out.println("hashmap test");

        int hash_map_size = 7;
        ArrayList<LinkedList<String>> hash_map = new ArrayList<>(hash_map_size);

        for (int i = 0; i<hash_map_size; i++){
            hash_map.add(i, new LinkedList<>());
        }

        //Lager test-strenger
        String [] strings = new String[5];
        strings[0] = "Hei";
        strings[1] = "På deg din gamle sjokolade";
        strings[2] = "Peder";
        strings[3] = "Test";
        strings[4] = "Hallo";


        for (String string : strings) {
            int hash = hash(string);
            int hash_map_index = compute_hashmap_index(hash, hash_map_size);
            System.out.println("Legger inn " + string + " med hash " + hash + " på plass " + hash_map_index);
            hash_map.get(hash_map_index).addFirst(string);
        }


        int hash = hash("Test");
        int hash_map_index = compute_hashmap_index(hash, hash_map_size);
        System.out.println(hash_map.get(hash_map_index).toString());


    }

    static int compute_hashmap_index(int hash, int hash_map_size){
        return hash % hash_map_size;
    }

    static int hash(String data){
        int hash = 0;

        //sum av alle bokstavene (ikke optimalt).
        /*
        for (int i = 0; i<data.length(); i++){
            hash = hash + (int) data.charAt(i);
        }
         */

        for (int i = data.length()-1; i>= 0; i--){
            char c = data.charAt(i);
            hash = (hash + c)*31;
        }
        if(hash <0){
            hash = -hash;
        }
        return hash;
    }
}
