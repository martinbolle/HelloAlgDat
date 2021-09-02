package algdat21;

import static org.junit.jupiter.api.Assertions.*;

class MyFirstSortTest {

    @org.junit.jupiter.api.Test
    void myFirstSort() {
        int values[] = {1, 2, 7, 4, 6, 9};
        MyFirstSort.myFirstSort(values);
        int thruth[] = {9,7,6,4,2,1};
        assertArrayEquals(thruth, values);

    }

    @org.junit.jupiter.api.Test
    void findMax() {
        int values [] = {1, 2, 7, 4, 6, 9};
        int index = MyFirstSort.findMax(values, 0,values.length);

        assertEquals(5, index);
        assertEquals(9, values[index]);
    }
}