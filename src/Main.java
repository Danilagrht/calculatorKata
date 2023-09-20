import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String a = null;
        String b = null;
        int aDecimal;
        int bDecimal;
        char sign = 0;
        int expressionResult;

        String expression = scanner.nextLine();

        expression = expression.replaceAll("\\s+","");

        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*' || expression.charAt(i) == '/'){
                sign = expression.charAt(i);
                a = expression.substring(0, i);
                b = expression.substring(i+1);
                break;
            }
        }

        if(a == null){
            throw new Exception("Empty expression or math sign");
        }

        System.out.println(a+" "+b);

        aDecimal = romanToDecimal(a);
        bDecimal = romanToDecimal(b);

        System.out.println(decimalToRoman(calculation(aDecimal, bDecimal, sign)));
    }

    public static int romanToDecimal(String romanNum) throws Exception {
        int decimalNum = 0;
        int prevValue = 0;

        for (int i = romanNum.length() - 1; i >= 0; i--) {
            char ch = romanNum.charAt(i);

            try {
                Roman numeral = Roman.valueOf(String.valueOf(ch));

                int value = numeral.getValue();

                if (value < prevValue) {
                    decimalNum -= value;
                } else {
                    decimalNum += value;
                }
                prevValue = value;
            } catch(Exception e){
                throw new Exception("Invalid roman numeral: " + ch);
            }
        }
        return decimalNum;
    }

    public static String decimalToRoman(int num) throws Exception {
        if (num < 1 || num > 100) {
            throw new Exception("Number must be in range from 1 to 100");
        }

        StringBuilder roman = new StringBuilder();

        for (Roman numeral : Roman.values()) {
            while (num >= numeral.getValue()) {
                roman.append(numeral);
                num -= numeral.getValue();
            }
        }

        return roman.toString();
    }

    public static int calculation(int a, int b, char sign) throws Exception {
        return switch (sign) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new Exception("Unexpected sign or calculation error");
        };
    }
}