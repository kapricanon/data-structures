package PrintBinaryNumbers;

public class App {
    public static void main(String[] args) {
       int n = 25;
        // O(1) memory to store number.
        int bin;
        // O(n) loop from 1 to n.
        for(int x = 1; x < n; x++) {
            bin = x;
            // O(log n) to print binary of n.
            while(bin > 0) {
            // O(1) runtime to print one binary digit.
            System.out.print(bin % 2);
            // O(1) runtime to perform integer division.
            bin = bin / 2; 
            }
        // O(1) to print new line.
        System.out.println();
        }
          
    }
}
