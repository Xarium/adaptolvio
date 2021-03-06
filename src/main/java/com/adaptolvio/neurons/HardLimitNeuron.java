package com.adaptolvio.neurons;

import com.adaptolvio.Axon;
import com.adaptolvio.Neuron;

public class HardLimitNeuron extends Neuron {
    public HardLimitNeuron(String gene) {
        super(gene);
    }

    public double activationFunction() {
        return this.input > 0 ? 1 : -1;
    }

    @Override
    protected void sendSignal() {
        double value = this.activationFunction();
        for (Axon axon: this.axons) {
            axon.neuron.addInput(value);
        }
    }
}
