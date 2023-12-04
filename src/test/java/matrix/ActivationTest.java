package matrix;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.nnet.matrix.Matrix;

public class ActivationTest {
    private Random random = new Random();

    @Test
    public void testReLu() {
        int numberNeurons = 5;
        int numberInputs = 6;
        int inputSize = 4;

        Matrix input = new Matrix(inputSize, numberInputs, (i) -> random.nextDouble());
        Matrix weights = new Matrix(numberNeurons, inputSize, (i) -> random.nextGaussian());
        Matrix bias = new Matrix(numberNeurons, 1, (i) -> random.nextGaussian());

        Matrix result = weights.multiply(input).modify((row, col, value) -> value + bias.get(row));
        Matrix resultReLu = weights.multiply(input).modify((row, col, value) -> value + bias.get(row)).modify(value -> value > 0 ? value : 0);
        
        resultReLu.forEach((index, value) -> System.out.println(index + " " + value));

        System.out.println(result);
        System.out.println(resultReLu);   
    }
}
