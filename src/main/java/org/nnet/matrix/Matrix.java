package org.nnet.matrix;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.nnet.matrix.producers.*;

/**
 * The Matrix class represents a mathematical matrix with rows and columns.
 * It provides various operations and functionalities for matrix manipulation.
 */
public class Matrix {

    /**
     * The number format for matrix representation in console.
     */
    private static final String NUMBER_FORMAT = "%+12.5f";
    
    /**
     * The error for matrix comparison.
     */
    private static final float ERROR = 0.0000000000000001f;
    
    /**
     * The number of rows and columns.
     */
    public int rows, cols;

    /**
     * The matrix as a one-dimensional array.
     */
    private double[] matrix;
  
    /**
     * Creates a new matrix with the specified dimensions.
     * @param rows - the number of rows
     * @param cols - the number of columns
     */
    public Matrix(int rows, int cols) {

		this.rows = rows;
		this.cols = cols;
		this.matrix = new double[rows * cols];
	}

    /**
     * Creates a new matrix with the specified dimensions and applies a function to each element.
     * @param rows - the number of rows
     * @param cols - the number of columns
     * @param producer - the function to apply
     */
	public Matrix(int rows, int cols, iProducer producer) {

		this(rows, cols);

		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = producer.produce(i);
		}
	}

    /**
     * Creates a new matrix with the specified values.
     * @param matrix - the matrix as a two-dimensional array
     */
    public Matrix(double[][] matrix) {
        
        this(matrix.length, matrix[0].length);
    
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                this.matrix[row * cols + col] = matrix[row][col];
            } 
        }
    }
    

    /**
     * Apply a function to each element of the matrix.
     * @param producer - the function to apply
     * @return a new matrix with the result of the function applied to each element
     */
    public Matrix apply(iIndexValueProducer producer) {
		Matrix result = new Matrix(rows, cols);

		for (int i = 0; i < matrix.length; i++) {
			result.getMatrix()[i] = producer.produce(i, matrix[i]);
		}

		return result;
	}

    /**
     * Matrix multiplication with another matrix.
     * @param matrix - the matrix to multiply with
     * @return a new matrix with the result of the multiplication
     */
    public Matrix multiply(Matrix matrix) {
        
        Matrix result = new Matrix(this.getRows(), matrix.getCols());

        if (this.getCols() != matrix.getRows()) {
            throw new IllegalArgumentException(
                "Matrix dimensions don't match: " +
                this.getRows() + "x" + 
                this.getCols() +  " cannot be multiplied with " +
                matrix.getRows() + "x" + 
                matrix.getCols());
        }

        
        for (int row = 0; row < result.getRows(); row++) {
            for (int col = 0; col < result.getCols() ; col++) {
                result.setValueOf(row, col, multiplyRowCol(this, matrix, row, col));
            }
        }
        return result;
    }

    /**
     * Matrix multiplication with another matrix using parallel processing.
     * @param matrix - the matrix to multiply with
     * @return a new matrix with the result of the multiplication
     */
    public Matrix multiplyParallel(Matrix matrix) {
        
        Matrix result = new Matrix(this.getRows(), matrix.getCols());

        if (this.getCols() != matrix.getRows()) {
            throw new IllegalArgumentException(
                "Matrix dimensions don't match: " +
                this.getRows() + "x" + 
                this.getCols() +  " cannot be multiplied with " +
                matrix.getRows() + "x" + 
                matrix.getCols());
        }

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

            for (int row = 0; row < result.getRows(); row++) {
                final int currentRow = row;
                executor.execute(() -> {
                    for (int col = 0; col < result.getCols(); col++) {
                        result.setValueOf(currentRow, col, multiplyRowCol(this, matrix, currentRow, col));
                    }
                });
            }

            executor.shutdown();
            try {
                executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return result;
    }

    /**
     * Multiply a row with a column.
     * @param matrix1 - the first matrix
     * @param matrix2 - the second matrix
     * @param row - the row to multiply
     * @param col - the column to multiply
     * @return the result of the multiplication
     */
    public double multiplyRowCol(Matrix matrix1, Matrix matrix2, int row, int col) {
        double result = 0;
        for (int i = 0; i < matrix1.getCols(); i++) {
            result += matrix1.getValueOf(row, i) * matrix2.getValueOf(i, col);
        }
        return result;
    }

    /**
     * Get the value at the specified row and column.
     * @param row - the row
     * @param col - the column
     * @return the value at the specified row and column
     */
    public double getValueOf(int row, int col) {
        return this.matrix[row * cols + col];
    }

    /**
     * Set the value at the specified row and column.
     * @param row - the row
     * @param col - the column
     * @param value - the value to set
     */
    public void setValueOf(int row, int col, double value) {
        this.matrix[row * cols + col] = value;
    }

    /**
     * Get the matrix as a one-dimensional array.
     * @return the matrix as a one-dimensional array
     */
    public double[] getMatrix() {
        return matrix;
    }

    /**
     * Get the number of columns.
     * @return the number of columns
     */
    public int getCols() {
        return cols;
    }

    /**
     * Get the number of rows.
     * @return the number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Hash code method for matrix comparison.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(this.matrix);
        result = prime * result + Objects.hash(this.rows, this.cols);
        return result;
    }

    /**
     * Equals method for matrix comparison.
     */
    @Override
    public boolean equals(Object obj) {
        
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof Matrix)) return false;
        Matrix other = (Matrix) obj;
        
        for (int i = 0; i < matrix.length; i++) {
            if(Math.abs(matrix[i] - other.matrix[i]) > ERROR) {
                return false;
            }
        }    
    
        return true;
    }

    /**
     * To string method for matrix representation in console
     * with option to show values.
     * @param showValues - true to show values, false to show only dimensions
     * @return 
     */
    public String toString(boolean showValues) {
		if(showValues) {
			return toString();
		}
		else {
			return rows + "x" + cols;
		}
	}

    /**
     * To string method for matrix representation in console.
     */
    public String toString() {

		StringBuilder sb = new StringBuilder();
		int index = 0;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				sb.append(String.format(NUMBER_FORMAT, matrix[index]));
				index++;
			}
			sb.append("\n");
		}

		return sb.toString();
	}
}
