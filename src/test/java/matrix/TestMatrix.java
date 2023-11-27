package matrix;

import org.junit.jupiter.api.Test;
import org.nnet.matrix.Matrix;


public class TestMatrix {

    @Test
    public void matrixCreation() {
        Matrix matrix = new Matrix(3,4);
        System.out.println(matrix);
    }
}


