import java.util.Scanner;

public class StringSeparator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string :");

        String input = scanner.nextLine();

        String result = allStar(input);
        System.out.println("the result is :"+result);

        scanner.close();
    }

    /*
    check if the length of input is less than 1 the return the input
    add star after every letter in the input
     */
    public static String allStar(String str) {
        if(str.length()<=1){
            return str;
        }
        return  str.charAt(0) + "*" + allStar(str.substring(1));
    }
}
