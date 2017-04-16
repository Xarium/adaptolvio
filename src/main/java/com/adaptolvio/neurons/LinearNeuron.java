package com.adaptolvio.neurons;

import com.adaptolvio.Axon;
import com.adaptolvio.Neuron;

public class LinearNeuron extends Neuron {
    public LinearNeuron(String gene) {
        super(gene);
    }

    public double activationFunction() {
        return this.input;
    }

    @Override
    protected void sendSignal() {
        double value = this.activationFunction();
        for (Axon axon: this.axons) {
            axon.neuron.addInput(value);
        }
    }
}
