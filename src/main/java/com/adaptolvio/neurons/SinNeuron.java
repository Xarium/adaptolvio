package com.adaptolvio.neurons;

import com.adaptolvio.Neuron;

public class SinNeuron extends Neuron {
    public SinNeuron(String gene) {
        super(gene);
    }

    @Override
    protected double getActivationFunctionResult() {
        return Math.sin(this.input);
    }
}
