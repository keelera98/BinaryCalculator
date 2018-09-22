import java.util.*;
import java.lang.Math;
public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String args[]){
        int n = 0;
        int sig = 0;
        int finalNum;
        boolean valid = true;
        Scanner input = new Scanner(System.in);

        do {
            try {
                valid = true;
                System.out.printf("How many bits is the binary number: ");
                n = input.nextInt();
                if(n > 0){
                    valid = true;
                }else{
                    valid = false;
                    System.out.println("Please enter a valid number.");
                }
            }catch(InputMismatchException e){
                valid = false;
                System.out.println("Please enter a valid number.");
                input.nextLine();
            }
        }while(!valid);

        int[] bin = new int[n + 1];

        do{
            try {
                //cat = false;
                //this wasn't necessary, but makes it easier for user to type number
                System.out.printf("Are you entering the most significant bit first or the least? 0 for least, 1 for most: ");
                sig = input.nextInt();
                if((sig == 0) || (sig == 1)) {
                    valid = true;
                }else{
                    valid = false;
                }
            } catch (InputMismatchException e) {
                valid = false;
                System.out.println("Enter either a 1 or a 0.");
                input.nextLine();
            }
        }while(!valid);

        valid = true;

        //TODO: finish error checking
        if(sig == 0){
            InsertBegin(bin, n);
        }else{
            for (int i = 0; i < n; i++) {
                System.out.printf("Enter the most significant bit: ");
                bin[i] = input.nextInt();
            }
        }

        System.out.printf("The base 2 number is: ");
        for(int j = 0; j < n; j++){
            System.out.printf("%d", bin[j]);
        }

        finalNum = calcNumber(bin, n);

        System.out.println();

        System.out.printf("Base 10 number is: %d\n", finalNum);

        //TODO: add a 2's complement ability
    }

    public static void InsertBegin(int[] bin, int n){
        int start = 0;
        boolean valid = true;
        int end = n - 1;
        int temp;
        //TODO: finish error checking
        for (int i = 0; i < n; i++) {
            valid = true;
            System.out.printf("Enter the least significant bit: ");
            bin[i] = input.nextInt();
        }
        //this reverses the array
        while(start < end){
            //saves the first spot in the array
            temp = bin[start];
            //swaps a point on the left and a point on the right of the array
            bin[start] = bin[end];
            bin[end] = temp;
            //decreases the end and increases the start
            start++;
            end--;
        }
    }

    public static int calcNumber(int[] bin, int n){
        Double number = 0.0;
        int siz = n;
        for(int i = 0; i < siz; i++){
            if(bin[i] == 1) {
                number = number + Math.pow(2, n - 1);
                //System.out.println(" n value: " + n + " pow value: " + number);
                n--;
            }
        }
        //so we don't have any decimals
        return number.intValue();
    }
}
