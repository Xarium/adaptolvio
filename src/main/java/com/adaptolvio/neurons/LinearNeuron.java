package com.adaptolvio.neurons;

import com.adaptolvio.Neuron;

public class LinearNeuron extends Neuron {
    public LinearNeuron(String gene) {
        super(gene);
    }

    @Override
    protected double getActivationFunctionResult() {
        return this.input;
    }
}
