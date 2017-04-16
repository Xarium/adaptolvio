package com.adaptolvio.neurons;

import com.adaptolvio.Axon;
import com.adaptolvio.Neuron;

public class ReadNeuron extends Neuron {
    public ReadNeuron(String gene) {
        super(gene);
    }

    public int activationFunction() {
        return this.input > 0 ? 1 : -1;
    }

    @Override
    protected void sendSignal() {
        int value = this.activationFunction();
        for (Axon axon: this.axons) {
            axon.neuron.addRead(value * axon.weight);
        }
    }
}
