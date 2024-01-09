import java.util.Arrays;
public class ArrayOps {
    public static void main(String[] args) {
        //int[] array = {1, 2, 3, 4, 5};
        //System.out.println(findMissingInt(array));
        //System.out.println(secondMaxValue(array));
        //int[] array1 = {2, 2, 3, 7, 8, 3, 2};
        //int[] array2 = {8, 2, 7, 7, 3};
        //int[] array1 = {3, -4, 1, 2, 5};
        //int[] array2 = {1, 3, -4, 5};
        //System.out.println(containsTheSameElements(array1, array2));
        //int[] array2 = {1,3,2};
        //System.out.println(isSorted(array2));
    }
    
    public static int findMissingInt (int [] array) {
        int n = array.length;
        int missing = 999;
        for (int i = 0; i < n+1; i++){
            if (Arrays.binarySearch(array, i) < 0){
                missing = i;
                break;
            }
        }
        return missing;
    }

    public static int secondMaxValue(int [] array) {
        int max = array[0];
        int secondMax = max;
        for (int i = 1; i < array.length; i++){
            if (array[i] >= max){
                secondMax = max;
                max = array[i];
            } else {
                if (array[i] > secondMax){
                    secondMax = array[i];
                }
            }
        }
        return secondMax;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        boolean firstSearch = true;
        boolean secondSearch = true;
        boolean isInArray = false;
        for (int i = 0; i < array1.length; i++){
            isInArray = false;
            for (int j = 0; j < array2.length; j++){
                if (array1[i] == array2[j]){
                    isInArray = true;
                    break;
                }
            }
            if (!isInArray){
                firstSearch = false;
            }
        }

        for (int i = 0; i < array2.length; i++){
            isInArray = false;
            for (int j = 0; j < array1.length; j++){
                if (array2[i] == array1[j]){
                    isInArray = true;
                    break;
                }
            }
            if (!isInArray){
                secondSearch = false;
            }
        }
        return firstSearch && secondSearch;
    }

    public static boolean isSorted(int [] array) {
        boolean isSortedDec = true;
        boolean isSortedInc = true;
        if (array.length < 2){
            return isSortedDec || isSortedInc;
        } else {
            for (int i = 1; i < array.length; i++){
                if (array[i] < array[i - 1]){
                    isSortedInc = false;
                    break;
                }
            }
            for (int i = 1; i < array.length; i++){
                if (array[i] > array[i - 1]){
                    isSortedDec = false;
                    break;
                }
            }
        }
        return isSortedDec || isSortedInc;
    }

}
