package org.nnet.matrix.consumers;

/*
 * The iIndexValueConsumer interface represents a function that accepts an index and a value
 */
public interface iIndexValueConsumer {

    /**
     * Applies this function to the given arguments.
     * @param index - the index
     * @param value - the value
     * @return the function result
     */
    void consume(int index, double value);
} 