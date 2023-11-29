package org.nnet.matrix.producers;

/*
 * The iIndexValueProducer interface represents a function that accepts an index and a value
 */
public interface iIndexValueProducer {
    
    /**
     * Applies this function to the given arguments.
     * @param index - the index
     * @param value - the value
     * @return the function result
     */
    double produce(int index, double value);
}
