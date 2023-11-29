package matrix;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.nnet.matrix.Matrix;


public class TestMatrix {


    @Test
    public void matrixCreation() {
        Matrix matrix = new Matrix(3,4);
        System.out.println(matrix);
    }

     @Test
    public void testToString() {
        Matrix matrix = new Matrix(2, 3);
        String expected = "2x3";
        String actual = matrix.toString(false);
        System.err.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testApplyInteger() {
        Matrix matrix = new Matrix(2, 2, (i) -> 1);
        Matrix expected = new Matrix(2, 2, (i) -> 2);
        Matrix actual = matrix.apply((i, value) -> value * 2);
        assertArrayEquals(expected.getMatrix(), actual.getMatrix());
    }

      @Test
    public void testApplyDouble() {
        Matrix matrix = new Matrix(2, 2, (i) -> 1);
        Matrix expected = new Matrix(2, 2, (i) -> 0.5);
        Matrix actual = matrix.apply((i, value) -> value * 0.5);
        assertArrayEquals(expected.getMatrix(), actual.getMatrix());
    }

    @Test
    public void testAddMatrices(){
        Matrix matrix1 = new Matrix(3, 3, (i) -> 1);
        Matrix matrix2 = new Matrix(3, 3, (i) -> 1);
        Matrix expected = new Matrix(3, 3, (i) -> 2);
        Matrix actual = matrix1.apply((i, value) -> value + matrix2.getMatrix()[i]);
        assertTrue(expected.equals(actual));
    }

    @Test
    public void testMultiply() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 6}, {7, 8}});
        Matrix expected = new Matrix(new double[][]{{19, 22}, {43, 50}});
        Matrix result = matrix1.multiply(matrix2);
        assertArrayEquals(expected.getMatrix(), result.getMatrix());
    }

    @Test
    public void testMultiplyWithDifferentDimensions() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        Matrix matrix2 = new Matrix(new double[][]{{7, 8}, {9, 10}});
        assertThrows(IllegalArgumentException.class, () -> matrix1.multiply(matrix2));
    }
    

    @Test
    public void testEqualsTrue(){
        Matrix matrix = new Matrix(2, 2, (i) -> 1);
        Matrix expected = new Matrix(2, 2, (i) -> 1);
        assertTrue(matrix.equals(expected));
    }

    @Test
    public void testEqualsFalse(){
        Matrix matrix = new Matrix(2, 2, (i) -> 1.00000000001);
        Matrix expected = new Matrix(2, 2, (i) -> 1);
        assertFalse(matrix.equals(expected));
    }


}


