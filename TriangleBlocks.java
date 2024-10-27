import java.util.Scanner;

public class TriangleBlocks {
    public static void main(String[] args ){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows in the triangle:");
        int n = scanner.nextInt();

        int totalBlocks =triangle(n);
        System.out.println("Total number of blocks: " + totalBlocks);

        scanner.close();
    }

    public static int triangle(int n){
        if(n==0){
            return 0;
        }
        return n+ triangle(n-1);
    }
}