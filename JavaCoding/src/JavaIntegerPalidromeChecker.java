public class JavaIntegerPalidromeChecker {
    private static int testNumber = 185737581;

    private static boolean checkIntegerPalindrom(int x) {
        int digitLength = 1;
        int currPlace = x / 10;
        while (currPlace > 0) {
            digitLength++;
            currPlace /= 10;
        }

        int currInteger = x;
        System.out.print(currInteger + " -> ");
        for (int i=0; i<((digitLength/2)+1); i++) {
            int leftDigit = currInteger / (int) Math.pow(10, digitLength - (2 * i) - 1);
            int rightDigit = currInteger % 10;
            System.out.print(leftDigit + ":" + rightDigit + ", ");
            if (leftDigit != rightDigit) {
                System.out.println();
                return false;
            } else {
                currInteger = currInteger % (int) Math.pow(10, digitLength - (2 * i) - 1);
                currInteger /= 10;
            }
            System.out.print(currInteger + " -> ");
        }
        System.out.println();

        return true;
    }

    public static void main(String args[]) {
        // Check if integer is a palindrome
        System.out.println("This is the JavaIntegerPalidromeChecker!");

        boolean result = checkIntegerPalindrom(testNumber);
        System.out.println("Result = " + result);
    }
}
