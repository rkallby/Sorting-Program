//Written by:Riley Kalb
//Added function of either generating new numbers or use old ones.
import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;
import java.util.Arrays;
public class Sortingprogram {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int temp = 0;
        int[] array1       = new int[50000];
        int[] array2       = new int[50000];
        int[] array3       = new int[50000];
        int[] array1Sorted = new int[50000];
        int[] array2Sorted = new int[50000];
        int[] array3Sorted = new int[50000];
        int[] arrayOld1    = new int[50000];
        int[] arrayOld2    = new int[50000];
        int[] arrayOld3    = new int[50000];
        
        System.out.println("Want New Numbers? 1=Yes 0=No");
        temp = input.nextInt();
        
        if (temp == 0) {
            //This set of statements reads files and adds to arrays.
            System.out.println("Loading Previous File.....");
            Scanner scanner = new Scanner(new File("StorageX.txt"));
            int i = 0;
            while(scanner.hasNextInt()){
                arrayOld1[i++] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(arrayOld1));
            
            Scanner scanner2 = new Scanner(new File("StorageY.txt"));
            int x = 0;
            while(scanner2.hasNextInt()){
                arrayOld2[x++] = scanner2.nextInt();
            }
            System.out.println(Arrays.toString(arrayOld2));
            
            Scanner scanner3 = new Scanner(new File("StorageZ.txt"));
            int w = 0;
            while(scanner3.hasNextInt()){
                arrayOld3[w++] = scanner3.nextInt();
            }
            System.out.println(Arrays.toString(arrayOld3));
       
        }else {
            System.out.println("Creating the Numbers.....");
        
            for (int i = 0; i < 50000; i++) {
                array1[i] = i + 1;
                array2[i] = 50000 - i;
                array3[i] = (int)(Math.random() * 50000 + 1);
                System.out.println(array1[i] + "  " + array2[i] + " " + array3[i]);
            }
        
            System.out.println("Saving Numbers to File. . . . .");
            saveInventory("StorageX.txt", array1, array2, array3);
        }
        System.out.println("Initializing the Sorter......");
       
        if (temp == 1) {
            array1Sorted = doInsertionSort(array1);
            array2Sorted = doInsertionSort(array2);
            array3Sorted = doInsertionSort(array3);
        }else {
            array1Sorted = doInsertionSort(arrayOld1);
            array2Sorted = doInsertionSort(arrayOld2);
            array3Sorted = doInsertionSort(arrayOld3);
        }
        System.out.println("Below are the sorted arrays");
        System.out.println("Array Norm "  + Arrays.toString(array1Sorted));
        System.out.println("Array Rvrse " + Arrays.toString(array2Sorted));
        System.out.println("Array RND "   + Arrays.toString(array3Sorted));
    }
    
    public static int[] doInsertionSort(int[] input){
        long start = System.currentTimeMillis();
        int temp;
        int comparisons = 0;
        for (int i = 0; i < input.length; i++) {
            comparisons++;
            for(int j = i ; j > 0 ; j--){
                
                if(input[j] < input[j-1]){
                    comparisons++;
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        System.out.println("Number of Comparisons " + comparisons);
        long end = System.currentTimeMillis();
        System.out.println(((end - start) / 1000d) + "seconds");
        return input;
    }   
    
    public static void saveInventory(String FileName, int[] input,
        int[] input2, int[] input3) throws Exception {
        
        try (PrintStream X = new PrintStream("StorageX.txt")) {
            for (int z = 0;z < 50000;z++) {
                X.println(input[z]);
            }
        }
        try (PrintStream Y = new PrintStream("StorageY.txt")) {
            for (int z = 0;z < 50000;z++) {
                Y.println(input2[z]);
            }
        }
        try (PrintStream P = new PrintStream("StorageZ.txt")) {
            for (int z = 0;z < 50000;z++) {
                P.println(input3[z]);
            }
        }
        System.out.println("Inventory Saved!"); 
    }
}
