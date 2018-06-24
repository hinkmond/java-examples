public class JavaLongestCommonSequence {

    // Returns length of LCS for X[0..m-1], Y[0..n-1]
    private static int lcs(String X, String Y, int m, int n)
    {
        int[][] L = new int[m+1][n+1];

        // Following steps build L[m+1][n+1] in bottom up fashion. Note
        // that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i-1) == Y.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }

        // Print the table
        System.out.print("  ");
        for (int j=1; j<=n; j++) {
            System.out.print(" " + Y.charAt(j-1) + " ");
        }
        System.out.println();

        for (int i=1; i<=m; i++) {
            System.out.print(X.charAt(i-1) + " ");
            for (int j=1; j<=n; j++) {
                String formatted = String.format("%02d", L[i][j]);
                System.out.print(formatted + " ");
            }
            System.out.println();
        }

        // Following code is used to print LCS
        int index = L[m][n];
        int temp = index;

        // Create a character array to store the lcs string
        char[] lcs = new char[index+1];
        lcs[index] = ' '; // Set the terminating character

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m;
        int j = n;
        while (i > 0 && j > 0)
        {
            // If current character in X[] and Y are same, then
            // current character is part of LCS
            if (X.charAt(i-1) == Y.charAt(j-1))
            {
                // Put current character in result
                lcs[index-1] = X.charAt(i-1);

                // reduce values of i, j and index
                i--;
                j--;
                index--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i-1][j] > L[i][j-1])
                i--;
            else
                j--;
        }

        // Print the lcs
        System.out.print("LCS of \n"+X+"\n  and \n"+Y+"\n  is \n");
        for(int k=0;k<=temp;k++)
            System.out.print(lcs[k]);

        return L[m][n];
    }

    // driver program
    public static void main (String[] args)
    {
 		String X = "AGGTAB";
 		String Y = "GXTXAYB";
//        String X = "AGGTABCDEFG";
//        String Y = "GXTXAYBCDE";
// 	    String X = "AGGTABCDEFQGGHIJKGGMABNCO";
// 		String Y = "GXTXAYBXXCDEWFXGHIJKMXNXO";
        int m = X.length();
        int n = Y.length();
        System.out.println("\nLCS = " + lcs(X, Y, m, n));
    }
}