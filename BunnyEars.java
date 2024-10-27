import java.util.Scanner;

public class BunnyEars {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of bunnies:");
        int n = scanner.nextInt();

        int total = bunnyEars2(n);

        System.out.println("Total numbers of ears : "+total);

        scanner.close();
    }
    /*
    if n =0 then that mean no bunnies
    if n is odd number then add 2 ears for the current bunny and call the function for n - 1
    if n is even then add 3 ears for the current bunny and call the function for n - 1

     */
    public static int bunnyEars2(int n){
        if(n==0){
            return 0;

        }
        if (n % 2 == 1) {
            return 2 + bunnyEars2(n - 1);
        }
        else {
            return 3 + bunnyEars2(n - 1);
        }
    }
}
