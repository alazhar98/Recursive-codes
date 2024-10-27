import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the base: ");
        int base = scanner.nextInt();

        System.out.println("Enter the exponent:");
        int n = scanner.nextInt();

        int result = powerN(base,n);
        System.out.println("result is :"+result);

        scanner.close();
    }

    public static int powerN(int base , int n ){
        if (n==1 ){
            return base;
        }
        return base * powerN(base,n-1);
    }
}
