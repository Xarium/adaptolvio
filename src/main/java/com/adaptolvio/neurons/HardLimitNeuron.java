package com.adaptolvio.neurons;

import com.adaptolvio.Neuron;

public class HardLimitNeuron extends Neuron {
    public HardLimitNeuron(String gene) {
        super(gene);
    }

    @Override
    protected double getActivationFunctionResult() {
        return this.input > 0 ? 1 : -1;
    }
}
