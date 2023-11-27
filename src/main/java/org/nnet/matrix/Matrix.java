package org.nnet.matrix;

import java.util.Arrays;

public class Matrix {

    private static final String NUMBER_FORMAT = "%+12.5f";
    private int rows, cols;
    private double[][] matrix;
    public Matrix (int rows, int cols){
        this.cols = cols;
        this.rows = rows;
        this.matrix = new double[rows][cols];

        for (double[] row: matrix) {
            Arrays.fill(row, 0);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : matrix) {
            for (double value : row) {
                sb.append(String.format(NUMBER_FORMAT, value));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
