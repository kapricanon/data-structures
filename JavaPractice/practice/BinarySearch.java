package practice;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(Arrays.toString(binarySearch(new int[] {0,1,2,3,4,5,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,49,70}, 0)));
    }

    public static int[] binarySearch(int searchList[], int value) {

        int arrayPath[] = new int[30];
        int low = 0;
        int idx = 0;
        int high = searchList.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            System.out.println(mid);
            arrayPath[idx++] = searchList[mid];

            if (searchList[mid] == value) {
                return arrayPath;
            }

            if (searchList[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return arrayPath;

    }


}