package recursion;

public class RecursiveBinary {
    public static void main(String[] args) {
        int values [] = {1,2,4,8,17,19,22};

        System.out.println(binarySearch(19, values, 0, values.length));


    }

    static int binarySearch (int search_value, int [] values, int left, int right){
        int middle = (left+right) / 2;

        if (right - left == 0){
            if(values[middle] == search_value){
                return middle;
            } else {
                return -middle;
            }
        }
        if (values[middle] <= search_value){
            if (values[middle] == search_value){
                return middle;
            }
            return binarySearch(search_value, values, middle+1, right);
        }
        else {
            return binarySearch(search_value, values, left, middle-1);
        }
    }
}
