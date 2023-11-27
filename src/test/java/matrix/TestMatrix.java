package matrix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.nnet.matrix.Matrix;


public class TestMatrix {

    @Test
    public void matrixCreation() {
        Matrix matrix = new Matrix(3,4);
        String text = matrix.toString();
        System.out.println(matrix);
    }
}


