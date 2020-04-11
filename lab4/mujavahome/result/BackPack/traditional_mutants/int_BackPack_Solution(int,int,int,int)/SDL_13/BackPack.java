// This is a mutant program.
// Author : ysma

import java.util.Arrays;


public class BackPack
{

    public  boolean isEqual( int m, int n, int[][] a, int[][] b )
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public  int[][] BackPack_Solution( int m, int n, int[] w, int[] p )
    {
        int[][] c = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            c[i][0] = 0;
        }
        for (int j = 0; j < m + 1; j++) {
            c[0][j] = 0;
        }
        return c;
    }

}
