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

    public static String allStar(String str) {
        if(str.length()<=1){
            return str;
        }
        return  str.charAt(0) + "*" + allStar(str.substring(1));
    }
}
