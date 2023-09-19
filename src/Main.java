import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        int b;
        char sign = 0;
        int expressionResult;

        String expression = scanner.nextLine();

        expression = expression.replaceAll("\\s+","");

        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*' || expression.charAt(i) == '/'){
                sign = expression.charAt(i);
                break;
            }

        }

        if(sign == 0){
            System.out.println("Выражение не имеет знака");
        }
    }

//    int parseRomanToArabic(String roman){
//        int arabic;
//        return arabic;
//    }
//
//    String parseArabicToRoman(){
//        String roman;
//        return roman;
//    }
}