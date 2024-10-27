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
