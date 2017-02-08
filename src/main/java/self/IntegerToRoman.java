package self;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int thousands = num / 1000;
        for (int i = 0; i < thousands; i++) {
            sb.append('M');
        }
        int hundreds = (num / 100) % 10;
        sb.append(parseDigit(hundreds, 'C', 'D', 'M'));
        int tens = (num / 10) % 10;
        sb.append(parseDigit(tens, 'X', 'L', 'C'));
        int ones = num % 10;
        sb.append(parseDigit(ones, 'I', 'V', 'X'));
        return sb.toString();
    }

    private String parseDigit(int digit, char one, char five, char ten) {
        StringBuilder sb = new StringBuilder();
        if (digit <= 3) {
            for (int i = 0; i < digit; i++) {
                sb.append(one);
            }
        } else if (digit == 4) {
            sb.append(one).append(five);
        } else if (digit <= 8) {
            sb.append(five);
            for (int i = 0; i < digit - 5; i++) {
                sb.append(one);
            }
        } else {
            sb.append(one).append(ten);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        IntegerToRoman instance = new IntegerToRoman();
        System.out.println(instance.intToRoman(1));
        System.out.println(instance.intToRoman(10));
        System.out.println(instance.intToRoman(14));
        System.out.println(instance.intToRoman(100));
        System.out.println(instance.intToRoman(3999));
    }
}
