package org.nnet;

public class Main {

    public static void main(String[] args) {
        
        int[][][] L = new int[3][3][3];
        int[][][] L2 = new int[3][3][3];
        
        for (int i = 0; i < L.length; i++) {
            for (int j = 0; j < L[i].length; j++) {
                for (int k = 0; k < L[i][j].length; k++) {
                    L[i][j][k] = 0;
                    L2[i][j][k] = 0;
                }
            }
        }

        // normal
        L[0][0][0] = 1;
        L[1][0][0] = 1;
        L[2][0][0] = 1;
        L[2][1][0] = 1;
        L[2][2][0] = 1;

        // flipped
        L2[0][2][0] = 1;
        L2[1][2][0] = 1;
        L2[2][0][0] = 1;
        L2[2][1][0] = 1;
        L2[2][2][0] = 1;



        for (int i = 0; i < L.length; i++) {
            for (int j = 0; j < L.length; j++) {
                System.err.print(L[i][j][0] + " ");
            }            
            System.err.println();
        }
        
        System.err.println();
        
        for (int i = 0; i < L.length; i++) {
            for (int j = 0; j < L.length; j++) {
                System.err.print(L2[i][j][0] + " ");
            }            
            System.err.println();
        }
    }
}
