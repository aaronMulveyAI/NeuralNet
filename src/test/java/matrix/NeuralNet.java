package matrix;

import org.junit.jupiter.api.Test;
import org.nnet.matrix.Matrix;

public class NeuralNet {

    @Test
    public void test() {
        Matrix input = new Matrix(3, 1, (i) -> (i + 1));
        Matrix weights = new Matrix(3, 3, (i) -> (i + 1));
        Matrix bias = new Matrix(3, 1, (i) -> (i + 1));

        Matrix result = weights.multiply(input).modify((row, col, value) -> value + bias.get(row));

        System.out.println(input);
        System.out.println(weights);
        System.out.println(bias);
        System.out.println(result);
        
    }  
}
